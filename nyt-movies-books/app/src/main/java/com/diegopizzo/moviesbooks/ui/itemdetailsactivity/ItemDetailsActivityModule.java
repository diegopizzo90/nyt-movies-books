package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.config.dagger.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diegopizzo on 27/11/2017.
 */

@Module
public class ItemDetailsActivityModule {


    private final ItemDetailsActivityContract.View view;

    public ItemDetailsActivityModule(final ItemDetailsActivityContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public ItemDetailsActivityContract.Presenter providePresenter(final MoviesInteractor moviesInteractor, final BooksInteractor booksInteractor) {
        return new ItemDetailsActivityPresenter(view, moviesInteractor, booksInteractor);
    }
}
