package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;

/**
 * Created by diegopizzo on 27/11/2017.
 */

public class ItemDetailsActivityPresenter implements ItemDetailsActivityContract.Presenter {

    private final ItemDetailsActivityContract.View view;
    private final MoviesInteractor moviesInteractor;
    private final BooksInteractor booksInteractor;

    public ItemDetailsActivityPresenter(final ItemDetailsActivityContract.View view, final MoviesInteractor moviesInteractor, final BooksInteractor booksInteractor) {
        this.view = view;
        this.moviesInteractor = moviesInteractor;
        this.booksInteractor = booksInteractor;
    }


}
