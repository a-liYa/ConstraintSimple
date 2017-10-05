package com.aliya.constraint.bean;

import android.support.annotation.LayoutRes;

/**
 * ViewPager entity
 *
 * @author a_liYa
 * @date 2017/10/5 10:57.
 */
public class PagerEntity {

    private String title;

    private
    @LayoutRes
    int resId;

    public PagerEntity(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
