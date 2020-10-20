package com.bing.bingdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;

import com.bing.bingdemo.R;
import com.noober.background.BackgroundLibrary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class FragmentTestActivity extends AppCompatActivity {

    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        viewPager = findViewById(R.id.viewPager);
        final List<Fragment> fragments = new ArrayList<>(2);
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 2;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments.get(position);
            }
        });
    }

    public void onBtnFragment1(View view) {

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

    }

    public void onTextClicked(View view) {
    }
}
