package com.diegopizzo.moviesbooks.ui.booksfragment;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;

/**
 * Created by diegopizzo on 19/11/2017.
 */

public class BooksFragmentPresenter implements BooksFragmentContract.Presenter {

    private final BooksFragmentContract.View view;
    private final BooksInteractor booksInteractor;

    public BooksFragmentPresenter(final BooksFragmentContract.View view, final BooksInteractor booksInteractor) {
        this.view = view;
        this.booksInteractor = booksInteractor;
    }
}
