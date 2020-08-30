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
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;

import com.bing.bingdemo.MainActivity;
import com.bing.bingdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AidlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        IntentFilter intentFilter = new IntentFilter("haha");
        intentFilter.setPriority(2);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i("wubingzhao", "onReceive aidlActivity intent: "+intent +" thread:"+Thread.currentThread());
//                abortBroadcast();
            }
        },intentFilter);
    }

    public void onBtnAdd(View view) {
        Book book = new Book();
        book.bookId = 1;
        book.bookName = "吴秉钊出书";
        try {
            bookM.addBook(book);
            Log.i("wubingzhao", "onBtnSearch add success ");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        startActivity(intent);

//        PackageManager packageManager = getPackageManager();
//        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
//        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(mainIntent, 0);
//        Log.i("wubingzhao", "onBtnAdd: "+resolveInfos.size());
//        for (ResolveInfo info : resolveInfos) {
//            ApplicationInfo applicationInfo = info.activityInfo.applicationInfo;
//            Log.i("wubingzhao", "onBtnInsert icon: "+applicationInfo.icon+"--"+applicationInfo.logo);
//        }
//        ImageView imageview = findViewById(R.id.imageview);
//        ResolveInfo info = resolveInfos.get(0);
//        imageview.setImageDrawable(info.activityInfo.applicationInfo.loadIcon(getPackageManager()));
    }

    public void onBtnSearch(View view) {
        try {
            List<Book> bookList = bookM.getBookList();
            Log.i("wubingzhao", "onBtnSearch bookList: "+bookList);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onBtnGetService(View view) {
        Intent intent = new Intent(this,BookService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

        // 1 2 3 5

//        ArrayMap<String,String> arrayMap = new ArrayMap<>();
//        arrayMap.put("1","11");
//        arrayMap.put("3","33");
//        arrayMap.put("2","22");
//        Log.i("wubingzhao", "onBtnGetService: "+"1".hashCode()+"::"+"2".hashCode()+"::"+"3".hashCode());
//        String name = arrayMap.get("3");
//        Log.i("wubingzhao", "onBtnGetService name: "+name);
    }

    public void onBtnGetOne(View view) {
        Intent intent = new Intent(this,BookService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("wubingzhao", "onServiceConnected service: "+service+" name:"+name);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
//        Book book = new Book();
//        book.bookId = 12;
//        book.bookName = "hahahha";
//
//        List<Book> list = new LinkedList<>();
//        list.add(book);
//        try {
//            bookM.addBookList(list);
//            Log.i("wubingzhao", "onBtnGetOne book: "+book);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }


    }
}
