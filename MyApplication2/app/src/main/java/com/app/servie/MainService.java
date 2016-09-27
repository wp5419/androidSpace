package com.app.servie;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.app.receiver.MainReceiver;

/**
 * Created by wafer on 2016/9/27.
 */

public class MainService extends Service {

    private MainReceiver receiver;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        receiver = new MainReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("action url");
        registerReceiver(receiver,filter);
        /**
         *
         */

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends  Binder{
        public void LogOut(){
            Log.i("","");
        }
    }
}
