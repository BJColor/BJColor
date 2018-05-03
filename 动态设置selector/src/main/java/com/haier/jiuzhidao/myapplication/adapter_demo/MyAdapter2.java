package com.haier.jiuzhidao.myapplication.adapter_demo;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haier.jiuzhidao.myapplication.R;
import com.haier.jiuzhidao.myapplication.selector.IconBean;
import com.haier.jiuzhidao.myapplication.selector.SelectorUtil;

import java.util.ArrayList;

import toasts.ToastUtil;

public class MyAdapter2 extends RecyclerAdapter<IconBean> {

    public MyAdapter2(int id) {
        super(id);
    }

    public MyAdapter2(Context context, int id, ArrayList<IconBean> mData) {
        super(context, id, mData);
    }

    @Override
    public void onbind(BaseViewHolder holder, final int position, IconBean data, Context mContext) {
        TextView textView = holder.itemView.findViewById(R.id.tv);
        ImageView imageView = holder.itemView.findViewById(R.id.iv);

        textView.setText(data.getIconName());
        SelectorUtil.addSeletorFromNet(MyAdapter2.class, data.getDrawbleDown(), data.getDrawbleUp(), imageView, mContext);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToastCenter("TextView:" + position);
            }
        });
    }

}