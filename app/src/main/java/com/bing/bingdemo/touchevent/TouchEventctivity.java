package com.bing.bingdemo.touchevent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bing.bingdemo.R;

import androidx.appcompat.app.AppCompatActivity;

public class TouchEventctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_eventctivity);
        final View view = findViewById(R.id.layout);
        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("wubingzhao", "onClick: ");
            }
        });
    }
}