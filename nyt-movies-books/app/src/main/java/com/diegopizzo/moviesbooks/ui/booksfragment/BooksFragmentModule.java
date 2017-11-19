package com.diegopizzo.moviesbooks.ui.booksfragment;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.config.dagger.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diegopizzo on 19/11/2017.
 */

@Module
public class BooksFragmentModule {

    private final BooksFragmentContract.View view;

    public BooksFragmentModule(final BooksFragmentContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    public BooksFragmentContract.Presenter providePresenter(final BooksInteractor booksInteractor) {
        return new BooksFragmentPresenter(view, booksInteractor);
    }
}
