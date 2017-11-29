package com.diegopizzo.moviesbooks.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment.BooksFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment.MoviesReviewsFragment;

/**
 * Created by diegopizzo on 19/11/2017.
 */

/**
 * FragmentPagerAdapter: This is best when navigating between sibling screens representing a fixed, small number of pages.
 * FragmentStatePagerAdapter: This is best for paging across a collection of objects for which the number of pages is undetermined.
 * It destroys fragments as the user navigates to other pages, minimizing memory usage.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int TAB_COUNT = 2;

    public ViewPagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case MoviesReviewsFragment.VIEW_PAGER_POSITION:
                return MoviesReviewsFragment.newInstance(null);
            case BooksFragment.VIEW_PAGER_POSITION:
                return BooksFragment.newInstance(null);
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        switch (position) {
            case MoviesReviewsFragment.VIEW_PAGER_POSITION:
                return MoviesReviewsFragment.TITLE;
            case BooksFragment.VIEW_PAGER_POSITION:
                return BooksFragment.TITLE;
        }
        return super.getPageTitle(position);
    }
}
