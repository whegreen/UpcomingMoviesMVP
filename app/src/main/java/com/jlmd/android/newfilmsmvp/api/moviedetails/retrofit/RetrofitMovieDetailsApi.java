package com.jlmd.android.newfilmsmvp.api.moviedetails.retrofit;

import com.jlmd.android.newfilmsmvp.api.base.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.moviedetails.model.MovieDetailsResult;
import com.jlmd.android.newfilmsmvp.api.base.domain.model.MovieDetails;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * @author jlmd
 */
public class RetrofitMovieDetailsApi implements MovieDetailsApi {

    private MovieDetailsService movieDetailsService;
    private final Mapper movieDetailsMapper;

    public RetrofitMovieDetailsApi(Mapper mapper) {
        this.movieDetailsMapper = mapper;
        initRestAdapter();
    }

    private void initRestAdapter() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

        movieDetailsService = restAdapter.create(MovieDetailsService.class);
    }

    @Override
    public void getMovieDetails(int movieId, final Callback callback) {
        movieDetailsService.getMovieDetail(movieId, API_KEY,
                new retrofit.Callback<MovieDetailsResult>() {
                    @Override
                    public void success(MovieDetailsResult upcomingMoviesResults,
                                        Response response) {
                        callback.onFinish((MovieDetails) movieDetailsMapper
                                .map(upcomingMoviesResults));
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        callback.onError(error.getMessage());
                    }
                });
    }
}
