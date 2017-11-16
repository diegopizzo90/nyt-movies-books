package com.diegopizzo.moviesbooks.config;

import android.app.Application;

import com.diegopizzo.moviesbooks.config.dagger.ApplicationComponent;
import com.diegopizzo.moviesbooks.config.dagger.ApplicationModule;
import com.diegopizzo.moviesbooks.config.dagger.DaggerApplicationComponent;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class MoviesBooksApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
