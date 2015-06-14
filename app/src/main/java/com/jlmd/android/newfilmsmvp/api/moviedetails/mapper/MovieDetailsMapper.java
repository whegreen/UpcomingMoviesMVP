package com.jlmd.android.newfilmsmvp.api.moviedetails.mapper;

import com.jlmd.android.newfilmsmvp.api.base.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.api.moviedetails.model.Genre;
import com.jlmd.android.newfilmsmvp.api.moviedetails.model.MovieDetailsResult;
import com.jlmd.android.newfilmsmvp.api.base.domain.model.MovieDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jlmd
 */
public class MovieDetailsMapper implements Mapper<MovieDetailsResult, MovieDetails> {

    @Override
    public MovieDetails map(MovieDetailsResult movieDetailsResult) {
        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setGenres(getGenresList(movieDetailsResult.getGenres()));
        movieDetails.setHomepage(movieDetailsResult.getHomepage());
        return movieDetails;
    }

    private List<String> getGenresList(List<Genre> genres) {
        List<String> genresList = new ArrayList<String>();
        for (Genre genre : genres) {
            genresList.add(genre.getName());
        }
        return genresList;
    }
}
