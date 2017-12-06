package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

import android.util.Log;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.business.network.model.movies.MovieDetails;
import com.diegopizzo.moviesbooks.business.network.model.movies.ResultDetails;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by diegopizzo on 27/11/2017.
 */

public class ItemDetailsActivityPresenter implements ItemDetailsActivityContract.Presenter {

    private final ItemDetailsActivityContract.View view;
    private final MoviesInteractor moviesInteractor;
    private final BooksInteractor booksInteractor;

    public ItemDetailsActivityPresenter(final ItemDetailsActivityContract.View view, final MoviesInteractor moviesInteractor, final BooksInteractor booksInteractor) {
        this.view = view;
        this.moviesInteractor = moviesInteractor;
        this.booksInteractor = booksInteractor;
    }


    @Override
    public void getSelectedMovieDetails(final String query) {
        final Single<MovieDetails> movieDetailsSingle = moviesInteractor.getMovieReview(query);
        movieDetailsSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> view.showLoading())
                .doFinally(view::showContent)
                .subscribe(movieDetails -> {
                    if (movieDetails != null && movieDetails.getResults() != null) {
                        final ResultDetails resultDetails = movieDetails.getResults().get(0);
                        view.setDataOfMovieReview(resultDetails);
                    }
                }, throwable -> {
                    view.showContent();
                    view.showMessage("Errore " + throwable.getMessage());
                    Log.e("error", throwable.getMessage());
                });
    }

}
