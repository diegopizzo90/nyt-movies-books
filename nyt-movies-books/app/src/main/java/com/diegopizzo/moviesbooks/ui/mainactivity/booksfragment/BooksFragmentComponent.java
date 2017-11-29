package com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment;

import com.diegopizzo.moviesbooks.config.dagger.ApplicationComponent;
import com.diegopizzo.moviesbooks.config.dagger.FragmentScope;

import dagger.Component;

/**
 * Created by diegopizzo on 19/11/2017.
 */

@FragmentScope
@Component(dependencies = ApplicationComponent.class, modules = BooksFragmentModule.class)
public interface BooksFragmentComponent {

    void inject(BooksFragment booksFragment);
}
