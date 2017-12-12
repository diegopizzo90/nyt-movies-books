package com.diegopizzo.moviesbooks.ui.mainactivity;

/**
 * Created by diegopizzo on 12/12/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private final MainActivityContract.View view;

    public MainActivityPresenter(final MainActivityContract.View view) {
        this.view = view;
    }


}
