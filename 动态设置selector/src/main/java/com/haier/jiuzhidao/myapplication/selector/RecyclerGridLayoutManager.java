package com.haier.jiuzhidao.myapplication.selector;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

public class RecyclerGridLayoutManager  extends GridLayoutManager {

    public RecyclerGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public RecyclerGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public RecyclerGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        //捕获系统异常,RecyclerView存在BUG
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            Log.e("error", "meet a IOOBE in RecyclerView");
        }
    }
}
