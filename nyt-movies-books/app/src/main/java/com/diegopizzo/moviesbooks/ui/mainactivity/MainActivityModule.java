package com.diegopizzo.moviesbooks.ui.mainactivity;

import com.diegopizzo.moviesbooks.config.dagger.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diegopizzo on 12/12/2017.
 */

@Module
public class MainActivityModule {

    private final MainActivityContract.View view;

    public MainActivityModule(final MainActivityContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainActivityContract.Presenter providePresenter() {
        return new MainActivityPresenter(view);
    }
}
