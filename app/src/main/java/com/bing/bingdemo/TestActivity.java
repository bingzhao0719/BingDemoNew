package com.bing.bingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bing.bingdemo.customview.MyViewActivity;

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
        Log.i("wubingzhao", "onCreate: ");
    }

    public void onBtnClicked1(View view) {
//        IWork object = new Work();
//        MyInvocationHandler handler = new MyInvocationHandler(object);
//        Class<?>[] interfaces = object.getClass().getInterfaces();
//        Log.i("wubingzhao", "onBtnClicked1: "+interfaces.length);
//        IWork proxyInstance = (IWork) Proxy.newProxyInstance(object.getClass().getClassLoader(),
//                                                             interfaces, handler);
//        int work = proxyInstance.work();
//        Log.i("wubingzhao", "onBtnClicked1 work: "+work);
        Intent intent = new Intent(this, MyViewActivity.class);
        startActivityForResult(intent,1);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("wubingzhao", "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("wubingzhao", "onRestart: ");
    }

    @Override
    protected void onResume() {
        SystemClock.sleep(1500);
        super.onResume();
        Log.i("wubingzhao", "onResume: ");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("wubingzhao", "onNewIntent: ");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("wubingzhao", "MyViewActivity onActivityResult: ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("wubingzhao", "MyViewActivity onSaveInstanceState: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("wubingzhao", "MyViewActivity onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("wubingzhao", "MyViewActivity onStop: ");
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