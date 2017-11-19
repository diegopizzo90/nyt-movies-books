package com.diegopizzo.moviesbooks.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.ui.booksfragment.BooksFragment;
import com.diegopizzo.moviesbooks.ui.moviesreviewsfragment.MoviesReviewsFragment;

public class MainActivity extends AppCompatActivity implements MoviesReviewsFragment.OnFragmentInteractionListener, BooksFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
