package com.diegopizzo.moviesbooks.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.ui.booksfragment.BooksFragment;
import com.diegopizzo.moviesbooks.ui.moviesreviewsfragment.MoviesReviewsFragment;

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
            }

            @Override
            public void onPageSelected(final int position) {
                invalidateOptionsMenu();
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
        inflater.inflate(R.menu.option_menu_movies, menu);
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

    private void setVisibilityItemsMenu(final Menu menu, final boolean isVisible) {
        menu.findItem(R.id.by_opening_date).setVisible(isVisible);
        menu.findItem(R.id.by_publication_date).setVisible(isVisible);
        menu.findItem(R.id.by_title).setVisible(isVisible);
    }


}