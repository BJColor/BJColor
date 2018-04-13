package location.api;


import location.bean.HaierLocationBean;


public interface HaierLocationListener {
    public void onLocating();
    public void onLocationSuccess(HaierLocationBean rxLocationBean);
    public void onLocationFailed(int reason);
}
