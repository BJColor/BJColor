package com.example.xysm.bjcolor.newOrder.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.xysm.bjcolor.R;
import com.example.xysm.bjcolor.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/31.
 */

public class BaseUiChildFragment extends BaseFragment {

    protected RecyclerView list;

    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        super.setup(rootView, savedInstanceState);
        list = rootView.findViewById(R.id.rvList);
        list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_childlist;
    }


}