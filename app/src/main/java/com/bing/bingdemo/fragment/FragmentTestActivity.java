package com.bing.bingdemo.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bing.bingdemo.R;
import com.bing.bingdemo.shape.ShapeDrawable;

public class FragmentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        TextView textView = findViewById(R.id.tvShape);
        ShapeDrawable drawable = new ShapeDrawable.Builder()
                .setColor(Color.RED)
                .setCornerRadius(10)
                .setStrokeColor(Color.BLUE)
                .setStrokeWidth(4)
                .build();
        textView.setBackground(drawable);
    }

    public void onBtnFragment1(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerLayout,new Fragment1());
        transaction.commit();
    }

    public void onBtnFragment2(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerLayout,new Fragment2());
        transaction.commit();
    }
}
