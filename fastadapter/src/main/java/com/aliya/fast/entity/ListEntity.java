package com.aliya.fast.entity;

import android.app.Activity;

import java.io.Serializable;

/**
 * list entity
 *
 * @author a_liYa
 * @date 2017/10/2 14:12.
 */
public class ListEntity implements Serializable {

    private Class<? extends Activity> clazz;

    private String text;

    public ListEntity(Class<? extends Activity> clazz, String text) {
        this.clazz = clazz;
        this.text = text;
    }

    public Class<? extends Activity> getClazz() {
        return clazz;
    }

    public void setClazz(Class<? extends Activity> clazz) {
        this.clazz = clazz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
