package com.nguyennt.animal.util;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

import androidx.annotation.Nullable;

import com.nguyennt.animal.util.BroadcastReceiver;

public class MyService extends Service {
    private final String LOG_TAG = "MyService";
    private String myString;
    private final BroadcastReceiver receiver = new BroadcastReceiver();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(LOG_TAG, "onCreate MyService");
        IntentFilter filter = new IntentFilter();
        filter.addAction(TelephonyManager.EXTRA_STATE);

        registerReceiver(receiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(LOG_TAG, "onStartCommand MyService");
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(TelephonyManager.EXTRA_STATE);
            sendBroadcast(broadcastIntent);
            }).start();
        return START_REDELIVER_INTENT;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "In onDestroy");
        unregisterReceiver(receiver);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(LOG_TAG, "In onBind");
        return null;    }
}