package com.jlmd.android.newfilmsmvp.screen.moviedetails.mvp.presenter;

import android.util.Log;

import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.base.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.api.base.domain.model.MovieDetails;

/**
 * @author jlmd
 */
public class MovieDetailsPresenterImp extends MovieDetailsPresenter {

    private MovieDetailsApi movieDetailsApi;
    private final static String TAG = MovieDetailsPresenterImp.class.getSimpleName();

    public MovieDetailsPresenterImp(MovieDetailsApi movieDetailsApi) {
        this.movieDetailsApi = movieDetailsApi;
    }

    @Override
    public void onMovieReceive(Movie movie) {
        loadMovieDetails(movie);
    }

    @Override
    public void initialize() {
        // Empty
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

    private void loadMovieDetails(final Movie movie) {
        movieDetailsApi.getMovieDetails(movie.getId(), new MovieDetailsApi.Callback() {
            @Override
            public void onFinish(MovieDetails movieDetails) {
                movieDetails.setMovie(movie);
                view.renderMovie(movieDetails);
                view.hideLoading();
            }

            @Override
            public void onError(String errorMessage) {
                Log.i(TAG, "Error: " + errorMessage);
                view.hideLoading();
            }
        });
    }

}
