package com.jlmd.android.newfilmsmvp.screen.main.mvp.presenter;

import android.util.Log;

import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.screen.base.bus.event.MovieSelectedEvent;
import com.jlmd.android.newfilmsmvp.api.base.domain.model.Movie;
import com.squareup.otto.Bus;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jlmd
 */
public class MoviesListPresenterImp extends MoviesListPresenter {

    private UpcomingMoviesApi upcomingMoviesApi;
    private List<Movie> movies = Collections.emptyList();
    private boolean sortedByTitle;
    private final Bus bus;
    private final Comparator<Movie> movieDateComparator;
    private final Comparator<Movie> movieTitleComparator;
    private final static String TAG = MoviesListPresenterImp.class.getSimpleName();

    public MoviesListPresenterImp(UpcomingMoviesApi upcomingMoviesApi, Bus bus,
                                  Comparator<Movie> movieDateComparator,
                                  Comparator<Movie> movieTitleComparator) {
        this.upcomingMoviesApi = upcomingMoviesApi;
        this.bus = bus;
        this.movieDateComparator = movieDateComparator;
        this.movieTitleComparator = movieTitleComparator;
    }

    @Override
    public void initialize() {
        loadMovies();
    }

    @Override
    public void resume() {
        // Empty
    }

    @Override
    public void pause() {
        // Empty
    }

    @Override
    public void destroy() {
        // Empty
    }

    @Override
    public void onSortButtonClick() {
        if (sortedByTitle) {
            sortMoviesByDate();
        } else {
            sortMoviesByTitle();
        }
        sortedByTitle = !sortedByTitle;
    }

    private void sortMoviesByTitle() {
        Collections.sort(movies, movieTitleComparator);
        showMovies(movies);
    }

    private void sortMoviesByDate() {
        Collections.sort(movies, movieDateComparator);
        showMovies(movies);
    }

    @Override
    public void onItemSelected(int position) {
        bus.post(new MovieSelectedEvent(movies.get(position)));
    }

    private void loadMovies() {
        view.showLoading();
        upcomingMoviesApi.getUpcomingMovies(new UpcomingMoviesApi.Callback() {
            @Override
            public void onFinish(List<Movie> movies) {
                setMovies(movies);
                showMovies(movies);
                view.hideLoading();
            }

            @Override
            public void onError(String errorMessage) {
                Log.i(TAG, "Error: " + errorMessage);
                view.hideLoading();
            }
        });
    }

    private void showMovies(List<Movie> movies) {
        view.renderMovies(movies);
    }

    private void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
