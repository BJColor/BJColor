package com.haier.jiuzhidao.myapplication.selector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.haier.jiuzhidao.myapplication.adapter_demo.MyAdapter2;
import com.haier.jiuzhidao.myapplication.R;
import com.haier.jiuzhidao.myapplication.adapter_demo.RecyclerAdapter;
import com.haier.zxing.QRCodeScanActivity;

import java.util.ArrayList;

import toasts.ToastUtil;

public class MainActivity extends AppCompatActivity {
    private int pos;
    private LinearLayout root;
    private RecyclerView mRecyclerView;
    private String[] strings = {"http://pic15.nipic.com/20110803/7180732_211822337168_2.jpg",
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
            "http://pic2.ooopic.com/12/42/25/02bOOOPIC95_1024.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvl);
        root = (LinearLayout) findViewById(R.id.root);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new RecyclerSpaceItemDecoration(22));


        ArrayList<IconBean> iconBeans = new ArrayList<>();


        for (int x = 1; x <= 8; x++) {
            IconBean iconBean = new IconBean();
            iconBean.setIconName("创建条目_" + 1);
            iconBean.setDrawbleDown(strings[x - 1]);
            iconBean.setDrawbleUp(strings2[strings2.length - x]);
            iconBeans.add(iconBean);
        }


        MyAdapter2 myAdapter = new MyAdapter2(this, R.layout.adapter_item, iconBeans);
        mRecyclerView.setAdapter(myAdapter);
//        myAdapter.setOnClickItem(new RecyclerAdapter.OnItemClickListener<IconBean>() {
//            @Override
//            public void onItemClick(int pos, IconBean data) {
//                ToastUtil.showToastCenter("Item:" + pos);
//            }
//        });
    }

    public  void title(View view){
        Intent manageIntent = new Intent(this, QRCodeScanActivity.class);
        startActivity(manageIntent);
//        startActivity(new Intent(this, com.haier.jiuzhidao.myapplication.adapter_demo.MainActivity.class));
    }
}
//package com.haier.jiuzhidao.myapplication;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.widget.LinearLayout;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//    private int pos;
//    private LinearLayout root;
//    private RecyclerView mRecyclerView;
//    private String[] strings = {"http://pic15.nipic.com/20110803/7180732_211822337168_2.jpg",
//            "http://pic3.16pic.com/00/52/03/16pic_5203046_b.jpg",
//            "http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg",
//            "http://pic.58pic.com/58pic/13/71/06/63J58PIC2FC_1024.jpg",
//            "http://pic.58pic.com/58pic/14/13/67/98B58PICGe8_1024.jpg",
//            "http://pic34.photophoto.cn/20150127/0006019093196381_b.jpg",
//            "http://img3.3lian.com/2013/c2/78/d/38.jpg",
//            "http://pic2.ooopic.com/12/42/25/02bOOOPIC95_1024.jpg"
//
//    };
//    private String[] strings2 = {"http://pic15.nipic.com/20110803/7180732_211822337168_2.jpg",
//            "http://pic3.16pic.com/00/52/03/16pic_5203046_b.jpg",
//            "http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg",
//            "http://pic.58pic.com/58pic/13/71/06/63J58PIC2FC_1024.jpg",
//            "http://pic.58pic.com/58pic/14/13/67/98B58PICGe8_1024.jpg",
//            "http://pic34.photophoto.cn/20150127/0006019093196381_b.jpg",
//            "http://img3.3lian.com/2013/c2/78/d/38.jpg",
//            "http://pic2.ooopic.com/12/42/25/02bOOOPIC95_1024.jpg"
//
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mRecyclerView = (RecyclerView) findViewById(R.id.rvl);
//        root = (LinearLayout) findViewById(R.id.root);
//
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new RecyclerSpaceItemDecoration(22));
//
//
//        ArrayList<IconBean> iconBeans = new ArrayList<>();
//
//
//        for (int x = 1; x <= 8; x++) {
//            IconBean iconBean = new IconBean();
//            iconBean.setIconName("创建条目_" + 1);
//            iconBean.setDrawbleDown(strings[x - 1]);
//            iconBean.setDrawbleUp(strings2[strings2.length - x]);
//            iconBeans.add(iconBean);
//        }
//
//
//        MyAdapter2 myAdapter = new MyAdapter2(this, R.layout.adapter_item, iconBeans);
////        MyAdapter myAdapter = new MyAdapter(this, R.layout.adapter_item, iconBeans);
//        mRecyclerView.setAdapter(myAdapter);
//    }
//}
