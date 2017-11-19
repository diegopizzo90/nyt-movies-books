package com.diegopizzo.moviesbooks.ui.moviesreviewsfragment;

import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;

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
}
