package com.example.xysm.bjcolor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by XYSM on 2018/1/30.
 */

public abstract class BaseFragment extends Fragment {
    public  void  call(Object t){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        setup(rootView, savedInstanceState);

        return rootView;
    }

    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {

    }

    protected abstract int getLayoutId();



}
