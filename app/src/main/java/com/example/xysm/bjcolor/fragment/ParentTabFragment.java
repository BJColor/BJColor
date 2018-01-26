package com.example.xysm.bjcolor.fragment;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

public class ParentTabFragment extends Fragment {
    private List<Fragment> fragments = new ArrayList<>();
    private ChildTabAdapter tabAdapter;
    private View inflate;
    private TabLayout childTabLayout;
    private ViewPager childViewPager;
    private  String tabName;

    public ParentTabFragment(String string) {
        tabName = string;
    }

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
        fragments.add(new ChildeTabFragment(1));
        fragments.add(new ChildeTabFragment(2));
        fragments.add(new ChildeTabFragment(3));
        fragments.add(new ChildeTabFragment(4));
    }

    private void initView() {
        //tab可滚动
        childTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //tab居中显示
        childTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabAdapter = new ChildTabAdapter(getActivity().getSupportFragmentManager(),fragments);
        childViewPager.setAdapter(tabAdapter);
        //关联ViewPager和TabLayout
        childTabLayout.setupWithViewPager(childViewPager);
        childTabLayout.getTabAt(0).setText("Tab 1");
        childTabLayout.getTabAt(1).setText("Tab 2");
        childTabLayout.getTabAt(2).setText("Tab 3");
        childTabLayout.getTabAt(3).setText("Tab 4");
    }

    private void findId() {
        childTabLayout = inflate.findViewById(R.id.childTabLayout);
        childViewPager = inflate.findViewById(R.id.childViewPager);
    }
}
