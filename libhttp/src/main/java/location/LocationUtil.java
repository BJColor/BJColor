package location;

import android.content.Context;

import location.api.HaierLocationListener;
import location.bean.HaierLocationBean;
import location.manage.InsideManage;



public class LocationUtil {
    private LocationUtil(){}
    private static HaierLocationBean bean = new HaierLocationBean();
    //延迟定位
    public static HaierLocationBean getLastLocationBeanAndGoLocation(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context can not is null");
        } else {
            onLocation(context, null);
        }
        return bean;
    }
    //及时定位
    public static void onLocation(Context context, final HaierLocationListener listener) {
        InsideManage.init(context).getLocation(new HaierLocationListener() {
            @Override
            public void onLocating() {
                if (listener != null) {
                    listener.onLocating();
                }
            }

            @Override
            public void onLocationSuccess(HaierLocationBean haierLocationBean) {
                bean = haierLocationBean;
                if (listener != null) {
                    listener.onLocationSuccess(haierLocationBean);
                }
            }

            @Override
            public void onLocationFailed(int reason) {
                if (listener != null) {
                    listener.onLocationFailed(reason);
                }
            }
        });
    }
}
