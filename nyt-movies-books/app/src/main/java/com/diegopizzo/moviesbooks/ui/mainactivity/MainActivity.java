package com.diegopizzo.moviesbooks.ui.mainactivity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.ui.ItemSuggestion;
import com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment.BooksFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.copyrightdialogfragment.CopyrightDialogFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment.MoviesReviewsFragment;
import com.diegopizzo.moviesbooks.ui.utils.ThemeUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MoviesReviewsFragment.OnFragmentInteractionListener,
        BooksFragment.OnFragmentInteractionListener {


    private FloatingSearchView floatingSearchView;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mViewPagerAdapter;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        setFloatingSearchView();
        setViewPager();
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
            floatingSearchView.setTranslationY(-256);
        } else if (dy < 0) {
            floatingSearchView.setTranslationY(0);
        }
    }

    private void setFloatingSearchView() {
        floatingSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view);
        floatingSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> {
            final List<ItemSuggestion> itemSuggestionList = new ArrayList<>();
            itemSuggestionList.add(new ItemSuggestion("Prova"));
            itemSuggestionList.add(new ItemSuggestion("Prova1"));
            itemSuggestionList.add(new ItemSuggestion("Prova2"));
            itemSuggestionList.add(new ItemSuggestion("Prova3"));
            itemSuggestionList.add(new ItemSuggestion("Prova4"));
            floatingSearchView.swapSuggestions(itemSuggestionList);
        });

        floatingSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(final SearchSuggestion searchSuggestion) {
            }

            @Override
            public void onSearchAction(final String currentQuery) {

            }
        });

        floatingSearchView.setOnFocusChangeListener(new FloatingSearchView.OnFocusChangeListener() {
            @Override
            public void onFocus() {
                final List<ItemSuggestion> itemSuggestionList = new ArrayList<>();
                itemSuggestionList.add(new ItemSuggestion("Prova"));
                itemSuggestionList.add(new ItemSuggestion("Prova1"));
                itemSuggestionList.add(new ItemSuggestion("Prova2"));
                itemSuggestionList.add(new ItemSuggestion("Prova3"));
                itemSuggestionList.add(new ItemSuggestion("Prova4"));
                floatingSearchView.swapSuggestions(itemSuggestionList);
            }

            @Override
            public void onFocusCleared() {

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
}