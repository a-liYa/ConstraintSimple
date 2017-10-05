package com.aliya.constraint.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliya.constraint.bean.PagerEntity;

import java.util.List;

/**
 * 示例 - Adapter
 *
 * @author a_liYa
 * @date 2017/10/5 11:14.
 */
public class SimpleAdapter extends PagerAdapter {

    private List<PagerEntity> list;
    private SparseArray<View> views;

    public SimpleAdapter(List<PagerEntity> list) {
        this.list = list;
        views = new SparseArray<>(list.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        if (view == null) {
            view = LayoutInflater.from(container.getContext())
                    .inflate(getData(position).getResId(), container, false);
            views.put(position, view);
        }
        container.addView(view);
        return view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public PagerEntity getData(int position) {
        return list.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}