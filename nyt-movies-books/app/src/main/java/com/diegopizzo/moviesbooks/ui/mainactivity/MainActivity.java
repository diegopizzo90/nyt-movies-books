package com.diegopizzo.moviesbooks.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpActivity;
import com.diegopizzo.moviesbooks.ui.ItemSuggestion;
import com.diegopizzo.moviesbooks.ui.itemdetailsactivity.ItemDetailsActivity;
import com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment.BooksFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.copyrightdialogfragment.CopyrightDialogFragment;
import com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment.MoviesReviewsFragment;
import com.diegopizzo.moviesbooks.ui.utils.ThemeUtils;

import java.util.List;

import static com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment.BookListAdapter.BOOK_IMAGE_BUNDLE;
import static com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment.BookListAdapter.BOOK_ISBN_BUNDLE;
import static com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment.BookListAdapter.BOOK_LIST_NAME_BUNDLE;
import static com.diegopizzo.moviesbooks.ui.mainactivity.moviesreviewsfragment.MoviesReviewsAdapter.MOVIE_TITLE_BUNDLE;

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
                final ItemSuggestion itemSuggestion = (ItemSuggestion) searchSuggestion;

                if (ItemSuggestion.TypeItem.MOVIE.equals(itemSuggestion.getTypeItem())) {
                    startItemDetailsActivityForMovieSelectedOnSearchView(searchSuggestion.getBody());
                } else if (ItemSuggestion.TypeItem.BOOK.equals(itemSuggestion.getTypeItem())) {
                    final String isbn = itemSuggestion.getItemIsbn();
                    final String listName = itemSuggestion.getItemListName();
                    if (!TextUtils.isEmpty(isbn) && !TextUtils.isEmpty(listName)) {
                        startItemDetailsActivityForBookSelectedOnSearchView(isbn, listName, "");
                    } else {
                        showMessage(R.string.book_not_available);
                    }
                } else {
                    showMessage(R.string.item_not_available);
                }
            }

            @Override
            public void onSearchAction(final String currentQuery) {
                Toast.makeText(getBaseContext(), currentQuery, Toast.LENGTH_LONG).show();
            }
        });

        floatingSearchView.setOnMenuItemClickListener(item ->
                CopyrightDialogFragment.newInstance().show(getFragmentManager(), CopyrightDialogFragment.TAG));
    }


    private void startItemDetailsActivityForMovieSelectedOnSearchView(final String movieTitle) {
        final Intent intent = new Intent(this, ItemDetailsActivity.class);
        final Bundle titleBundle = new Bundle();
        titleBundle.putString(MOVIE_TITLE_BUNDLE, movieTitle);
        intent.putExtras(titleBundle);
        startActivity(intent);
    }

    private void startItemDetailsActivityForBookSelectedOnSearchView(final String isbn, final String listName, final String imageLink) {
        final Intent intent = new Intent(this, ItemDetailsActivity.class);
        final Bundle bookBundle = new Bundle();
        bookBundle.putString(BOOK_ISBN_BUNDLE, isbn);
        bookBundle.putString(BOOK_LIST_NAME_BUNDLE, listName);
        bookBundle.putString(BOOK_IMAGE_BUNDLE, imageLink);
        intent.putExtras(bookBundle);
        startActivity(intent);
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