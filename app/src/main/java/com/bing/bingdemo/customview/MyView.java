package com.bing.bingdemo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentW = MeasureSpec.getSize(widthMeasureSpec);
        int parentH = MeasureSpec.getSize(heightMeasureSpec);
        Log.e("wubingzhao", "myview onMeasure parentW: "+parentW);
        Log.e("wubingzhao", "myview onMeasure parentH: "+parentH);
//        setMeasuredDimension(getDefaultSize(getMinimumWidth(), widthMeasureSpec),
//                getDefaultSize(getMinimumHeight(), heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    public static int getDefaultSize(int size, int measureSpec) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                result = size;
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }
}
