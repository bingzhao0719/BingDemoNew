package com.bing.core.router;

import com.alibaba.android.arouter.launcher.ARouter;

public class RouterJump {
    public static void start(String routerName){
        ARouter.getInstance().build(routerName).withString("test","哈哈").navigation();
    }
}
