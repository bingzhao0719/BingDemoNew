package com.bing.core.router;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
@Interceptor(priority = 8,name = "login")
public class LoginInterceptorImpl implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        Log.i("wubingzhao", "process path: "+path);
        if(path == RouterName.OrderActivity){
            //路由到登录页面
//            RouterJump.start(RouterName.MineActivity);
            return;
        }
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {

    }
}
