package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

import com.diegopizzo.moviesbooks.business.network.model.movies.ResultDetails;
import com.diegopizzo.moviesbooks.config.mvp.MvpPresenter;
import com.diegopizzo.moviesbooks.config.mvp.MvpView;

/**
 * Created by diegopizzo on 27/11/2017.
 */

public class ItemDetailsActivityContract {

    interface View extends MvpView {
        void setDataOfMovieReview(ResultDetails resultDetails);
    }

    interface Presenter extends MvpPresenter {
        void getSelectedMovieDetails(String query);
    }
}
