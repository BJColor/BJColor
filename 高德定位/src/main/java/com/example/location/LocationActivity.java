package com.example.location;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;

import location.AmapLocationUtil;
import toasts.ToastUtil;


/**
 * Created by BJColor on 2018/1/22.
 */

public class LocationActivity extends CheckPermissionsActivity implements
        AMap.InfoWindowAdapter,
        AMap.OnCameraChangeListener,
        GeocodeSearch.OnGeocodeSearchListener,
        View.OnClickListener {

    private MapView mapView;
    private AMap mMap;
    private Marker marker;
    private GeocodeSearch geocoderSearch;
    private Button btnOk;
    private Button btnCancel;
    private Button btnMyLoc;
    private String address;
    private double latitude;
    private double longitude;
    private UiSettings uiSettings;
    private RegeocodeQuery query;
    private String adCode;
    private AmapLocationUtil locationUtil;
    private TextView tvAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_activity);
        //        显示全世界地图
        MapsInitializer.loadWorldGridMap(true);
        FindId();
        init(savedInstanceState);
        setClick();
        //         初始化定位我的位置
        initLocation();
    }

    private void FindId() {
        mapView = (MapView) findViewById(R.id.mMapView);
        btnOk = (Button) findViewById(R.id.btnok);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnMyLoc = (Button) findViewById(R.id.btn_amp_address);
        tvAdd = findViewById(R.id.tv_address);
    }

    private void init(Bundle savedInstanceState) {
        mapView.onCreate(savedInstanceState); // 此方法必须重写
        if (mMap == null) {
            mMap = mapView.getMap();
            uiSettings = mMap.getUiSettings();
            marker = mMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
//                    .draggable(true)  //拖拽暂时无用
                    .icon(BitmapDescriptorFactory.fromBitmap(changeBitmapSize())));
//       mark标志固定在屏幕中心
            marker.setPositionByPixels(mapView.getWidth() / 2,
                    mapView.getHeight() / 2);
        }
    }


    private void setClick() {
        btnOk.setOnClickListener(this);
        btnMyLoc.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        //        逆编码获取地址
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
        //        地图改变监听
        mMap.setOnCameraChangeListener(this);
        //  自定义
        mMap.setInfoWindowAdapter(this);
    }


    /**
     * 初始化位置(我的位置)
     */
    private void initLocation() {
        locationUtil = new AmapLocationUtil(this);
        locationUtil.setLocationListener(new AmapLocationUtil.LocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation.getErrorCode() == 0) {
                    latitude = amapLocation.getLatitude();
                    longitude = amapLocation.getLatitude();
                    address = amapLocation.getAddress();
                    adCode = amapLocation.getAdCode();
                    LatLng latLng = new LatLng(amapLocation.getLatitude(), amapLocation.getLongitude());

                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                            latLng, 15));
//                  设置mark点
                    marker.setPosition(latLng);
                }
            }
        });
    }


    /**
     * setOnGeocodeSearchListener  回调
     *
     * @param result
     * @param rCode
     */
    @Override
    public void onRegeocodeSearched(RegeocodeResult result, int rCode) {
        if (rCode == 1000) {
            if (result != null && result.getRegeocodeAddress() != null
                    && result.getRegeocodeAddress().getFormatAddress() != null &&
                    !result.getRegeocodeAddress().getFormatAddress().equals("")
                    ) {
                address = result.getRegeocodeAddress().getFormatAddress() + "附近";
                adCode = result.getRegeocodeAddress().getAdCode();
                setMark(latitude, longitude, address);
            } else {
                ToastUtil.showToastCenter("定位错误");
            }
        } else {
            ToastUtil.showToastCenter("定位错误");
        }
    }


    private void setMark(double latitude, double longitude, String address) {
//                设置中心点
        CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(latitude, longitude)
                , 15, 30, 0));
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
//                        AMapUtil.convertToLatLng(latLonPoint), 15));
//        设置标题
        marker.setTitle("定位的位置:");
//                  设置内容
        marker.setSnippet(address);
//        自动显示弹框
        marker.showInfoWindow();
        ToastUtil.showToastCenter(address);
    }

    /**
     * 地理编码查询回调
     */
    @Override
    public void onGeocodeSearched(GeocodeResult result, int rCode) {
    }

    /**
     * 响应逆地理编码
     */
    public void getAddres(final LatLonPoint latLonPoint) {
        // 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
        if (null == query) {
            query = new RegeocodeQuery(latLonPoint, 200,
                    GeocodeSearch.AMAP);
        } else {
            query.setPoint(latLonPoint);
        }
        geocoderSearch.getFromLocationAsyn(query);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnok:
//                Intent intent = new Intent();
//                intent.putExtra("address", address + "");
//                intent.putExtra("lat", latitude + "");
//                intent.putExtra("lng", longitude + "");
//                intent.putExtra("code", adCode + "");
//                setResult(1, intent);
//                finish();
                ToastUtil.showToastCenter("地址:" + address + "经度:" + latitude + "纬度:" + longitude);
                tvAdd.setText(String.format(getString(R.string.amp_address),latitude+"",longitude+"",address));
                break;
            case R.id.btnCancel:
                ToastUtil.showToastCenter("取消.");
//                finish();
                break;
            case R.id.btn_amp_address:
                initLocation();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationUtil.onDestroy();
        mapView.onDestroy();
    }

    private Bitmap changeBitmapSize() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.purple_pin);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //设置想要的大小
        int newWidth = 80;
        int newHeight = 80;

        //计算压缩的比率
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        //获取想要缩放的matrix
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        //获取新的bitmap
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        bitmap.getWidth();
        bitmap.getHeight();
        return bitmap;
    }


    /**
     * @param position
     */
    @Override
    public void onCameraChange(CameraPosition position) {
        marker.setPosition(new LatLng(position.target.latitude, position.target.longitude));
    }

    @Override
    public void onCameraChangeFinish(CameraPosition postion) {
        latitude = postion.target.latitude;
        longitude = postion.target.longitude;

        getAddres(new LatLonPoint(postion.target.latitude, postion.target.longitude));
    }


    /**
     * 监听自定义infowindow窗口的infocontents事件回调
     */
    @Override
    public View getInfoContents(Marker marker) {

        View infoWindow = getLayoutInflater().inflate(
                R.layout.custom_info_window, null);

        render(marker, infoWindow);
        return infoWindow;
    }

    /**
     * 监听自定义infowindow窗口的infowindow事件回调
     */
    @Override
    public View getInfoWindow(Marker marker) {

        View infoWindow = getLayoutInflater().inflate(
                R.layout.custom_info_window, null);

        render(marker, infoWindow);
        return infoWindow;
    }

    /**
     * 自定义infowinfow窗口
     */
    public void render(Marker marker, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.badge);
        imageView.setImageResource(R.mipmap.ic_launcher);
        String title = marker.getTitle();
        TextView titleUi = ((TextView) view.findViewById(R.id.title));
        if (title != null) {
            SpannableString titleText = new SpannableString(title);
            titleText.setSpan(new ForegroundColorSpan(Color.BLACK), 0,
                    titleText.length(), 0);
            titleUi.setTextSize(15);
            titleUi.setText(titleText);

        } else {
            titleUi.setText("");
        }
        String snippet = marker.getSnippet();
        TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
        if (snippet != null) {
            snippetUi.setText(snippet);
        } else {
            snippetUi.setText("");
        }
    }
}
