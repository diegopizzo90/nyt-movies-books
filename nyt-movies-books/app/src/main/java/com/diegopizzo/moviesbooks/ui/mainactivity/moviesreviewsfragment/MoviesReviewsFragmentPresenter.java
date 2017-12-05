package com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment;

import android.util.Log;

import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class MoviesReviewsFragmentPresenter implements MoviesReviewsFragmentContract.Presenter {

    private final MoviesInteractor moviesInteractor;
    private final MoviesReviewsFragmentContract.View view;

    public MoviesReviewsFragmentPresenter(final MoviesInteractor moviesInteractor, final MoviesReviewsFragmentContract.View view) {
        this.moviesInteractor = moviesInteractor;
        this.view = view;
    }

    @Override
    public void moviesReviews(final Integer offset, final boolean refresh, final ServiceConstants.OrderMovies orderBy) {

        final Single<Movies> moviesObservable = moviesInteractor.getMoviesReviews(offset, orderBy);

        final Disposable disposable = moviesObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> {
                    if (offset == 0 && !refresh) {
                        view.showLoadingMovies();
                    }
                    view.showSwipyRefreshLayout();
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        view.hideSwipyRefreshLayout();
                        view.showContentMovies();
                    }
                })
                .subscribe(movies -> {
                    if (movies != null) {
                        if (refresh) {
                            view.refreshDataOnRecyclerView(movies);
                        } else {
                            view.setDataOnRecyclerView(movies);
                        }
                        Log.i("Movies", "Ok - Offset: " + offset + " Refresh: " + refresh);
                    } else {
                        Log.i("Movies", "It's empty!");

                    }
                }, throwable -> {
                    view.showMessage("Errore " + throwable.getMessage());
                    view.hideSwipyRefreshLayout();
                    view.showContentMovies();
                    Log.e("error", throwable.getMessage());
                });

    }

    @Override
    public void resumeData(final int offset, final ServiceConstants.OrderMovies orderMovies) {
        for (int i = 0; i <= offset; i = i + 20) {
            moviesReviews(i, false, orderMovies);
        }
    }
}
