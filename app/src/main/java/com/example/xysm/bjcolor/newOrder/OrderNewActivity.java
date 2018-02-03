package com.example.xysm.bjcolor.newOrder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;

import com.example.xysm.bjcolor.R;
import com.example.xysm.bjcolor.newOrder.adapter.TabAdapter;
import com.example.xysm.bjcolor.newOrder.fragment.BusinessFragment;
import com.example.xysm.bjcolor.newOrder.fragment.OrderListFragment;
import com.example.xysm.bjcolor.newOrder.other.NoScrollViewPager;
import com.example.xysm.bjcolor.newOrder.other.OrderEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

public class OrderNewActivity extends AppCompatActivity {

    private TabLayout parentTabLayout;
    private NoScrollViewPager parentViewPager;
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
        for (int i = 0; i < mFragmentList.size(); i++) {
            String first = mFragmentList.get(i).first;
            parentTabLayout.addTab(parentTabLayout.newTab().setText(first));
        }

        parentViewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), mFragmentList));
        parentViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(parentTabLayout));
        parentTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
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
