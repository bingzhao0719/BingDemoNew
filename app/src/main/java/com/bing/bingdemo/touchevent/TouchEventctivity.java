package com.bing.bingdemo.touchevent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bing.bingdemo.BaseActivity;
import com.bing.bingdemo.R;
import com.bing.bingdemo.adil.AidlActivity;

import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.STATUS_BAR_HIDDEN;

public class TouchEventctivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_eventctivity);
        final View view = findViewById(R.id.layout);
        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("wubingzhao", "onClick: ");
                Intent intent = new Intent(TouchEventctivity.this, AidlActivity.class);
                startActivity(intent);
            }
        });
    }
}