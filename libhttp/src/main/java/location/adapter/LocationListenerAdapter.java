package location.adapter;


import location.api.HaierLocationListener;


public abstract class LocationListenerAdapter implements HaierLocationListener {
    @Override
    public void onLocating() {

    }

    @Override
    public void onLocationFailed(int reason) {

    }
}
