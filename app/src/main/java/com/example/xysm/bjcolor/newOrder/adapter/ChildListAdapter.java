package com.example.xysm.bjcolor.newOrder.adapter;

import android.widget.TextView;

import com.example.xysm.bjcolor.R;

/**
 * Created by XYSM on 2018/1/31.
 */

public class ChildListAdapter extends RecyclerAdapter<String> {

    public ChildListAdapter() {
        super(R.layout.activity_order_list);
    }

    @Override
    public void onBind(CommHolder holder, int position, int viewType, String data) {
        TextView view = holder.getView(R.id.tv);
        view.setText(data);
    }
}