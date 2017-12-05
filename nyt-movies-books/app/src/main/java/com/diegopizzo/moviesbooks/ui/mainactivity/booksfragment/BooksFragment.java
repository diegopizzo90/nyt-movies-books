package com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.business.network.model.books.BestsellerList;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpFragment;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import butterknife.BindView;

/**
 * Created by diegopizzo on 19/11/2017.
 */

public class BooksFragment extends AbstractMvpFragment<BooksFragmentContract.Presenter> implements BooksFragmentContract.View {

    public static final String TAG = "BooksFragment";
    public static final String TITLE = "BestSellers";
    public static final int VIEW_PAGER_POSITION = 1;
    private static final String BUNDLE_BEST_SELLERS = "BundleBestSellers";
    @BindView(R.id.bestSellerRecyclerView)
    RecyclerView bestSellerRecyclerView;
    @BindView(R.id.progressBarBestSeller)
    ProgressBar progressBarBestSeller;
    @BindView(R.id.swipyrefreshlayoutBestSellers)
    SwipyRefreshLayout swipyRefreshLayout;
    private BestSellerListAdapter bestSellerListAdapter;
    private OnFragmentInteractionListener onFragmentInteractionListener;

    public static BooksFragment newInstance(final Bundle bundle) {
        final BooksFragment booksFragment = new BooksFragment();
        if (bundle != null) {
            booksFragment.setArguments(bundle);
        }
        return booksFragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bestSellerListAdapter = new BestSellerListAdapter();
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            presenter.bestSellers(false);
        }
        setSwypeRefreshLayout();
        setBestSellerRecyclerView();
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
        }
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void setBestSellerRecyclerView() {
        // First param is number of columns and second param is orientation i.e Vertical or Horizontal
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        // Attach the layout manager to the recycler view
        bestSellerRecyclerView.setLayoutManager(gridLayoutManager);
        bestSellerRecyclerView.setAdapter(bestSellerListAdapter);
    }

    private void setSwypeRefreshLayout() {
        swipyRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(final SwipyRefreshLayoutDirection direction) {
                presenter.bestSellers(true);
                Log.i("BestSeller", "refresh");
            }
        });
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
    public void showLoadingBestSeller() {
        progressBarBestSeller.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContentBestSeller() {
        progressBarBestSeller.setVisibility(View.GONE);
    }

    @Override
    public void setDataOnRecyclerView(final BestsellerList bestsellerList) {
        bestSellerListAdapter.swapItems(bestsellerList.getResults().getListResults());
    }

    @Override
    protected void inject() {
        DaggerBooksFragmentComponent.builder()
                .applicationComponent(((MoviesBooksApplication) getActivity().getApplication()).getApplicationComponent())
                .booksFragmentModule(new BooksFragmentModule(this)).build().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.bestsellers_list_layout;
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
