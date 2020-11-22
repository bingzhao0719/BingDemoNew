package com.bing.bingdemo.customview;

import android.view.View;

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

    @Override
    protected void initData() {
        final View view = findViewById(R.id.view2);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
class MyPresenter extends BasePresenter{
    @Override
    protected void onCreate() {
        super.onCreate();
    }
}
