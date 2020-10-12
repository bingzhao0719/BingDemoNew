package com.bing.bingdemo.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean dispatch = false;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("wubingzhao", "MyView dispatchTouchEvent ACTION_DOWN: ");
                dispatch = true;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("wubingzhao", "MyView dispatchTouchEvent ACTION_MOVE: ");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("wubingzhao", "MyView dispatchTouchEvent ACTION_UP: ");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("wubingzhao", "MyView dispatchTouchEvent ACTION_CANCEL: ");
                break;
        }
//        if(dispatch){
//            return true;
//        }
        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("wubingzhao", "MyView onTouchEvent ACTION_DOWN: ");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("wubingzhao", "MyView onTouchEvent ACTION_MOVE: ");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("wubingzhao", "MyView onTouchEvent ACTION_UP: ");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("wubingzhao", "MyView onTouchEvent ACTION_CANCEL: ");
                break;
        }
        return super.onTouchEvent(event);
    }
}
