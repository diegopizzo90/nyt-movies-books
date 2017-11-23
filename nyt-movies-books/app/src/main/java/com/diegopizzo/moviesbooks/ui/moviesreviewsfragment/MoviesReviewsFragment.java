package com.diegopizzo.moviesbooks.ui.moviesreviewsfragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.model.movies.Result;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpFragment;
import com.diegopizzo.moviesbooks.ui.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class MoviesReviewsFragment extends AbstractMvpFragment<MoviesReviewsFragmentContract.Presenter>
        implements MoviesReviewsFragmentContract.View {

    public static final String TAG = "MoviesReviewsFragment";
    public static final String TITLE = "Movies Reviews";
    public static final String BUNDLE_MOVIES_LIST = "bundleMoviesList";
    @BindView(R.id.moviesReclyclerView)
    RecyclerView moviesReclyclerView;
    private OnFragmentInteractionListener onFragmentInteractionListener;
    private EndlessRecyclerViewScrollListener scrollListener;
    private MoviesReviewsAdapter moviesReviewsAdapter;

    public static MoviesReviewsFragment newInstance(final Bundle bundle) {
        final MoviesReviewsFragment moviesReviewsFragment = new MoviesReviewsFragment();
        if (bundle != null) {
            moviesReviewsFragment.setArguments(bundle);
        }
        return moviesReviewsFragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moviesReviewsAdapter = new MoviesReviewsAdapter(getContext());
        if (savedInstanceState == null) {
            presenter.moviesReviews(0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView();
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            final List<Result> resultList = savedInstanceState.getParcelableArrayList(BUNDLE_MOVIES_LIST);
            moviesReviewsAdapter.swapItems(resultList);
        }
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(BUNDLE_MOVIES_LIST, (ArrayList<? extends Parcelable>) moviesReviewsAdapter.getResultList());
    }

    private void setRecyclerView() {
        // First param is number of columns and second param is orientation i.e Vertical or Horizontal
        final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                OrientationHelper.VERTICAL);
        // Attach the layout manager to the recycler view
        moviesReclyclerView.setLayoutManager(staggeredGridLayoutManager);
        moviesReclyclerView.setAdapter(moviesReviewsAdapter);

        scrollListener = new EndlessRecyclerViewScrollListener(staggeredGridLayoutManager) {
            @Override
            public void onLoadMore(final int page, final int totalItemsCount, final RecyclerView view) {
                presenter.moviesReviews(totalItemsCount);
            }
        };

        moviesReclyclerView.addOnScrollListener(scrollListener);
    }

    @Override
    public void setDataOnRecyclerView(final Movies movies) {
        if (movies != null) {
            moviesReviewsAdapter.swapItems(movies.getResults());
        }
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
