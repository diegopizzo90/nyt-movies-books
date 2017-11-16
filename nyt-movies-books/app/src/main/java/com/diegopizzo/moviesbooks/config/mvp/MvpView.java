package com.diegopizzo.moviesbooks.config.mvp;

public interface MvpView {

    void showLoading();

    void showContent();

    void showMessage(int messageResId);

    void showMessage(String message);
}
