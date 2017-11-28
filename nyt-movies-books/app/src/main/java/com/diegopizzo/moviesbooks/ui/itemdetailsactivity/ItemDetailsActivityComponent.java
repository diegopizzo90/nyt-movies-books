package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

import com.diegopizzo.moviesbooks.config.dagger.ActivityScope;
import com.diegopizzo.moviesbooks.config.dagger.ApplicationComponent;

import dagger.Component;

/**
 * Created by diegopizzo on 27/11/2017.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ItemDetailsActivityModule.class)
public interface ItemDetailsActivityComponent {

    void inject(ItemDetailsActivity itemDetailsActivity);
}
