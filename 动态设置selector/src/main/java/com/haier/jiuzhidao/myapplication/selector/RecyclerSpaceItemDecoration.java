package com.haier.jiuzhidao.myapplication.selector;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public RecyclerSpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        outRect.bottom = space;
    }
}