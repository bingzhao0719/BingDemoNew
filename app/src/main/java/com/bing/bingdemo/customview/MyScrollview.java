package com.bing.bingdemo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyScrollview extends FrameLayout {

    int mTouchSlop;

    public MyScrollview(@NonNull Context context) {
        this(context,null);
    }

    public MyScrollview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = configuration.getScaledTouchSlop();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(getChildCount() > 0){
            View childView = getChildAt(0);
            Log.i("wubingzhao", "onMeasure: "+getMeasuredHeight());
            Log.i("wubingzhao", "onMeasure childView: "+childView.getMeasuredHeight());
//            childView.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,0,lp.width);
        final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(parentHeightMeasureSpec),MeasureSpec.UNSPECIFIED);
        child.measure(childWidthMeasureSpec,childHeightMeasureSpec);
    }

    int lastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastY = (int) event.getY();
                Log.e("wubingzhao", "onTouchEvent ACTION_DOWN: ");
                return true;
            case MotionEvent.ACTION_MOVE:
                int y = (int) event.getY();
                int scrollRange = getScrollRange();
                int deltaY = y - lastY;
                if(deltaY > 0 ){

                }
                Log.i("wubingzhao", "onTouchEvent ACTION_MOVE: "+scrollRange);
                if(Math.abs(y - lastY) > mTouchSlop && scrollRange > 0){
                    scrollBy(0,Math.min(lastY - y,scrollRange));
                }
                lastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }
    private int getScrollRange() {
        int scrollRange = 0;
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            scrollRange = Math.max(0,child.getHeight() - (getHeight()) - getScrollY());
        }
        return scrollRange;
    }
}
