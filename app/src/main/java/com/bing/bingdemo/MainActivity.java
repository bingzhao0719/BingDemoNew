package com.bing.bingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.bing.bingdemo.adil.BookService;
import com.bing.bingdemo.sqlite.SqliteActivity;

import static com.bing.bingdemo.adil.AidlActivity.serviceConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter("haha");
        intentFilter.setPriority(3);
        intentFilter.addAction("ee");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("wubingzhao", "onReceive MainActivity intent: "+intent +" thread:"+Thread.currentThread());
                abortBroadcast();
            }
        },intentFilter);
    }

    public void onBtnClicked(View view) {
//        Intent intent = new Intent("haha");
//        sendBroadcast(intent);
//        Intent intent = new Intent("haha");
//        sendStickyBroadcast(intent);
        startActivity(new Intent(this, SqliteActivity.class));
//        finish();

//        Intent intent = new Intent(this, BookService.class);
//        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }
}
