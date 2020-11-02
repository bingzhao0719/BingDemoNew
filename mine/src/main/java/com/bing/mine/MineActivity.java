package com.bing.mine;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bing.core.BaseActivity;
import com.bing.core.router.RouterJump;
import com.bing.core.router.RouterName;

@Route(path = RouterName.MineActivity)
public class MineActivity extends BaseActivity {

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
    }
}