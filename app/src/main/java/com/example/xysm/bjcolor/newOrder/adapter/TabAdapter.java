package com.example.xysm.bjcolor.newOrder.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

public class TabAdapter extends FragmentStatePagerAdapter {


    private  List<Pair<String, ? extends Fragment>> mFragmentList;

    public TabAdapter(FragmentManager fm, List<Pair<String, ? extends Fragment>> fragments) {
        super(fm);
        mFragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position).second;
    }

    @Override
    public int getCount() {
          return mFragmentList.size();
    }
}