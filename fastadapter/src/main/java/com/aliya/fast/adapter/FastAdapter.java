package com.aliya.fast.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aliya.fast.R;
import com.aliya.fast.entity.ListEntity;

import java.util.List;

/**
 * fast adapter
 *
 * @author a_liYa
 * @date 2017/10/2 14:07.
 */
public class FastAdapter extends BaseAdapter {

    List<ListEntity> list;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view.getTag() instanceof ListEntity) {
                ListEntity entity = (ListEntity) view.getTag();
                Context context = view.getContext();
                context.startActivity(new Intent(context, entity.getClazz()));
            }
        }
    };

    public FastAdapter(List<ListEntity> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = viewGroup.inflate(viewGroup.getContext(), R.layout.item_fast_list, null);
        }
        ViewHolder vh;
        if (view.getTag() instanceof ViewHolder){
            vh = (ViewHolder) view.getTag();
        } else {
            vh = new ViewHolder();
            vh.tv = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(vh);
        }
        ListEntity entity = (ListEntity) getItem(i);
        vh.tv.setText(entity.getText());
        vh.tv.setOnClickListener(onClickListener);
        vh.tv.setTag(entity);
        return view;
    }

    static class ViewHolder {
        TextView tv;
    }

}
