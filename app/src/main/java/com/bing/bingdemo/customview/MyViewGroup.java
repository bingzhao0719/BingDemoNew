package com.bing.bingdemo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MyViewGroup extends LinearLayout {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View child = getChildAt(i);
//            child.layout(l,t,r,b);
//        }
//    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int childCount = getChildCount();
//        int parentW = MeasureSpec.getSize(widthMeasureSpec);
//        int parentH = MeasureSpec.getSize(heightMeasureSpec);
//        Log.i("wubingzhao", "myviewgroup onMeasure parentW: "+parentW);
//        Log.i("wubingzhao", "myviewgroup onMeasure parentH: "+parentH);
//        int finalWidth = parentW;
//        int finalHeight = parentH;
////        for (int i = 0; i < childCount; i++) {
////            View child = getChildAt(i);
////            measureChild(child,widthMeasureSpec,heightMeasureSpec);
////            finalWidth = child.getMeasuredWidth();
////            finalHeight = child.getMeasuredHeight();
////        }
////        setMeasuredDimension(parentW,parentH);
//    }
}
