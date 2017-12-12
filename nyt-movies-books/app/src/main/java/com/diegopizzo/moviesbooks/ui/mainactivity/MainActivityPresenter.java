package com.diegopizzo.moviesbooks.ui.mainactivity;

import android.text.TextUtils;
import android.util.Log;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.ui.ItemSuggestionConverter;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by diegopizzo on 12/12/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private final MainActivityContract.View view;
    private final MoviesInteractor moviesInteractor;
    private final BooksInteractor booksInteractor;

    MainActivityPresenter(final MainActivityContract.View view, final MoviesInteractor moviesInteractor, final BooksInteractor booksInteractor) {
        this.view = view;
        this.moviesInteractor = moviesInteractor;
        this.booksInteractor = booksInteractor;
    }

    @Override
    public void getItemsSearched(final String query) {
        if (!TextUtils.isEmpty(query)) {
            Single.zip(moviesInteractor.getMovieReview(query), booksInteractor.findBestsellers(query),
                    (movieDetails, booksFound) -> new ItemSuggestionConverter(movieDetails, booksFound).createSuggestionList())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> view.showProgressSearchView())
                    .doFinally(view::hideProgressSearchView)
                    .subscribe(itemSuggestionList -> {
                        view.swapSearchView(itemSuggestionList);
                    }, throwable -> {
                        view.hideProgressSearchView();
                        view.showMessage("Search Error " + throwable.getMessage());
                        Log.e("Search Error", throwable.getMessage());
                    });
        }
    }
}
