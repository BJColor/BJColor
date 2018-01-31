package com.example.xysm.bjcolor.newOrder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xysm.bjcolor.R;
import com.example.xysm.bjcolor.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/31.
 */

public class ChildFragment extends BaseFragment {

    private RecyclerView list;
    private ChildListAdapter adapter;

    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        super.setup(rootView, savedInstanceState);
        list = rootView.findViewById(R.id.rvList);
        list.setLayoutManager(new LinearLayoutManager(list.getContext(), LinearLayoutManager.VERTICAL, false));
        list.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_childlist;
    }


    public Fragment initconfig(OrderEnum type) {
        if (type == OrderEnum.line) {
            List<String> mratings = new ArrayList<>();
            for (int x = 0; x < 10; x++) {
                mratings.add(x + "-online");
            }

            adapter.setData(mratings);
            adapter.notifyDataSetChanged();
        } else if (type == OrderEnum.online) {
            ArrayList<String> mratings = new ArrayList<>();
            for (int x = 0; x < 10; x++) {
                mratings.add(x + "-line");
            }
            adapter.setData(mratings);
            adapter.notifyDataSetChanged();
        }
        return this;
    }
}