package com.example.xysm.bjcolor.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xysm.bjcolor.R;

/**
 * Created by XYSM on 2018/1/25.
 */

public class ChildeTabFragment extends BaseFragment {
    private TextView viewById;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_child;
    }

    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        super.setup(rootView, savedInstanceState);
        viewById = rootView.findViewById(R.id.tv);
    }


    @Override
    public void call(Object t) {
        String t1 = (String) t;
        viewById.setText(t1);
    }
}
