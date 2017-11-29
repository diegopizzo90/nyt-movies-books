package com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.model.movies.Result;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpFragment;
import com.diegopizzo.moviesbooks.ui.EndlessRecyclerViewScrollListener;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class MoviesReviewsFragment extends AbstractMvpFragment<MoviesReviewsFragmentContract.Presenter>
        implements MoviesReviewsFragmentContract.View {

    public static final String TAG = "MoviesReviewsFragment";
    public static final int VIEW_PAGER_POSITION = 0;
    public static final String TITLE = "Movies Reviews";
    public static final String BUNDLE_MOVIES_LIST = "bundleMoviesList";
    @BindView(R.id.moviesReclyclerView)
    RecyclerView moviesReclyclerView;
    @BindView(R.id.swipyrefreshlayoutMovies)
    SwipyRefreshLayout swipyRefreshLayout;
    @BindView(R.id.progressBarMovies)
    ProgressBar progressBarMovies;
    private OnFragmentInteractionListener onFragmentInteractionListener;
    private EndlessRecyclerViewScrollListener scrollListener;
    private MoviesReviewsAdapter moviesReviewsAdapter;
    private ServiceConstants.OrderMovies orderBy;

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
        setHasOptionsMenu(true);
        orderBy = ServiceConstants.OrderMovies.BY_PUBBLICATION_DATE;
        moviesReviewsAdapter = new MoviesReviewsAdapter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            presenter.moviesReviews(0, false, orderBy);
        }
        setRecyclerView();
        setSwypeRefreshLayout();
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            final Parcelable listParcelable = savedInstanceState.getParcelable(BUNDLE_MOVIES_LIST);
            final List<Result> resultList = Parcels.unwrap(listParcelable);
            moviesReviewsAdapter.swapItems(resultList);
        }
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        final Parcelable listParcelable = Parcels.wrap(moviesReviewsAdapter.getResultList());
        outState.putParcelable(BUNDLE_MOVIES_LIST, listParcelable);
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.by_opening_date:
                orderBy = ServiceConstants.OrderMovies.BY_OPENING_DATE;
                presenter.moviesReviews(0, true, orderBy);
                return true;
            case R.id.by_title:
                orderBy = ServiceConstants.OrderMovies.BY_TITLE;
                presenter.moviesReviews(0, true, orderBy);
                return true;
            case R.id.by_publication_date:
                orderBy = ServiceConstants.OrderMovies.BY_PUBBLICATION_DATE;
                presenter.moviesReviews(0, true, orderBy);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
                presenter.moviesReviews(totalItemsCount, false, orderBy);
            }
        };

        moviesReclyclerView.addOnScrollListener(scrollListener);
    }

    private void setSwypeRefreshLayout() {
        swipyRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(final SwipyRefreshLayoutDirection direction) {
                presenter.moviesReviews(0, true, orderBy);
                Log.i("Movies", "refresh");
            }
        });
    }

    @Override
    public void setDataOnRecyclerView(final Movies movies) {
        moviesReviewsAdapter.swapItems(movies.getResults());
    }

    @Override
    public void refreshDataOnRecyclerView(final Movies movies) {
        moviesReviewsAdapter.refreshItems(movies.getResults());
    }

    @Override
    public void showSwipyRefreshLayout() {
        swipyRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideSwipyRefreshLayout() {
        swipyRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showLoadingMovies() {
        progressBarMovies.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContentMovies() {
        progressBarMovies.setVisibility(View.GONE);
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
