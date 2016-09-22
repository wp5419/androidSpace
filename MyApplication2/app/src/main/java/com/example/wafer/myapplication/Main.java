package com.example.wafer.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.api.global.GlobalParam;

import org.w3c.dom.Text;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by wafer on 2016/9/21.
 */

public class Main extends Activity{
    String requestUrl = GlobalParam.TEST_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        x.Ext.init(getApplication());
    }
    public void onWeatherClick(View view){
        String url = "http://192.168.0.154/messageCenter/oa/doc/findFileList?token=DBC04F578D15C8DD7FC200F6E2E7040722B29B2A5F2BC70A9C9E7B3289D2618CB16FE7824FB431FC021355CD7804C373AE16D52E5853910AA80E162DDE9646B3&id=1";

        RequestParams rp = new RequestParams(url);
        x.http().get(rp, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.print(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.print("error");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}