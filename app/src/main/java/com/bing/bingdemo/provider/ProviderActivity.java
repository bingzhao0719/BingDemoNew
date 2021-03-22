package com.bing.bingdemo.provider;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bing.bingdemo.R;

public class ProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
    }

    public void onBtnQuery(View view) {
        Uri uri = Uri.parse("content://com.bing.bingdemo.provider");
        getContentResolver().query(uri,null,null,null,null);
    }
}