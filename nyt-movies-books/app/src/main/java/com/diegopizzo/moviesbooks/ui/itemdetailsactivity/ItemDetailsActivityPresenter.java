package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

/**
 * Created by diegopizzo on 27/11/2017.
 */

public class ItemDetailsActivityPresenter implements ItemDetailsActivityContract.Presenter {

    private final ItemDetailsActivityContract.View view;

    public ItemDetailsActivityPresenter(final ItemDetailsActivityContract.View view) {
        this.view = view;
    }
}
