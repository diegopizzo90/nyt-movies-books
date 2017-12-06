package com.diegopizzo.moviesbooks.config.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.diegopizzo.moviesbooks.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class AbstractMvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {

    @Inject
    protected P presenter;
    @Nullable
    @BindView(R.id.itemSelectedProgressBar)
    protected ProgressBar progressBar;

    @Override
    public void showLoading() {
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showContent() {
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(final int messageResId) {
        showMessage(getString(messageResId));
    }

    @Override
    public void showMessage(final String message) {
        showContent();
        if (getRootLayoutView() != null) {
            Snackbar.make(getRootLayoutView(), message, Snackbar.LENGTH_LONG).show();
        } else {
            //fallback, should never happen
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        inject();
    }

    /**
     * The activity knows what must be injected
     */
    protected abstract void inject();

    /**
     * The activity knows the layout to be displayed
     *
     * @return the layout id
     */
    protected abstract int getLayout();

    /**
     * The activity knows its root layout view, used to display the snackbar
     *
     * @return the root layout view
     */
    protected abstract View getRootLayoutView();
}
