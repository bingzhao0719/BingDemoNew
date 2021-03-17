package com.bing.bingdemo.adil;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bing.bingdemo.BaseActivity;
import com.bing.bingdemo.MainActivity;
import com.bing.bingdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AidlActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
//        IntentFilter intentFilter = new IntentFilter("haha");
//        intentFilter.setPriority(2);
//        registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Log.i("wubingzhao", "onReceive aidlActivity intent: "+intent +" thread:"+Thread.currentThread());
////                abortBroadcast();
//            }
//        },intentFilter);
    }

    private static IBookM bookM;

    public static  ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("wubingzhao", "onServiceConnected service: "+service+" name:"+name);
            bookM = IBookM.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("wubingzhao", "----onServiceDisconnected name: "+name);
        }
    };

    public static  ServiceConnection serviceConnection2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("wubingzhao", "onServiceConnected 2 service: "+service+" name:"+name);
            bookM = IBookM.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("wubingzhao", "----onServiceDisconnected 2 name: "+name);
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onBtnGetService(View view) {
        Intent intent = new Intent(this,BookService.class);
        intent.setAction("1");
//        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        startService(intent);
//        intent = new Intent(this,BookService.class);
//        intent.setAction("2");
//        startService(intent);
    }


    public void onBtnAdd(View view) {
        Intent intent = new Intent(this,BookService.class);
        bindService(intent, serviceConnection2, Context.BIND_AUTO_CREATE);
//        Book book = new Book();
//        book.bookId = 1;
//        book.bookName = "吴秉钊出书";
//        try {
//            bookM.addBook(book);
//            Log.i("wubingzhao", "onBtnSearch add success ");
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }

    public void onBtnGetOne(View view) {
//        Intent intent = new Intent(this,BookService.class);
//        bindService(intent, new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//                Log.i("wubingzhao", "onServiceConnected service: "+service+" name:"+name);
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//
//            }
//        }, Context.BIND_AUTO_CREATE);

        Intent intent = new Intent(this,BookService.class);
        stopService(intent);
//        unbindService(serviceConnection);

    }
    public void onBtnSearch(View view) {
        unbindService(serviceConnection2);
//        try {
//            List<Book> bookList = bookM.getBookList();
//            Log.i("wubingzhao", "onBtnSearch bookList: "+bookList);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

    }
}
