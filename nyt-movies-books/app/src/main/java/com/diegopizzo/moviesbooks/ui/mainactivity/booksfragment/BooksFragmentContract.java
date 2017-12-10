package com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment;

import com.diegopizzo.moviesbooks.business.network.model.books.bestsellerlist.BestsellerList;
import com.diegopizzo.moviesbooks.config.mvp.MvpPresenter;
import com.diegopizzo.moviesbooks.config.mvp.MvpView;

/**
 * Created by diegopizzo on 19/11/2017.
 */

public class BooksFragmentContract {

    interface View extends MvpView {
        void showLoadingBestSeller();

        void showContentBestSeller();

        void showSwipyRefreshLayout();

        void hideSwipyRefreshLayout();

        void setDataOnRecyclerView(BestsellerList bestsellerList);
    }

    interface Presenter extends MvpPresenter {
        void bestSellers(boolean refresh);
    }
}
