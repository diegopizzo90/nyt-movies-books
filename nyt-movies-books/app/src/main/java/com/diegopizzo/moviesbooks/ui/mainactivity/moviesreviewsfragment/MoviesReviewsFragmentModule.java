package com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment;

import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.config.dagger.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diegopizzo on 18/11/2017.
 */

@Module
public class MoviesReviewsFragmentModule {

    private final MoviesReviewsFragmentContract.View view;

    public MoviesReviewsFragmentModule(final MoviesReviewsFragmentContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    public MoviesReviewsFragmentContract.Presenter providePresenter(final MoviesInteractor moviesInteractor) {
        return new MoviesReviewsFragmentPresenter(moviesInteractor, view);
    }
}
