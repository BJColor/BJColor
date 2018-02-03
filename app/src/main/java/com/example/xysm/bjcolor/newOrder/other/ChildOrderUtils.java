package com.example.xysm.bjcolor.newOrder.other;

import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;

import com.example.xysm.bjcolor.newOrder.fragment.ChildFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/31.
 */

public class ChildOrderUtils {

    public static List<Pair<String, ? extends Fragment>> getOline() {
        List<Pair<String, ? extends Fragment>> onLineFragment = new ArrayList<>();
        onLineFragment.add(Pair.create("全部", new ChildFragment().initconfig(OrderEnum.onlineall)));
        onLineFragment.add(Pair.create("待发货", new ChildFragment().initconfig(OrderEnum.daishouhuo)));
        onLineFragment.add(Pair.create("待收货", new ChildFragment().initconfig(OrderEnum.daifahuo)));
        onLineFragment.add(Pair.create("已完成", new ChildFragment().initconfig(OrderEnum.yiwancheng)));

        return onLineFragment;
    }

    public static List<Pair<String, ? extends Fragment>> getLine() {
        List<Pair<String ,?extends Fragment>> lineFragment = new ArrayList<>();
        lineFragment.add(Pair.create("全部", new ChildFragment().initconfig(OrderEnum.lineall)));
        lineFragment.add(Pair.create("微信支付", new ChildFragment().initconfig(OrderEnum.weixin)));
        lineFragment.add(Pair.create("店内结算", new ChildFragment().initconfig(OrderEnum.diannei)));
        return lineFragment;
    }
}
