package com.bing.order;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ibalife.base_service.BaseApp;
import com.ibalife.base_service.OrderFactory;

public class OrderApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        initModuleApp(this);
    }

    @Override
    public void initModuleApp(Application application) {
        OrderFactory.getInstance().setOrder(new OrderService());
    }
}
