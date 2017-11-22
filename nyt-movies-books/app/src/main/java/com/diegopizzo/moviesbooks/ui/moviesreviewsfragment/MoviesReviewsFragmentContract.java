package com.diegopizzo.moviesbooks.ui.moviesreviewsfragment;

import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.config.mvp.MvpPresenter;
import com.diegopizzo.moviesbooks.config.mvp.MvpView;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class MoviesReviewsFragmentContract {

    interface View extends MvpView {
        void setDataOnRecyclerView(Movies movies);
    }

    interface Presenter extends MvpPresenter {
        void moviesReviews(Integer offset);
    }
}
