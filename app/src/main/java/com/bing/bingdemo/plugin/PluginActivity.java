package com.bing.bingdemo.plugin;

import android.util.Log;
import android.view.View;

import com.bing.bingdemo.R;
import com.bing.core.BaseActivity;

public class PluginActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_plugin;
    }

    @Override
    protected void initData() {
        PluginHelper.loadPluginApk(this,getClassLoader());
    }

    public void onBtnClicked1(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        try {
            Class<?> aClass = Class.forName("com.bing.order.Test");
            Object newInstance = aClass.newInstance();
            Log.i("wubingzhao", "newInstance: "+newInstance);
        } catch (Exception e) {
            Log.i("wubingzhao", "Exception: "+e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void onBtnClicked2(View view) {
    }

    public void onBtnClicked3(View view) {
    }
}