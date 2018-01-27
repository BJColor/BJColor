package com.example.xysm.bjcolor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

public class ChildTabAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList;

    public ChildTabAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("bjcolor:child-getItem",position+"");
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        Log.i("bjcolor:child-getCount", mFragmentList.size()+"");
        return mFragmentList.size();
    }
}