package com.bing.order;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bing.core.BaseActivity;
import com.bing.core.router.RouterName;

@Route(path = RouterName.OrderActivity)
public class OrderActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }
}