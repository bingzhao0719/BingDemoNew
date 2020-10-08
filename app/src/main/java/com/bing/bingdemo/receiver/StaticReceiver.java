package com.bing.bingdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StaticReceiver extends BroadcastReceiver {
    @Override
    public synchronized void onReceive(Context context, Intent intent) {
        Log.i("wubingzhao", "onReceive 我接收到静态广播拉: ");
    }
}
