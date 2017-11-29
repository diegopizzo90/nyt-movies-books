package com.diegopizzo.moviesbooks.ui.mainactivity.booksfragment;

import android.util.Log;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.business.network.model.books.BestsellerList;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by diegopizzo on 19/11/2017.
 */

public class BooksFragmentPresenter implements BooksFragmentContract.Presenter {

    private final BooksFragmentContract.View view;
    private final BooksInteractor booksInteractor;

    public BooksFragmentPresenter(final BooksFragmentContract.View view, final BooksInteractor booksInteractor) {
        this.view = view;
        this.booksInteractor = booksInteractor;
    }


    @Override
    public void bestSellers(final boolean refresh) {
        final Single<BestsellerList> bestsellerListSingle = booksInteractor.getBestSellerLists(null);
        bestsellerListSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(final Disposable disposable) throws Exception {
                        if (!refresh) {
                            view.showLoadingBestSeller();
                        }
                        view.showSwipyRefreshLayout();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        view.hideSwipyRefreshLayout();
                        view.showContentBestSeller();
                    }
                })
                .subscribe(new Consumer<BestsellerList>() {
                    @Override
                    public void accept(final BestsellerList bestsellerList) throws Exception {
                        if (bestsellerList != null && bestsellerList.getResults() != null
                                && bestsellerList.getResults().getListResults() != null) {
                            view.setDataOnRecyclerView(bestsellerList);
                            Log.i("BestSeller", "Ok - Refresh: " + refresh);
                        } else {
                            Log.i("BestSeller", "It's empty!");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(final Throwable throwable) throws Exception {
                        view.showMessage("Errore " + throwable.getMessage());
                        view.showContentBestSeller();
                        view.hideSwipyRefreshLayout();
                        Log.e("error", throwable.getMessage());
                    }
                });
    }
}
