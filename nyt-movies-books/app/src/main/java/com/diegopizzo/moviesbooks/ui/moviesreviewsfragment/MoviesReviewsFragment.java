package com.diegopizzo.moviesbooks.ui.moviesreviewsfragment;

import android.content.Context;
import android.os.Bundle;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpFragment;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class MoviesReviewsFragment extends AbstractMvpFragment<MoviesReviewsFragmentContract.Presenter>
        implements MoviesReviewsFragmentContract.View {

    public static final String TAG_MOVIES_REVIEWS_FRAGMENT = "MoviesReviewsFragment";
    private OnFragmentInteractionListener onFragmentInteractionListener;

    public static MoviesReviewsFragment newInstance(final Bundle bundle) {
        final MoviesReviewsFragment moviesReviewsFragment = new MoviesReviewsFragment();
        if (bundle != null) {
            moviesReviewsFragment.setArguments(bundle);
        }
        return moviesReviewsFragment;
    }

    @Override
    protected void inject() {
        DaggerMoviesReviewsFragmentComponent.builder()
                .applicationComponent(((MoviesBooksApplication) getActivity().getApplication()).getApplicationComponent())
                .moviesReviewsFragmentModule(new MoviesReviewsFragmentModule(this)).build().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.movies_reviews_layout;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            onFragmentInteractionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteractionListener = null;
    }

    public interface OnFragmentInteractionListener {
    }
}
