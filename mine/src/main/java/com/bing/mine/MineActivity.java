package com.bing.mine;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bing.core.BaseActivity;
import com.bing.core.router.RouterJump;
import com.bing.core.router.RouterName;
import com.ibalife.base_service.OrderFactory;

@Route(path = RouterName.MineActivity)
public class MineActivity extends BaseActivity {
    @Autowired(name = "test")
    String test;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine;
    }

    @Override
    protected void initData() {
        findViewById(R.id.tvMine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterJump.start(RouterName.OrderActivity);
            }
        });
        int orderCount = OrderFactory.getInstance().getOrder().getOrderCount();
        Log.i("wubingzhao", "initData orderCount: "+orderCount);
        Log.i("wubingzhao", "initData test: "+test);
    }
}