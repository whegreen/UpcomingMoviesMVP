package com.jlmd.android.newfilmsmvp.screen.moviedetails.mvp.presenter;

import com.jlmd.android.newfilmsmvp.api.base.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.screen.base.mvp.Presenter;
import com.jlmd.android.newfilmsmvp.screen.moviedetails.mvp.view.MovieDetailsView;

/**
 * @author jlmd
 */
public abstract class MovieDetailsPresenter extends Presenter<MovieDetailsView> {

    public abstract void onMovieReceive(Movie movie);
}
