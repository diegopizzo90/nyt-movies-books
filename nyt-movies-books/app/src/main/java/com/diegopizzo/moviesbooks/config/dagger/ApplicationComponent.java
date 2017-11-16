package com.diegopizzo.moviesbooks.config.dagger;

import android.content.Context;

import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by diegopizzo on 25/09/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, InteractorModule.class, NetworkModule.class})
public interface ApplicationComponent {

    class Injector {
        public static ApplicationComponent getComponent(final Context c) {
            return ((MoviesBooksApplication) c.getApplicationContext()).getApplicationComponent();
        }
    }
}
