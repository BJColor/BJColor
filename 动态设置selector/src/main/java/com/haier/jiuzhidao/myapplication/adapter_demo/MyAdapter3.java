package com.haier.jiuzhidao.myapplication.adapter_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haier.jiuzhidao.myapplication.R;
import com.haier.jiuzhidao.myapplication.selector.IconBean;
import com.haier.jiuzhidao.myapplication.selector.SelectorUtil;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mc;
    private final ArrayList<IconBean> mDatas;

    public MyAdapter3(Context context, ArrayList<IconBean> mData) {
        mc = context;
        mDatas = mData;
    }

    public enum Item_Type {
        RECYCLEVIEW_ITEM_TYPE_1,
        RECYCLEVIEW_ITEM_TYPE_2,
        RECYCLEVIEW_ITEM_TYPE_3
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Item_Type.RECYCLEVIEW_ITEM_TYPE_1.ordinal()) {
            View mView = LayoutInflater.from(mc).inflate(R.layout.adapter3_item_a, parent, false);
            ViewHolderA viewHolder = new ViewHolderA(mView);
            return viewHolder;
        } else if (viewType == Item_Type.RECYCLEVIEW_ITEM_TYPE_2.ordinal()) {
            View mView = LayoutInflater.from(mc).inflate(R.layout.adapter3_item_b, parent, false);
            ViewHolderB viewHolder = new ViewHolderB(mView);
            return viewHolder;
        } else if (viewType == Item_Type.RECYCLEVIEW_ITEM_TYPE_3.ordinal()) {
            View mView = LayoutInflater.from(mc).inflate(R.layout.adapter3_item_c, parent, false);
            ViewHolderC viewHolder = new ViewHolderC(mView);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        IconBean mData = mDatas.get(position);
        if (holder instanceof ViewHolderA) {
            ((ViewHolderA) holder).textView.setText("------样式一");
            SelectorUtil.addSeletorFromNet(MyAdapter2.class, mData.getDrawbleDown(), mData.getDrawbleUp(), ((ViewHolderA
                    ) holder).imageView, mc);
        } else if (holder instanceof ViewHolderB) {
            ((ViewHolderB) holder).textView.setText("------样式二");
        } else if (holder instanceof ViewHolderC) {
            SelectorUtil.addSeletorFromNet(MyAdapter2.class, mData.getDrawbleDown(), mData.getDrawbleUp(), ((ViewHolderC) holder).imageView, mc);
        }

    }


    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position).getType() == 0) {
            return Item_Type.RECYCLEVIEW_ITEM_TYPE_1.ordinal();
        } else if (mDatas.get(position).getType() == 1) {
            return Item_Type.RECYCLEVIEW_ITEM_TYPE_2.ordinal();
        } else if (mDatas.get(position).getType() == 2) {
            return Item_Type.RECYCLEVIEW_ITEM_TYPE_3.ordinal();
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private class ViewHolderA extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;

        public ViewHolderA(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    private class ViewHolderB extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolderB(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }

    private class ViewHolderC extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolderC(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
}