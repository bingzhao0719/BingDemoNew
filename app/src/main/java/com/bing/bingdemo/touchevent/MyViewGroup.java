package com.bing.bingdemo.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

public class MyViewGroup extends FrameLayout {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean dispatch = false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("wubingzhao", "MyViewGroup dispatchTouchEvent ACTION_DOWN: ");
                dispatch = true;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wubingzhao", "MyViewGroup dispatchTouchEvent ACTION_MOVE: ");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wubingzhao", "MyViewGroup dispatchTouchEvent ACTION_UP: ");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("wubingzhao", "MyViewGroup dispatchTouchEvent ACTION_CANCEL: ");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean dispatch = false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("wubingzhao", "MyViewGroup onInterceptTouchEvent ACTION_DOWN: ");

                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wubingzhao", "MyViewGroup onInterceptTouchEvent ACTION_MOVE: ");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wubingzhao", "MyViewGroup onInterceptTouchEvent ACTION_UP: ");
                dispatch = true;
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("wubingzhao", "MyViewGroup onInterceptTouchEvent ACTION_CANCEL: ");
                break;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("wubingzhao", "MyViewGroup onTouchEvent ACTION_DOWN: ");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wubingzhao", "MyViewGroup onTouchEvent ACTION_MOVE: ");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wubingzhao", "MyViewGroup onTouchEvent ACTION_UP: ");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("wubingzhao", "MyViewGroup onTouchEvent ACTION_CANCEL: ");
                break;
        }
        return super.onTouchEvent(event);
    }
}
