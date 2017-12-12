package com.diegopizzo.moviesbooks.ui.mainactivity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpActivity;
import com.diegopizzo.moviesbooks.ui.ItemSuggestion;
import com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment.BooksFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.copyrightdialogfragment.CopyrightDialogFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment.MoviesReviewsFragment;
import com.diegopizzo.moviesbooks.ui.utils.ThemeUtils;

import java.util.List;

public class MainActivity extends AbstractMvpActivity<MainActivityContract.Presenter> implements MoviesReviewsFragment.OnFragmentInteractionListener,
        BooksFragment.OnFragmentInteractionListener, MainActivityContract.View {


    private static final int LENGHT_QUERY_MIN_SEARCH = 3;
    private FloatingSearchView floatingSearchView;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mViewPagerAdapter;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar();
        setFloatingSearchView();
        setViewPager();
    }

    @Override
    protected void inject() {
        DaggerMainActivityComponent.builder()
                .applicationComponent(((MoviesBooksApplication) getApplication()).getApplicationComponent())
                .mainActivityModule(new MainActivityModule(this)).build().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected View getRootLayoutView() {
        return null;
    }

    public void setViewPager() {
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayoutMain);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                invalidateOptionsMenu();
                eventOnPageChanged();
            }

            @Override
            public void onPageSelected(final int position) {
                invalidateOptionsMenu();
                eventOnPageChanged();
            }

            @Override
            public void onPageScrollStateChanged(final int state) {
            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public void collapseSearchBar(final float dy) {
        if (dy > 0) {
            floatingSearchView.setTranslationY(floatingSearchView.getHeight());
        } else if (dy < 0) {
            floatingSearchView.setTranslationY(View.SCROLL_AXIS_VERTICAL);
        }
    }

    private void setFloatingSearchView() {
        floatingSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view);
        floatingSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> {
            if (oldQuery.length() <= LENGHT_QUERY_MIN_SEARCH
                    && newQuery.length() <= LENGHT_QUERY_MIN_SEARCH) {
                floatingSearchView.clearSuggestions();
            } else {
                presenter.getItemsSearched(newQuery);
            }
        });

        floatingSearchView.setOnBindSuggestionCallback((suggestionView, leftIcon, textView, item, itemPosition) -> {
            final ItemSuggestion itemSuggestion = (ItemSuggestion) item;

            if (ItemSuggestion.TypeItem.MOVIE.equals(itemSuggestion.getTypeItem())) {
                leftIcon.setImageDrawable(getDrawable(R.drawable.ic_local_movies_black_24dp));
            } else {
                leftIcon.setImageDrawable(getDrawable(R.drawable.ic_library_books_black_24dp));
            }
        });

        floatingSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(final SearchSuggestion searchSuggestion) {
            }

            @Override
            public void onSearchAction(final String currentQuery) {
                Toast.makeText(getBaseContext(), currentQuery, Toast.LENGTH_LONG).show();
            }
        });

        floatingSearchView.setOnMenuItemClickListener(item ->
                CopyrightDialogFragment.newInstance().show(getFragmentManager(), CopyrightDialogFragment.TAG));
    }

    public void setToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void eventOnPageChanged() {
        switch (mViewPager.getCurrentItem()) {
            case MoviesReviewsFragment.VIEW_PAGER_POSITION:
                changeColorsTheme(R.color.colorPrimaryMovies, R.color.colorPrimaryDarkMovies);
                break;
            case BooksFragment.VIEW_PAGER_POSITION:
                changeColorsTheme(R.color.colorPrimaryBooks, R.color.colorPrimaryDarkBooks);
                break;
        }
    }

    private void changeColorsTheme(final int colorPrimary, final int colorPrimaryDark) {
        ThemeUtils.setStatusBarColor(getResources().getColor(colorPrimaryDark), this);
        ThemeUtils.setPrimaryColorAppBar(appBarLayout, getResources().getColor(colorPrimary));
    }

    @Override
    public void showProgressSearchView() {
        floatingSearchView.showProgress();
    }

    @Override
    public void hideProgressSearchView() {
        floatingSearchView.hideProgress();
    }

    @Override
    public void swapSearchView(final List<ItemSuggestion> itemSuggestionList) {
        floatingSearchView.swapSuggestions(itemSuggestionList);
    }
}