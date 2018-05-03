package com.haier.jiuzhidao.myapplication.selector;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haier.jiuzhidao.myapplication.R;

import java.util.List;

import toasts.ToastUtil;

public class MyAdapter extends BaseQuickAdapter<IconBean> {

    public MyAdapter(Context context, int layoutResId, List<IconBean> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, IconBean data) {
        TextView textView = holder.convertView.findViewById(R.id.tv);
        ImageView imageView = holder.convertView.findViewById(R.id.iv);

        textView.setText(data.getIconName());
        SelectorUtil.addSeletorFromNet(MyAdapter.class, data.getDrawbleDown(), data.getDrawbleUp(), imageView, mContext);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToastCenter(holder.getLayoutPosition() + "");
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}