package com.jlmd.android.newfilmsmvp.di.module;

import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.base.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.screen.moviedetails.mvp.presenter.MovieDetailsPresenter;
import com.jlmd.android.newfilmsmvp.screen.moviedetails.mvp.presenter.MovieDetailsPresenterImp;
import com.jlmd.android.newfilmsmvp.screen.main.mvp.presenter.MoviesListPresenter;
import com.jlmd.android.newfilmsmvp.screen.main.mvp.presenter.MoviesListPresenterImp;
import com.squareup.otto.Bus;

import java.util.Comparator;

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
public class PresenterModule {

    @Provides
    @Singleton
    MoviesListPresenter providesMoviesListPresenter(UpcomingMoviesApi upcomingMoviesApi,
                                                    Bus eventBus,
                                                    @Named("date") Comparator<Movie>
                                                            movieDateComparator,
                                                    @Named("title") Comparator<Movie>
                                                            movieTitleComparator) {
        return new MoviesListPresenterImp(upcomingMoviesApi, eventBus,
                movieDateComparator, movieTitleComparator);
    }

    @Provides
    @Singleton
    MovieDetailsPresenter providesMovieDetailsPresenter(MovieDetailsApi movieDetailsApi) {
        return new MovieDetailsPresenterImp(movieDetailsApi);
    }
}
