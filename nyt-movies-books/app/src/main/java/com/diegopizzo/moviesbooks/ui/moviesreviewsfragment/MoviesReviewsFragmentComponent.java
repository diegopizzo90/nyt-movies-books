package com.diegopizzo.moviesbooks.ui.moviesreviewsfragment;

import com.diegopizzo.moviesbooks.config.dagger.ApplicationComponent;
import com.diegopizzo.moviesbooks.config.dagger.FragmentScope;

import dagger.Component;

/**
 * Created by diegopizzo on 18/11/2017.
 */

@FragmentScope
@Component(dependencies = ApplicationComponent.class, modules = MoviesReviewsFragmentModule.class)
public interface MoviesReviewsFragmentComponent {

    void inject(MoviesReviewsFragment moviesReviewsFragment);
}
