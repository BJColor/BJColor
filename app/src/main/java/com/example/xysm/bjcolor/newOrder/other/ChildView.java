package com.example.xysm.bjcolor.newOrder.other;

import android.support.v7.widget.RecyclerView;

import com.example.xysm.bjcolor.newOrder.adapter.ChildListAdapter;

import java.util.List;

/**
 * Created by XYSM on 2018/2/1.
 */

public  class ChildView {
    public ChildView(RecyclerView list,  List<String> mratings) {
        ChildListAdapter adapter = new ChildListAdapter();
        adapter.setData(mratings);
        list.setAdapter(adapter);
    }

}
