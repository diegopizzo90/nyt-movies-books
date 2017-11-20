package com.diegopizzo.moviesbooks.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.diegopizzo.moviesbooks.ui.booksfragment.BooksFragment;
import com.diegopizzo.moviesbooks.ui.moviesreviewsfragment.MoviesReviewsFragment;

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
            case 0:
                return MoviesReviewsFragment.newInstance(null);
            case 1:
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
            case 0:
                return MoviesReviewsFragment.TITLE;
            case 1:
                return BooksFragment.TITLE;
        }
        return super.getPageTitle(position);
    }
}
