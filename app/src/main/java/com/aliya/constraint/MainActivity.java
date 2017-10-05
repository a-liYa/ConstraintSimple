package com.aliya.constraint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.aliya.fast.adapter.FastAdapter;
import com.aliya.fast.entity.ListEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    private static List<ListEntity> list = new ArrayList<>();

    static {
        list.add(new ListEntity(AlignSimpleActivity.class, "对齐 - 示例"));
        list.add(new ListEntity(RatioSimpleActivity.class, "比例 - 示例"));
        list.add(new ListEntity(ChainsSimpleActivity.class, "链式 - 示例"));
        list.add(new ListEntity(WeightSimpleActivity.class, "weight - 示例"));
        list.add(new ListEntity(GuideLinesSimpleActivity.class, "引导线 - 示例"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(new FastAdapter(list));

    }

}
