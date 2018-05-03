package com.haier.jiuzhidao.myapplication.adapter_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private final int layoutId;
    private ArrayList<T> mDatas;
    private Context mContext;
    private SparseArray<OnItemClickListener> onClickListeners = new SparseArray<OnItemClickListener>();

    public RecyclerAdapter(int id) {
        layoutId = id;
    }

    public RecyclerAdapter(Context context, int id, ArrayList<T> mData) {
        layoutId = id;
        mDatas = mData;
        mContext = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BaseViewHolder.getViewHolder(parent, layoutId);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        final T t = mDatas.get(position);

        if (onClickListeners.size() != 0) {
            for (int x = 0; x < onClickListeners.size(); x++) {
                int id = onClickListeners.keyAt(0);
                final OnItemClickListener listener = onClickListeners.get(id);
                View view = holder.getView(id);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(position, t);
                    }
                });
            }
        }
        onbind(holder, position, t, mContext);
    }

    @Override
    public int getItemCount() {
        int count = mDatas == null ? 0 : mDatas.size();
        return count;
    }


    public abstract void onbind(BaseViewHolder holder, int position, T t, Context mContext);

    public void setData(List<T> data) {
        if (mDatas == null) {
            mDatas = new ArrayList<T>();
        }
        mDatas.clear();
        if (data != null) {
            mDatas.addAll(data);
        }
    }

    public void setOnClickItem(OnItemClickListener<T> i, int id) {
        OnItemClickListener listener = onClickListeners.get(id);
        if (null == listener) onClickListeners.put(id, i);
    }

    public interface OnItemClickListener<T> {
        void onItemClick(int pos, T data);
    }
}
