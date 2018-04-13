package location.api;

import android.content.Context;


public interface HaierLocationHandler {
    public void init(Context context);
    public void setListener(HaierLocationListener listener);
    public void onStart();
    public boolean isStart();
    public void onStop();
    public void onDestroy();
}
