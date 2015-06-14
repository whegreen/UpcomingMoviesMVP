package com.jlmd.android.newfilmsmvp.screen.base.bus.event;

import com.jlmd.android.newfilmsmvp.api.base.domain.model.Movie;

/**
 * @author jlmd
 */
public class MovieSelectedEvent {

    private final Movie movie;

    public MovieSelectedEvent(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
