package com.bing.bingdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onBtnClicked1(View view) {
        IWork object = new Work();
        MyInvocationHandler handler = new MyInvocationHandler(object);
        Class<?>[] interfaces = object.getClass().getInterfaces();
        Log.i("wubingzhao", "onBtnClicked1: "+interfaces.length);
        IWork proxyInstance = (IWork) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                                                             interfaces, handler);
        int work = proxyInstance.work();
        Log.i("wubingzhao", "onBtnClicked1 work: "+work);
    }

    public void onBtnClicked2(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("https://cmall.ibaboss.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        BService bService = retrofit.create(BService.class);
        Call<BResponse<User>> call = bService.getCall();
        call.enqueue(new Callback<BResponse<User>>() {
            @Override
            public void onResponse(Call<BResponse<User>> call, Response<BResponse<User>> response) {
                BResponse<User> bResponse = response.body();
                Log.i("wubingzhao", "onResponse: "+bResponse.result);
            }

            @Override
            public void onFailure(Call<BResponse<User>> call, Throwable t) {
                Log.i("wubingzhao", "onFailure: "+t.getLocalizedMessage());
            }
        });

    }
}
/**动态代理**/
class MyInvocationHandler implements InvocationHandler{

    Object realObject;

    MyInvocationHandler(Object realObject){
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        Log.i("wubingzhao", "invoke proxy: "+proxy);
        Object invoke = method.invoke(realObject, args);
        Log.i("wubingzhao", "invoke invoke: "+invoke);
        return invoke;
    }
}

class Work implements IWork{

    @Override
    public int work() {
        Log.i("wubingzhao", "我正在上班 ");
        return 100;
    }
}
interface IWork{
    int work();
}
/**动态代理**/

/**retrofit**/
interface BService{
//    @Headers({
//            "tenantid:0174965149d8001b8a74827074964c1d"
//    })
    @GET("api/cms/m/viewPage/findByCode?code=home")
    Call<BResponse<User>> getCall();
}
class BResponse<T>{
    public T result;
    public String errcode;
    public String errmsg;

    @Override
    public String toString() {
        return "BResponse{" +
                "result='" + result + '\'' +
                ", errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}

class User{
    public String id;
    public String tenantId;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}

/**retrofit**/