package com.bing.bingdemo.touchevent;

import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bing.bingdemo.R;
import com.bing.core.BaseActivity;
import com.bing.core.router.RouterJump;
import com.bing.core.router.RouterName;

@Route(path = "app/touchevent")
public class TouchEventctivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_eventctivity;
    }

    @Override
    protected void initData() {
        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("wubingzhao", "onClick: ");
                RouterJump.start(RouterName.MineActivity);
            }
        });
    }
}