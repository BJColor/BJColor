package com.haier.zxing;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.haier.zxing.core.QRCodeDecoder;
import com.haier.zxing.core.QRCodeView;
import com.haier.zxing.core.ZXingView;


/**
 * Author:sunnyhack
 * E-mail:sunnyhack@live.com
 * Date:on 18/4/24.
 * Description:
 */

public class QRCodeScanActivity extends AppCompatActivity implements QRCodeView.Delegate{
    private static final String TAG = QRCodeScanActivity.class.getSimpleName();
    private static final int REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY = 666;

    private QRCodeView mQRCodeView;
    private TextView scan_barcode;
    private TextView scan_qrcode;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan);

        mQRCodeView = (ZXingView)findViewById(R.id.zxingview);
        mQRCodeView.setDelegate(this);
        scan_barcode = (TextView)findViewById(R.id.scan_barcode);
        scan_qrcode = (TextView)findViewById(R.id.scan_qrcode);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera(0);
//        mQRCodeView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);

        mQRCodeView.showScanRect();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.i(TAG, "result:" + result);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        vibrate();
        mQRCodeView.startSpot();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.scan_barcode) {
            mQRCodeView.startSpot();
            mQRCodeView.changeToScanBarcodeStyle();
            scan_barcode.setBackground(getResources().getDrawable(R.drawable.selector_btn_orange));
            scan_qrcode.setBackground(getResources().getDrawable(R.drawable.selector_btn_storke_orang));
            scan_barcode.setTextColor(getResources().getColor(R.color.black));
            scan_qrcode.setTextColor(getResources().getColor(R.color.gold_color));
        } else if (i == R.id.scan_qrcode) {
            mQRCodeView.startSpot();
            mQRCodeView.changeToScanQRCodeStyle();
            scan_barcode.setBackground(getResources().getDrawable(R.drawable.selector_btn_storke_orang));
            scan_qrcode.setBackground(getResources().getDrawable(R.drawable.selector_btn_orange));
            scan_barcode.setTextColor(getResources().getColor(R.color.gold_color));
            scan_qrcode.setTextColor(getResources().getColor(R.color.black));


        }else if (i==R.id.back){
            this.finish();
        }
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mQRCodeView.showScanRect();

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY) {

            new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... params) {
                    return QRCodeDecoder.syncDecodeQRCode("");
                }

                @Override
                protected void onPostExecute(String result) {
                    if (TextUtils.isEmpty(result)) {
                        Toast.makeText(QRCodeScanActivity.this, "未发现二维码", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QRCodeScanActivity.this, result, Toast.LENGTH_SHORT).show();
                    }
                }
            }.execute();
        }
    }

}
