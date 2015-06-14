package com.jlmd.android.newfilmsmvp.api.base.domain.comparator;

import com.jlmd.android.newfilmsmvp.api.base.domain.model.Movie;

import java.util.Comparator;

/**
 * @author jlmd
 */
public class MovieDateComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie lhs, Movie rhs) {
        return lhs.getReleaseDate().compareTo(rhs.getReleaseDate());
    }
}
