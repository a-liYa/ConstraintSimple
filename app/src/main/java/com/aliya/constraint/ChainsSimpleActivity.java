package com.aliya.constraint;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.aliya.constraint.adapter.SimpleAdapter;
import com.aliya.constraint.bean.PagerEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 链状结构 - (Chains) - 示例
 *
 * @author a_liYa
 * @date 2017/10/2 下午9:55.
 */
public class ChainsSimpleActivity extends AppCompatActivity implements ViewPager
        .OnPageChangeListener {

    TextView tvLeft;
    TextView tvTitle;
    TextView tvRight;

    ViewPager pager;

    private static List<PagerEntity> list = new ArrayList<>();

    static {
        list.add(new PagerEntity("Spread", R.layout.pager_chains_spread_simple));
        list.add(new PagerEntity("Spread Inside", R.layout.pager_chains_spread_inside_simple));
        list.add(new PagerEntity("Packed", R.layout.pager_chains_packed_simple));
        list.add(new PagerEntity("Packed with Bias", R.layout.pager_chains_packed_with_bias_simple));
    }

    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chains_simple);

        tvLeft = (TextView) findViewById(R.id.tv_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvRight = (TextView) findViewById(R.id.tv_right);

        pager = (ViewPager) findViewById(R.id.view_pager);

        mAdapter = new SimpleAdapter(list);

        pager.addOnPageChangeListener(this);
        pager.setAdapter(mAdapter);
        onPageSelected(pager.getCurrentItem());

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            tvLeft.setText("");
        } else {
            tvLeft.setText(mAdapter.getPageTitle(position - 1));
        }
        if (position == mAdapter.getCount() - 1) {
            tvRight.setText("");
        } else {
            tvRight.setText(mAdapter.getPageTitle(position + 1));
        }
        tvTitle.setText(mAdapter.getPageTitle(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
