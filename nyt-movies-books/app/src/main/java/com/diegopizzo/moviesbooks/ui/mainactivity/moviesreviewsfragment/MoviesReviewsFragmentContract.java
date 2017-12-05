package com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment;

import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;
import com.diegopizzo.moviesbooks.config.mvp.MvpPresenter;
import com.diegopizzo.moviesbooks.config.mvp.MvpView;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class MoviesReviewsFragmentContract {

    interface View extends MvpView {
        void setDataOnRecyclerView(Movies movies);

        void refreshDataOnRecyclerView(Movies movies);

        void showSwipyRefreshLayout();

        void hideSwipyRefreshLayout();

        void showContentMovies();

        void showLoadingMovies();
    }

    interface Presenter extends MvpPresenter {
        void moviesReviews(Integer offset, boolean refresh, ServiceConstants.OrderMovies orderBy);

        void resumeData(int offset, ServiceConstants.OrderMovies orderMovies);
    }
}
