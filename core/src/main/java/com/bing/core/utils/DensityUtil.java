package com.bing.core.utils;

import android.content.res.Resources;

public class DensityUtil {

    public static int dp2px(float dpValue) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5);
    }

    public static int px2dp(float pxValue) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / density + 0.5);
    }
}
