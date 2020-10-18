package com.bing.bingdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;

import com.bing.bingdemo.R;
import com.noober.background.BackgroundLibrary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class FragmentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment1 == null) {
            fragment1 = new Fragment1();
            transaction.add(R.id.containerLayout, fragment1);
        } else {
            transaction.show(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
        transaction.commit();
    }

    Fragment1 fragment1;
    Fragment2 fragment2;

    Handler handler;
    MessageQueue messageQueue;

    public void onBtnFragment1(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment1 == null) {
            fragment1 = new Fragment1();
            transaction.add(R.id.containerLayout, fragment1);
        } else {
            transaction.show(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
        transaction.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("wubingzhao", "onResume FragmentTestActivity: ");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("wubingzhao", "onActivityResult: "+resultCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onBtnFragment2(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment2 == null) {
            fragment2 = new Fragment2();
            transaction.add(R.id.containerLayout, fragment2);
        } else {
            transaction.show(fragment2);
        }
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        transaction.commit();

    }

    public void onTextClicked(View view) {
    }
}
