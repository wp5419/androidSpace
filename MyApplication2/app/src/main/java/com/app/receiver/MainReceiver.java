package com.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.app.servie.MainService;

/**
 * Created by wafer on 2016/9/27.
 */

public class MainReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.i(TAG,msg);
        Intent service = new Intent(context, MainService.class);

    }
}
