package com.bing.bingdemo.customview;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.bing.bingdemo.R;
import com.bing.bingdemo.TestActivity;
import com.bing.core.BaseActivity;
import com.bing.core.BasePresenter;

public class MyViewActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_view;
    }

    @Override
    protected BasePresenter newPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("wubingzhao", "MyViewActivity onDestroy: ");
    }

    @Override
    protected void initData() {
    }
}
class MyPresenter extends BasePresenter{
    @Override
    protected void onCreate() {
        super.onCreate();
    }
}
