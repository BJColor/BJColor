package com.example.xysm.bjcolor.newOrder.other;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;

import com.example.xysm.bjcolor.newOrder.adapter.TabAdapter2;

import java.util.List;

/**
 * Created by XYSM on 2018/1/31.
 */

public  class BusinessUiView {

    public BusinessUiView(FragmentManager childFragmentManager,
                          TabLayout childTabLayout, final ViewPager childViewPager,
                          List<Pair<String, ? extends Fragment>> mFragmentList) {

        for (int i = 0; i < mFragmentList.size(); i++) {
            childTabLayout.addTab(childTabLayout.newTab().setText(mFragmentList.get(i).first));
        }

        //这里注意的是，因为我是在fragment中创建MyFragmentStatePagerAdapter，所以要传getChildFragmentManager()
        childViewPager.setAdapter(new TabAdapter2(childFragmentManager, mFragmentList));
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
    }

}
