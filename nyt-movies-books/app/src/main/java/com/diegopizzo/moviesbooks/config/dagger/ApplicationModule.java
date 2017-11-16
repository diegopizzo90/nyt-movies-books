package com.diegopizzo.moviesbooks.config.dagger;

import android.content.Context;

import dagger.Module;

/**
 * Created by diegopizzo on 25/09/2017.
 */

@Module
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(final Context context) {
        this.context = context;
    }
}
