package com.bing.bingdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bing.bingdemo.adil.BookService;
import com.ibalife.base_service.AppConfig;
import com.ibalife.base_service.BaseApp;

import static com.bing.bingdemo.adil.AidlActivity.serviceConnection2;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("wubingzhao", "MyApplication onCreate: ");
        initModuleApp();
        if(BuildConfig.DEBUG){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            private void onAppForeground(){
                Log.i("wubingzhao", "onAppForeground: ");
            }
            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            private void onAppBackground(){
                Log.i("wubingzhao", "onAppBackground: ");
            }
        });

    }

    private void initModuleApp() {
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApp baseApp = (BaseApp) clazz.newInstance();
                baseApp.initModuleApp(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
