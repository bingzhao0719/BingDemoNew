package com.bing.core;

public class BasePresenter<V> {
    protected V activity;
    protected void attach(V view){
        activity = view;
    }
    protected V getV(){
        return activity;
    }
    protected void init(){

    }
}
