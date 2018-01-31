//package com.example.xysm.bjcolor.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.view.PagerAdapter;
//import android.widget.Toast;
//
//import com.example.xysm.bjcolor.adapter.ParentTabAdapter;
//
//import java.util.ArrayList;
//
///**
// * Created by XYSM on 2018/1/29.
// */
//
//public class LineOrderFragment extends ParentTabFragment implements ParentTabFragment.IfPositonCallBack{
//
//
//    private ArrayList<Fragment> fragments;
//    private String[] strings;
//    private String t1;
//    private FragmentManager childFragmentManager;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setIfPositonCallBack(this);
//    }
//
//    @Override
//    protected void initData() {
//        childFragmentManager = getChildFragmentManager();
//        fragments = new ArrayList<>();
//        fragments.add(new ChildeTabFragment());
//        fragments.add(new ChildeTabFragment());
//        fragments.add(new ChildeTabFragment());
//    }
//
//    @Override
//    protected String[] setTitle() {
//        strings = new String[]{"line1", "line2", "line3"};
//        return strings;
//    }
//
//    @Override
//    protected PagerAdapter setData() {
//        return new ParentTabAdapter(getChildFragmentManager(),fragments);
//    }
//
//    @Override
//    public void call(Object t) {
//        t1 = (String) t;
//    }
//
//    @Override
//    public void position(int position) {
//        SendToFragment(t1+strings[position],ChildeTabFragment.class.getName());
//    }
//}
