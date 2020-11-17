package com.bing.core;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class BasePresenter<V> implements LifecycleObserver {
    protected V activity;
    protected void attach(V view){
        activity = view;
    }
    protected V getV(){
        return activity;
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate(){

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume(){

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy(){
    }
}
