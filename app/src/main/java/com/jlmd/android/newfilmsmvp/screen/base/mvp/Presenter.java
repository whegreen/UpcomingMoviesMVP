package com.jlmd.android.newfilmsmvp.screen.base.mvp;

/**
 * Presenter contains the lifecycle of the view
 *
 * @author jlmd
 */
public abstract class Presenter<T extends View> {

    protected T view;

    public void setView(T view) {
        this.view = view;
    }

    public abstract void initialize();

    public abstract void resume();

    public abstract void pause();

    public abstract void destroy();
}
