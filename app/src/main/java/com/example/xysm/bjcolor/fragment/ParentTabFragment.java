package com.example.xysm.bjcolor.fragment;

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
import com.example.xysm.bjcolor.adapter.ParentTabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

public class ParentTabFragment extends Fragment {
    private TabLayout parentTabLayout;
    private ViewPager parentViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabs = new ArrayList<>();
    private ParentTabAdapter tabAdapter;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_order_new,container,false);
        findId();
        initData();
        initView();
        return inflate;
    }

    private void initData() {
        tabs.add("1");
        tabs.add("2");
        tabs.add("3");
        tabs.add("4");
        fragments.add(new ChildeTabFragment());
        fragments.add(new ChildeTabFragment());
        fragments.add(new ChildeTabFragment());
        fragments.add(new ChildeTabFragment());
    }

    private void initView() {
        //设置TabLayout的模式
        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabAdapter = new ParentTabAdapter(,fragments);
        parentViewPager.setAdapter(tabAdapter);
        //关联ViewPager和TabLayout
        parentTabLayout.setupWithViewPager(parentViewPager);
    }

    private void findId() {
        parentTabLayout = inflate.findViewById(R.id.parentTabLayout);
        parentViewPager = inflate.findViewById(R.id.parentViewPager);
    }
}
