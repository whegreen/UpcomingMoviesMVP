package com.jlmd.android.newfilmsmvp.api.base.mapper;

/**
 * @author jlmd
 */
public interface Mapper<TFrom, TTo> {

    TTo map(TFrom from);
}
