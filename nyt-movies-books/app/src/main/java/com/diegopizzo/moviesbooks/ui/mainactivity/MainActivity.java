package com.diegopizzo.moviesbooks.ui.mainactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.ui.ThemeUtils;
import com.diegopizzo.moviesbooks.ui.ViewPagerAdapter;
import com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment.BooksFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.copyrightdialogfragment.CopyrightDialogFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment.MoviesReviewsFragment;

public class MainActivity extends AppCompatActivity implements MoviesReviewsFragment.OnFragmentInteractionListener,
        BooksFragment.OnFragmentInteractionListener {


    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        setViewPager();
    }

    public void setViewPager() {
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

    public void setToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_layout, menu);
        switch (mViewPager.getCurrentItem()) {
            case MoviesReviewsFragment.VIEW_PAGER_POSITION:
                setVisibilityItemsMenu(menu, true);
                break;
            case BooksFragment.VIEW_PAGER_POSITION:
                setVisibilityItemsMenu(menu, false);
                break;
        }
        return true;
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
        ThemeUtils.setPrimaryColorActionBar(getSupportActionBar(), getResources().getColor(colorPrimary));
        ThemeUtils.setPrimaryColorViewPager(mTabLayout, getResources().getColor(colorPrimary));
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.copyrightInfo:
                CopyrightDialogFragment.newInstance().show(getFragmentManager(), CopyrightDialogFragment.TAG);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setVisibilityItemsMenu(final Menu menu, final boolean isVisible) {
        menu.findItem(R.id.by_opening_date).setVisible(isVisible);
        menu.findItem(R.id.by_publication_date).setVisible(isVisible);
        menu.findItem(R.id.by_title).setVisible(isVisible);
    }


}