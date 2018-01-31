package com.example.xysm.bjcolor.newOrder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.xysm.bjcolor.R;
import com.example.xysm.bjcolor.fragment.BaseFragment;

/**
 * Created by XYSM on 2018/1/25.
 */

public  class BaseUIFragment extends BaseFragment {
    protected TabLayout childTabLayout;
    protected ViewPager childViewPager;



    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        super.setup(rootView, savedInstanceState);
        childTabLayout = rootView.findViewById(R.id.childTabLayout);
        childViewPager = rootView.findViewById(R.id.childViewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_child_tab;
    }

    @Override
    public void call(Object t) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
