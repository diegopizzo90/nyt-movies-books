package com.diegopizzo.moviesbooks.config.dagger;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.business.network.cache.MoviesStore;
import com.diegopizzo.moviesbooks.business.network.service.BooksService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diegopizzo on 27/09/2017.
 */

@Module
public class InteractorModule {

    @Provides
    @Singleton
    BooksInteractor providesBooksServiceInteractor(final BooksService booksService) {
        return new BooksInteractor(booksService);
    }

    @Provides
    @Singleton
    MoviesInteractor providesMoviesServiceInteractor(final MoviesStore moviesStore) {
        return new MoviesInteractor(moviesStore);
    }
}
