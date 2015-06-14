package com.jlmd.android.newfilmsmvp.api.base.domain.formatter;

/**
 * @author jlmd
 */
public interface Formatter<TFrom> {

    String format(TFrom from);
}
