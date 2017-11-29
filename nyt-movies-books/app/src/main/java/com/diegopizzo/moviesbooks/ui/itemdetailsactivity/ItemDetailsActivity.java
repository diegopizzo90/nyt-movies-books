package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

import android.view.View;

import com.diegopizzo.moviesbooks.R;
import com.diegopizzo.moviesbooks.config.MoviesBooksApplication;
import com.diegopizzo.moviesbooks.config.mvp.AbstractMvpActivity;

/**
 * Created by diegopizzo on 27/11/2017.
 */

public class ItemDetailsActivity extends AbstractMvpActivity<ItemDetailsActivityContract.Presenter>
        implements ItemDetailsActivityContract.View {


    @Override
    protected void inject() {
        DaggerItemDetailsActivityComponent.builder()
                .applicationComponent(((MoviesBooksApplication) getApplication()).getApplicationComponent())
                .itemDetailsActivityModule(new ItemDetailsActivityModule(this)).build().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_details_layout;
    }

    @Override
    protected View getRootLayoutView() {
        return null;
    }
}
