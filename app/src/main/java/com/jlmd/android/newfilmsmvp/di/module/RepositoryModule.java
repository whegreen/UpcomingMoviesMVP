package com.jlmd.android.newfilmsmvp.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.jlmd.android.newfilmsmvp.api.base.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.api.moviedetails.mapper.MovieDetailsMapper;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.mapper.UpcomingMoviesMapper;
import com.jlmd.android.newfilmsmvp.api.moviedetails.mock.MockedMovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.mock.MockedUpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author jlmd
 */
@Module(
        complete = false,
        library = true
)
public class RepositoryModule {

    @Provides
    @Named("upcomingmovies")
    @Singleton
    public Mapper providesUpcomingMoviesMapper() {
        return new UpcomingMoviesMapper();
    }

    @Provides
    @Named("moviedetails")
    @Singleton
    public Mapper providesMovieDetailsMapper() {
        return new MovieDetailsMapper();
    }

    @Provides
    @Singleton
    public Gson providesGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public UpcomingMoviesApi providesUpcomingMoviesApi(Context appContext,
                                                       @Named("upcomingmovies")
                                                       final Mapper mapper, Gson gson) {
        return new MockedUpcomingMoviesApi(appContext, mapper, gson);
    }

    @Provides
    @Singleton
    public MovieDetailsApi providesMovieDetailsApi(Context appContext,
                                                   @Named("moviedetails") final Mapper mapper,
                                                   Gson gson) {
        return new MockedMovieDetailsApi(appContext, mapper, gson);
    }

}
