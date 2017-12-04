package com.diegopizzo.moviesbooks.config.dagger;

import com.diegopizzo.moviesbooks.business.network.service.BooksService;
import com.diegopizzo.moviesbooks.business.network.service.MoviesService;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diegopizzo on 27/09/2017.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit(final GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(ServiceConstants.SERVICE_ENDPOINT)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(final Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().serializeNulls().create();
    }


    @Provides
    @Singleton
    MoviesService provideMoviesService(final Retrofit retrofit) {
        return retrofit.create(MoviesService.class);
    }

    @Provides
    @Singleton
    BooksService provideBooksService(final Retrofit retrofit) {
        return retrofit.create(BooksService.class);
    }
}
