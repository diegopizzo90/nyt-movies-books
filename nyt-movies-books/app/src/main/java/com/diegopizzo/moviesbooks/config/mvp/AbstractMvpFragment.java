package com.diegopizzo.moviesbooks.config.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by diegopizzo on 25/09/2017.
 */

public abstract class AbstractMvpFragment<P extends MvpPresenter> extends Fragment implements MvpView {

    @Inject
    protected P presenter;
    @Nullable
    //@BindView(R.id.progressBar)
    protected ProgressBar progressBar;
    private Unbinder unbinder;

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
        if (getView() != null) {
            Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
        } else {
            //fallback, should never happen
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * The fragment knows what must be injected
     */
    protected abstract void inject();

    /**
     * The fragment knows the layout to be displayed
     *
     * @return the layout id
     */
    protected abstract int getLayout();

}
