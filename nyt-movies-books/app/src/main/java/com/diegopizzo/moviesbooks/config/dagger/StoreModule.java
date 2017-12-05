package com.diegopizzo.moviesbooks.config.dagger;

import com.diegopizzo.moviesbooks.business.network.cache.BooksStore;
import com.diegopizzo.moviesbooks.business.network.cache.MoviesStore;
import com.diegopizzo.moviesbooks.business.network.service.BooksService;
import com.diegopizzo.moviesbooks.business.network.service.MoviesService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diegopizzo on 05/12/2017.
 */

@Module
public class StoreModule {

    @Provides
    @Singleton
    MoviesStore providesMoviesStore(final MoviesService moviesService) {
        return new MoviesStore(moviesService);
    }

    @Provides
    @Singleton
    BooksStore providesBooksStore(final BooksService booksService) {
        return new BooksStore(booksService);
    }
}
