package com.haier.jiuzhidao.myapplication.adapter_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.haier.jiuzhidao.myapplication.R;
import com.haier.jiuzhidao.myapplication.selector.IconBean;
import com.haier.jiuzhidao.myapplication.selector.RecyclerSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int pos;
    ArrayList<IconBean> iconBeans = new ArrayList<>();
    private LinearLayout root;
    private RecyclerView mRecyclerView;
    private String[] strings = {"http://pic15.nipic.com/20110803/7180732_211822337168_2.jpg",
            "http://pic3.16pic.com/00/52/03/16pic_5203046_b.jpg",
            "http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg",
            "http://pic.58pic.com/58pic/13/71/06/63J58PIC2FC_1024.jpg",
            "http://pic.58pic.com/58pic/14/13/67/98B58PICGe8_1024.jpg",
            "http://pic34.photophoto.cn/20150127/0006019093196381_b.jpg",
            "http://img3.3lian.com/2013/c2/78/d/38.jpg",
            "http://pic2.ooopic.com/12/42/25/02bOOOPIC95_1024.jpg",
            "http://pic15.nipic.com/20110803/7180732_211822337168_2.jpg",
            "http://pic3.16pic.com/00/52/03/16pic_5203046_b.jpg",
            "http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg",
            "http://pic.58pic.com/58pic/13/71/06/63J58PIC2FC_1024.jpg",
            "http://pic.58pic.com/58pic/14/13/67/98B58PICGe8_1024.jpg",
            "http://pic34.photophoto.cn/20150127/0006019093196381_b.jpg",
            "http://img3.3lian.com/2013/c2/78/d/38.jpg",
            "http://pic2.ooopic.com/12/42/25/02bOOOPIC95_1024.jpg"

    };
    private String[] strings2 = {"http://pic15.nipic.com/20110803/7180732_211822337168_2.jpg",
            "http://pic3.16pic.com/00/52/03/16pic_5203046_b.jpg",
            "http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg",
            "http://pic.58pic.com/58pic/13/71/06/63J58PIC2FC_1024.jpg",
            "http://pic.58pic.com/58pic/14/13/67/98B58PICGe8_1024.jpg",
            "http://pic34.photophoto.cn/20150127/0006019093196381_b.jpg",
            "http://img3.3lian.com/2013/c2/78/d/38.jpg",
            "http://pic2.ooopic.com/12/42/25/02bOOOPIC95_1024.jpg",
            "http://pic15.nipic.com/20110803/7180732_211822337168_2.jpg",
            "http://pic3.16pic.com/00/52/03/16pic_5203046_b.jpg",
            "http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg",
            "http://pic.58pic.com/58pic/13/71/06/63J58PIC2FC_1024.jpg",
            "http://pic.58pic.com/58pic/14/13/67/98B58PICGe8_1024.jpg",
            "http://pic34.photophoto.cn/20150127/0006019093196381_b.jpg",
            "http://img3.3lian.com/2013/c2/78/d/38.jpg",
            "http://pic2.ooopic.com/12/42/25/02bOOOPIC95_1024.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.rvl);
        root = (LinearLayout) findViewById(R.id.root);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new RecyclerSpaceItemDecoration(22));


        MyAdapter3 myAdapter = new MyAdapter3(this, iconBeans);
        mRecyclerView.setAdapter(myAdapter);
    }

    private List<IconBean> initData() {

        for (int x = 1; x <= 16; x++) {
            IconBean iconBean = new IconBean();
            int type = x % 3;
            if (type == MyAdapter3.Item_Type.RECYCLEVIEW_ITEM_TYPE_1.ordinal()) {
                iconBean.setType(0);
            } else if (type == MyAdapter3.Item_Type.RECYCLEVIEW_ITEM_TYPE_2.ordinal()) {
                iconBean.setType(1);
            } else {
                iconBean.setType(2);
            }
            iconBean.setIconName("创建条目_" + 1);
            iconBean.setDrawbleDown(strings[x - 1]);
            iconBean.setDrawbleUp(strings2[strings2.length - x]);
            iconBeans.add(iconBean);
        }
        return iconBeans;
    }
}
