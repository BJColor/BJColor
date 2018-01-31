package com.example.xysm.bjcolor.newOrder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xysm.bjcolor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

public class OrderNewActivity extends AppCompatActivity {

    private TabLayout parentTabLayout;
    private ViewPager parentViewPager;
    private List<Pair<String, ? extends Fragment>> mFragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_new);
        findId();
        initData();
        initView();

    }


    private void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(Pair.create("线上订单", new BusinessFragment().initconfig(OrderEnum.online)));
        mFragmentList.add(Pair.create("线下订单", new BusinessFragment().initconfig(OrderEnum.line)));
        mFragmentList.add(Pair.create("货单", new OrderListFragment()));
    }

    private void initView() {
//        //tab可滚动
        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        //tab居中显示
        parentTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        for (int i = 0; i < mFragmentList.size(); i++) {
            String first = mFragmentList.get(i).first;
            parentTabLayout.addTab(parentTabLayout.newTab().setText(first));
        }
        //设置顶部标签指示条的颜色和选中页面时标签字体颜色
        parentTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#7CCD7C"));
        parentTabLayout.setTabTextColors(Color.GRAY, Color.parseColor("#FF4081"));

        //这里注意的是，因为我是在fragment中创建MyFragmentStatePagerAdapter，所以要传getChildFragmentManager()
        parentViewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), mFragmentList));
        //在设置viewpager页面滑动监听时，创建TabLayout的滑动监听
        parentViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(parentTabLayout));

        parentTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //在选中的顶部标签时，为viewpager设置currentitem
                parentViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void findId() {
        parentTabLayout = findViewById(R.id.parentTabLayout);
        parentViewPager = findViewById(R.id.parentViewPager);
    }

}
