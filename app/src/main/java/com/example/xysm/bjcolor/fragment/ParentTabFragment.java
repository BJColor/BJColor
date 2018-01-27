package com.example.xysm.bjcolor.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xysm.bjcolor.R;
import com.example.xysm.bjcolor.adapter.ChildTabAdapter;
import com.example.xysm.bjcolor.adapter.ParentTabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

@SuppressLint("ValidFragment")
public class ParentTabFragment extends Fragment {
    private List<Fragment> fragments = new ArrayList<>();
    private ChildTabAdapter tabAdapter;
    private View inflate;
    private TabLayout childTabLayout;
    private ViewPager childViewPager;
    private  String tabName;
    private String[] tabTitle = {"第一页面","第二页面","第三页面","第四页面"};//每个页面顶部标签的名字

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_order_parent,container,false);
        findId();
        initData();
        initView();
        return inflate;
    }

    private void initData() {
        fragments.add(new ChildeTabFragment());
        fragments.add(new ChildeTabFragment());
        fragments.add(new ChildeTabFragment());
        fragments.add(new ChildeTabFragment());
    }

    private void initView() {
        //tab可滚动
        childTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        //tab居中显示
//        childTabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
        for (int i=0; i<tabTitle.length; i++) {
            childTabLayout.addTab(childTabLayout.newTab().setText(tabTitle[i]));
        }
        childTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //设置顶部标签指示条的颜色和选中页面时标签字体颜色
        childTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#7CCD7C"));
        childTabLayout.setTabTextColors(Color.GRAY,Color.parseColor("#FF4081"));

        //这里注意的是，因为我是在fragment中创建MyFragmentStatePagerAdapter，所以要传getChildFragmentManager()

        childViewPager.setAdapter(new ParentTabAdapter(getChildFragmentManager(),fragments));
        //在设置viewpager页面滑动监听时，创建TabLayout的滑动监听
        childViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(childTabLayout));

        childTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //在选中的顶部标签时，为viewpager设置currentitem
                childViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        
        
//        //tab可滚动
//        childTabLayout.setTabMode(TabLayout.MODE_FIXED);
//
//        childTabLayout.addTab(childTabLayout.newTab().setText("Tab 1"));
//        childTabLayout.addTab(childTabLayout.newTab().setText("Tab 2"));
//        childTabLayout.addTab(childTabLayout.newTab().setText("Tab 3"));
//        childTabLayout.addTab(childTabLayout.newTab().setText("Tab 4"));
//
//        //tab居中显示
//        childTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
//        tabAdapter = new ChildTabAdapter(getChildFragmentManager(),fragments);
//        childViewPager.setAdapter(tabAdapter);
//        //关联ViewPager和TabLayout
//        childTabLayout.setupWithViewPager(childViewPager);





    }

    private void findId() {
        childTabLayout = inflate.findViewById(R.id.childTabLayout);
        childViewPager = inflate.findViewById(R.id.childViewPager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
       l
    }

}
