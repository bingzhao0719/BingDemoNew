package com.bing.bingdemo.customview;

import com.bing.bingdemo.R;
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
    }
}
class MyPresenter extends BasePresenter{
    @Override
    protected void onCreate() {
        super.onCreate();
    }
}
