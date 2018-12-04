package com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviews.Movies;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpFragment;
import com.diegopizzo.moviesbooks.ui.utils.EndlessRecyclerViewScrollListener;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import butterknife.BindView;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class MoviesReviewsFragment extends AbstractMvpFragment<MoviesReviewsFragmentContract.Presenter>
        implements MoviesReviewsFragmentContract.View {

    public static final String TAG = "MoviesReviewsFragment";
    public static final int VIEW_PAGER_POSITION = 0;
    public static final String TITLE = "Movies Reviews";
    public static final String TOT_ITEM_KEY = "totalItemKey";
    public static final String LAYOUT_POSITION_KEY = "layoutPositionKey";
    public static final String ORDER_BY_KEY = "orderByKey";
    private static final int SPAN_COUNT = 2;

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
    private int totalItems;
    private int layoutPosition;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

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
        orderBy = ServiceConstants.OrderMovies.BY_OPENING_DATE;
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
        setRecyclerView();
        setSwypeRefreshLayout();
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            restoreData(savedInstanceState);
            moviesReclyclerView.post(() -> moviesReclyclerView.scrollToPosition(layoutPosition));
        } else {
            scrollListener.onLoadMore(0, totalItems, moviesReclyclerView);
        }
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TOT_ITEM_KEY, totalItems);
        outState.putString(ORDER_BY_KEY, orderBy.getValue());
        layoutPosition = getPositionLayout(staggeredGridLayoutManager.findFirstVisibleItemPositions(null));
        outState.putInt(LAYOUT_POSITION_KEY, layoutPosition);
    }

    private int getPositionLayout(final int[] positions) {
        for (int i = SPAN_COUNT - 1; i >= 0; i--) {
            if (positions[i] != -1) {
                return positions[i];
            }
        }
        return 1;
    }

    private void restoreData(final Bundle savedInstanceState) {
        totalItems = savedInstanceState.getInt(TOT_ITEM_KEY);
        scrollListener.setPreviousTotalItemsCount(totalItems);
        orderBy = ServiceConstants.OrderMovies.fromValue(savedInstanceState.getString(ORDER_BY_KEY));
        layoutPosition = savedInstanceState.getInt(LAYOUT_POSITION_KEY);
        presenter.resumeData(totalItems, orderBy);
    }

    private void setRecyclerView() {
        // First param is number of columns and second param is orientation i.e Vertical or Horizontal
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(SPAN_COUNT,
                OrientationHelper.VERTICAL);
        // Attach the layout manager to the recycler view
        moviesReclyclerView.setLayoutManager(staggeredGridLayoutManager);
        moviesReclyclerView.setAdapter(moviesReviewsAdapter);

        scrollListener = new EndlessRecyclerViewScrollListener(staggeredGridLayoutManager) {
            @Override
            public void onLoadMore(final int page, final int totalItemsCount, final RecyclerView view) {
                presenter.moviesReviews(totalItemsCount, false, orderBy);
                totalItems = totalItemsCount;
            }

            @Override
            public void onScrolled(final RecyclerView view, final int dx, final int dy) {
                super.onScrolled(view, dx, dy);
                Log.i("scroll", "" + dy);
                onFragmentInteractionListener.collapseSearchBar(dy);
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
        void collapseSearchBar(float dy);
    }
}
