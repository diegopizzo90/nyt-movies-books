package com.diegopizzo.moviesbooks.config.dagger;

import android.content.Context;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by diegopizzo on 25/09/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, InteractorModule.class, NetworkModule.class, StoreModule.class})
public interface ApplicationComponent {

    MoviesInteractor providesMoviesServiceInteractor();

    BooksInteractor providesBooksServiceInteractor();

    class Injector {
        public static ApplicationComponent getComponent(final Context c) {
            return ((MoviesBooksApplication) c.getApplicationContext()).getApplicationComponent();
        }
    }
}
