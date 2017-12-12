package com.diegopizzo.moviesbooks.ui.mainactivity;

import com.diegopizzo.moviesbooks.config.mvp.MvpPresenter;
import com.diegopizzo.moviesbooks.config.mvp.MvpView;
import com.diegopizzo.moviesbooks.ui.ItemSuggestion;

import java.util.List;

/**
 * Created by diegopizzo on 12/12/2017.
 */

public class MainActivityContract {

    interface View extends MvpView {
        void hideProgressSearchView();

        void showProgressSearchView();

        void swapSearchView(List<ItemSuggestion> itemSuggestionList);
    }

    interface Presenter extends MvpPresenter {
        void getItemsSearched(String query);
    }
}
