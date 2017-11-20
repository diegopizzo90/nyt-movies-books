package com.diegopizzo.moviesbooks.ui.booksfragment;

import android.content.Context;
import android.os.Bundle;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpFragment;

/**
 * Created by diegopizzo on 19/11/2017.
 */

public class BooksFragment extends AbstractMvpFragment<BooksFragmentContract.Presenter> implements BooksFragmentContract.View {

    public static final String TAG = "BooksFragment";
    public static final String TITLE = "BestSellers";
    private OnFragmentInteractionListener onFragmentInteractionListener;

    public static BooksFragment newInstance(final Bundle bundle) {
        final BooksFragment booksFragment = new BooksFragment();
        if (bundle != null) {
            booksFragment.setArguments(bundle);
        }
        return booksFragment;
    }

    @Override
    protected void inject() {
        DaggerBooksFragmentComponent.builder()
                .applicationComponent(((MoviesBooksApplication) getActivity().getApplication()).getApplicationComponent())
                .booksFragmentModule(new BooksFragmentModule(this)).build().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.books_layout;
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
