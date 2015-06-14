package com.jlmd.android.newfilmsmvp.screen.main.mvp.view;

import com.jlmd.android.newfilmsmvp.api.base.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.screen.base.mvp.View;

import java.util.List;

/**
 * @author jlmd
 */
public interface MoviesListView extends View {

    void showLoading();

    void hideLoading();

    void renderMovies(final List<Movie> movies);
}
