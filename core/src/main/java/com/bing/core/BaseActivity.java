package com.bing.core;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ARouter.getInstance().inject(this);
        presenter = newPresenter();
        if(presenter != null){
            presenter.attach(this);
            getLifecycle().addObserver(presenter);
        }
        int layoutId = getLayoutId();
        if (layoutId > 0) {
            FrameLayout contentLayout = findViewById(R.id.contentLayout);
            View inflate = LayoutInflater.from(this).inflate(layoutId, contentLayout,false);
            contentLayout.addView(inflate);
        }
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null){
            getLifecycle().removeObserver(presenter);
        }
    }

    protected P newPresenter() {
        return null;
    }
    protected P getPresenter(){
        return presenter;
    }

    protected abstract int getLayoutId();

    protected void initView() {

    }

    protected void initData() {

    }
    public static void test(){
        Log.i("wubingzhao", "base test: ");
    }
}