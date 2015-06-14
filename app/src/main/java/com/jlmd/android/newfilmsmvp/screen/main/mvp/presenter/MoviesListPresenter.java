package com.jlmd.android.newfilmsmvp.screen.main.mvp.presenter;

import com.jlmd.android.newfilmsmvp.screen.base.mvp.Presenter;
import com.jlmd.android.newfilmsmvp.screen.main.mvp.view.MoviesListView;

/**
 * @author jlmd
 */
public abstract class MoviesListPresenter extends Presenter<MoviesListView> {

    public abstract void onSortButtonClick();

    public abstract void onItemSelected(int position);
}
