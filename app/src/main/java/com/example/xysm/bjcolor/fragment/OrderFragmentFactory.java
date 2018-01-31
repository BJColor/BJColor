//package com.example.xysm.bjcolor.fragment;
//
//import android.support.v4.app.Fragment;
//import android.support.v4.util.SparseArrayCompat;
//
//import com.example.xysm.bjcolor.R;
//
///**
// * Created by XYSM on 2018/1/29.
// */
//
//public class OrderFragmentFactory {
//    public static SparseArrayCompat<Fragment> mIndexOrderFragment = new SparseArrayCompat<>();
//    static {
//        mIndexOrderFragment.put(R.id.container, new ParentTabFragment());
//        mIndexOrderFragment.put(R.id.container, new ParentTabFragment());
//        mIndexOrderFragment.put(R.id.container, new ParentTabFragment());
//    }
//
//
//    public static Fragment get(int id) {
//        if (mIndexOrderFragment.indexOfKey(id) < 0) {
//            throw new UnsupportedOperationException("cannot find fragment by " + id);
//        }
//        return mIndexOrderFragment.get(id);
//    }
//
//    public static SparseArrayCompat<Fragment> get() {
//        return mIndexOrderFragment;
//    }
//
//
//}
