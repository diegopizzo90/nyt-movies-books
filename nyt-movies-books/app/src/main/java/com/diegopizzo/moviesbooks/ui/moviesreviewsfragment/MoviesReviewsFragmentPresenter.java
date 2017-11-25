package com.diegopizzo.moviesbooks.ui.moviesreviewsfragment;

import android.util.Log;

import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
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
    public void moviesReviews(final Integer offset, final boolean refresh) {

        final Observable<Movies> moviesObservable = moviesInteractor.getMoviesReviews(ServiceConstants.ResourceTypeMovies.ALL,
                offset, ServiceConstants.OrderMovies.BY_PUBBLICATION_DATE);

        final Disposable disposable = moviesObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(final Disposable disposable) throws Exception {
                        if (offset == 0 && !refresh) {
                            view.showLoadingMovies();
                        }
                        view.showSwipyRefreshLayout();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        view.hideSwipyRefreshLayout();
                        view.showContentMovies();
                    }
                })
                .subscribe(new Consumer<Movies>() {
                    @Override
                    public void accept(final Movies movies) throws Exception {
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
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        view.showMessage("Errore " + throwable.getMessage());
                        view.hideSwipyRefreshLayout();
                        view.showContentMovies();
                        Log.e("error", throwable.getMessage());
                    }
                });

    }
}
