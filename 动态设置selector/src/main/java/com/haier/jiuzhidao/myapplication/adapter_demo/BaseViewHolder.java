package com.haier.jiuzhidao.myapplication.adapter_demo;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> mViews;
    private final View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
        mItemView = itemView;
    }

    /**
     * 根据ItemView的id获取子视图View
     * @param viewId
     * @return
     */
    public View getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }

    /**
     * 加载layoutId视图并用LGViewHolder保存
     * @param parent
     * @param layoutId
     * @return
     */
    public static BaseViewHolder getViewHolder(ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new BaseViewHolder(itemView);
    }

}
