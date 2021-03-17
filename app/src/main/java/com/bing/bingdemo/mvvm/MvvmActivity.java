package com.bing.bingdemo.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.bing.bingdemo.R;
import com.bing.bingdemo.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("wubingzhao", "MvvmActivity onCreate: ");
        ActivityMvvmBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        User user = new User();
        user.firstName = "李";
        user.lastName = "寻欢";
        viewDataBinding.setUser(user);
        viewDataBinding.setVisible(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewDataBinding.setVisible(false);
            }
        },1500);
        getLifecycle().addObserver(new MyObserver());

    }
    class MyObserver implements LifecycleObserver{

        @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
        private void onCreate(){
            Log.i("wubingzhao", "MyObserver onCreate: ");
        }
    }
}
