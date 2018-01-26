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
import android.widget.TextView;

import com.example.xysm.bjcolor.R;
import com.example.xysm.bjcolor.adapter.ParentTabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

@SuppressLint("ValidFragment")
public class ChildeTabFragment extends Fragment {
    private TabLayout parentTabLayout;
    private ViewPager parentViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabs = new ArrayList<>();
    private ParentTabAdapter tabAdapter;
    private View inflate;
    private final int page;

    public ChildeTabFragment(int i) {
        page = i;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_order_child,container,false);
        initData();
        return inflate;
    }

    private void initData() {
        TextView viewById = inflate.findViewById(R.id.tv);
        viewById.setText(page+"");
    }

}
