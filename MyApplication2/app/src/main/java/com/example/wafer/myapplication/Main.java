package com.example.wafer.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.api.global.GlobalParam;
import com.app.model.FileInfo;
import com.app.model.Result;

import org.w3c.dom.Text;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by wafer on 2016/9/21.
 */
//@ContentView(R.layout.layout)
public class Main extends Activity{
    String requestUrl = GlobalParam.TEST_URL;
    public  FileInfo file;
    @ViewInject(R.id.weather)
    private Button ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        x.Ext.init(getApplication());
        x.view().inject(this);
        Application app = getApplication();
        getFileInfo();
    }


    @Event(value=R.id.weather)
    private void onWeatherClick(View view){
        Intent intent = new Intent();
        Bundle bundle =new Bundle();
        bundle.putSerializable("fileInfo",file);
        intent.putExtras(bundle);
        intent.setClass(this,FileInfoActivity.class);
        startActivity(intent);
      /*  bindService();
        unbindService();*/
    }


    /**
     * 相应广播函数
     */
    private void sendBroadCast(View view){
        Intent intent = new Intent("action url");
        intent.putExtra("msg","1");
        sendBroadcast(intent);
    }
    private void getFileInfo(){
        String url = "http://192.168.0.154/messageCenter/oa/doc/findFileList?token=DBC04F578D15C8DD7FC200F6E2E7040722B29B2A5F2BC70A9C9E7B3289D2618CB16FE7824FB431FC021355CD7804C373AE16D52E5853910AA80E162DDE9646B3&id=1";
        RequestParams rp = new RequestParams(url);
        x.http().get(rp, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Result r = JSON.parseObject(result, Result.class);
                List<FileInfo> resultList = r.getResObjs();
                if(!resultList.isEmpty()){
                    file = resultList.get(1);
                }

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