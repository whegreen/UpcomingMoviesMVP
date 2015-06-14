package com.jlmd.android.newfilmsmvp.di.module;

import android.content.Context;

import com.jlmd.android.newfilmsmvp.di.AppApplication;
import com.jlmd.android.newfilmsmvp.screen.moviedetails.mvp.presenter.MovieDetailsPresenterImp;
import com.jlmd.android.newfilmsmvp.screen.main.mvp.presenter.MoviesListPresenterImp;
import com.jlmd.android.newfilmsmvp.screen.main.ui.activity.MainActivity;
import com.jlmd.android.newfilmsmvp.screen.moviedetails.ui.fragment.MovieDetailsFragment;
import com.jlmd.android.newfilmsmvp.screen.main.ui.fragment.MoviesListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author jlmd
 */

@Module(
        includes = {
                RepositoryModule.class,
                PresenterModule.class,
                ComparatorModule.class
        },
        injects = {
                AppApplication.class,
                MainActivity.class,
                MoviesListFragment.class,
                MoviesListPresenterImp.class,
                MovieDetailsFragment.class,
                MovieDetailsPresenterImp.class
        },
        library = true
)
public class RootModule {

    private final Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return context;
    }

    @Provides
    @Singleton
    public Bus provideBusEvent() {
        return new Bus();
    }
}
