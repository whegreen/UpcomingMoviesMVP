package com.jlmd.android.newfilmsmvp.screen.moviedetails.mvp.view;

import com.jlmd.android.newfilmsmvp.api.base.domain.model.MovieDetails;
import com.jlmd.android.newfilmsmvp.screen.base.mvp.View;

/**
 * @author jlmd
 */
public interface MovieDetailsView extends View {

    void showLoading();

    void hideLoading();

    void renderMovie(final MovieDetails movieDetails);
}
