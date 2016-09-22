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
        Button btn = (Button) findViewById(R.id.login);
        Button pBtn = (Button) findViewById(R.id.cancle);
        Button cBtn = (Button) findViewById(R.id.clear);

    }
    public void onWeatherClick(View view){
        RequestParams rp = new RequestParams(GlobalParam.TEST_URL);
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