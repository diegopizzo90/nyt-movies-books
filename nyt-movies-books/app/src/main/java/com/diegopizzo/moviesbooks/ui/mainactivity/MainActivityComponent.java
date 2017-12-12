package com.diegopizzo.moviesbooks.ui.mainactivity;

import com.diegopizzo.moviesbooks.config.dagger.ActivityScope;
import com.diegopizzo.moviesbooks.config.dagger.ApplicationComponent;

import dagger.Component;

/**
 * Created by diegopizzo on 12/12/2017.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
