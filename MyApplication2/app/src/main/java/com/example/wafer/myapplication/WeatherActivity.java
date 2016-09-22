package com.example.wafer.myapplication;

import android.app.Activity;
import android.os.Bundle;

import com.api.global.GlobalParam;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by wafer on 2016/9/22.
 */

public class WeatherActivity extends Activity {

    String requestUrl = GlobalParam.TEST_URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        x.Ext.init(getApplication());
        x.Ext.setDebug(true);
        RequestParams rp = new RequestParams(requestUrl);
        x.http().get(rp, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.print(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        }
    );
    }


}
