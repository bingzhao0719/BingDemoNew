package com.bing.bingdemo.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcel;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bing.bingdemo.MainActivity;
import com.bing.bingdemo.R;
import com.bing.bingdemo.shape.ShapeDrawable;
import com.bing.bingdemo.sqlite.SqliteActivity;
import com.noober.background.BackgroundLibrary;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;

public class FragmentTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), new LayoutInflater.Factory2() {
//            @Override
//            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//                Log.e("wubingzhao", "parent:" + parent + ",name = " + name);
//                int n = attrs.getAttributeCount();
//                for (int i = 0; i < n; i++) {
//                    Log.e("wubingzhao", attrs.getAttributeName(i) + " , " + attrs.getAttributeValue(i));
//                }
//                if("Button".equals(name)){
//                    TextView textView = new TextView(context,attrs);
//                    return textView;
//                }
//                return null;
//            }
//
//            @Override
//            public View onCreateView(String name, Context context, AttributeSet attrs) {
//                return null;
//            }
//        });
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
//        MessageQueue messageQueue = Looper.myLooper().getQueue();
//        messageQueue.addIdleHandler(new MessageQueue.IdleHandler() {
//            @Override
//            public boolean queueIdle() {
//                Log.i("wubingzhao", "queueIdle: ");
//                return true;
//            }
//        });
    }

    Fragment1 fragment1;
    Fragment2 fragment2;

    Handler handler;
    MessageQueue messageQueue;

    public void onBtnFragment1(View view) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        if (fragment1 == null) {
//            fragment1 = new Fragment1();
//            transaction.add(R.id.containerLayout, fragment1);
//        } else {
//            transaction.show(fragment1);
//        }
//        if (fragment2 != null) {
//            transaction.hide(fragment2);
//        }
//        transaction.commit();

//        startActivity(new Intent(this,FragmentTestActivity.class));

//        MessageQueue messageQueue = Looper.myLooper().getQueue();
//        messageQueue.addIdleHandler(new MessageQueue.IdleHandler() {
//            @Override
//            public boolean queueIdle() {
//                Log.i("wubingzhao", "queueIdle: ");
//                SystemClock.sleep(1000);
//                return true;
//            }
//        });
//        boolean idle = messageQueue.isIdle();
//        Log.i("wubingzhao", "onBtnFragment1 idle: "+idle);
//        handler.sendEmptyMessage(1);
//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"classes.dex");
//        Log.i("wubingzhao", "onBtnFragment1 exists: "+file.exists());
//        String dexPath = file.getAbsolutePath();
//        File optimizedDirectory = getDir("dex3",Context.MODE_PRIVATE);
////        File optimizedDirectory = getExternalCacheDir();
//        String librarySearchPath = null;
//        ClassLoader parent = getClassLoader();
//        try {
//            DexFile dexFile = DexFile.loadDex(dexPath, File.createTempFile("opt",".dex",getApplicationContext().getCacheDir()).getPath(), 0);
//            for (Enumeration<String> classNames = dexFile.entries(); classNames.hasMoreElements(); ) {
//                String className = classNames.nextElement();
//                Log.d("wubingzhao", "Analyzing dex content, fonud class: " + className);
//            }
//            DexClassLoader dexClassLoader = new DexClassLoader(dexPath,optimizedDirectory.getAbsolutePath(),null,parent);
//            Class<?> aClass = dexClassLoader.loadClass("com.ibalife.ibaboss.ui.MainActivity");
//            Log.i("wubingzhao", "onBtnFragment1 dexClassLoader: "+dexClassLoader);
//            Log.i("wubingzhao", "onBtnFragment1 aClass: "+aClass);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.i("wubingzhao", "onBtnFragment1 Exception: "+e.getLocalizedMessage());
//        }
//        Log.i("wubingzhao", "handleMessage sendEmptyMessageDelayed: ");
//        myHandler.sendEmptyMessageDelayed(1,200);

//        printThread();

        Intent intent = new Intent(this, SqliteActivity.class);
        startActivityForResult(intent,65536);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("wubingzhao", "onResume: ");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("wubingzhao", "onActivityResult: "+resultCode);
    }

    private void printThread() {
        Map<Thread, StackTraceElement[]> stacks = Thread.getAllStackTraces();
        Set<Thread> set = stacks.keySet();
        for (Thread key : set) {
            StackTraceElement[] stackTraceElements = stacks.get(key);
            Log.d("wubingzhao", "thread: " + key.getName() + " state:"+key.getState());
//            for (StackTraceElement st : stackTraceElements) {
//                Log.d("wubingzhao", "StackTraceElement: " + st.toString());
//            }
//            Log.d("wubingzhao", "---- print thread: " + key.getName() + " end ----");
        }
    }
    private static MyHandler myHandler = new MyHandler();
    public static class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i("wubingzhao", "handleMessage msg.what: "+msg.what);
            Message message = Message.obtain();
            myHandler.sendEmptyMessageDelayed(1,200);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeCallbacksAndMessages(null);
    }

    public void onBtnFragment2(View view) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        if (fragment2 == null) {
//            fragment2 = new Fragment2();
//            transaction.add(R.id.containerLayout, fragment2);
//        } else {
//            transaction.show(fragment2);
//        }
//        if (fragment1 != null) {
//            transaction.hide(fragment1);
//        }
//        transaction.commit();
//        try {
//            File directory = Environment.getExternalStorageDirectory();
//            File file = new File(directory,"test");
//            ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream(file));
//            Test test = (Test) objectOutputStream.readObject();
//            Log.i("wubingzhao", "onTextClicked test: "+test);
//            objectOutputStream.close();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();

                handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        Log.i("wubingzhao", "queueIdle msg: "+msg.what);
                    }
                };

                messageQueue = Looper.myLooper().getQueue();
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() {
                    @Override
                    public boolean queueIdle() {
                        Log.i("wubingzhao", "queueIdle currentThread: "+Thread.currentThread());
                        return true;
                    }
                });

                Looper.loop();
            }
        }).start();

    }

    public void onTextClicked(View view) {
//        ViewGroup viewById = findViewById(R.id.containerLayout);
//        TextView textView = new TextView(this);
//        textView.setText("hahah");
//        textView.setBackgroundColor(Color.RED);
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT);
//        textView.setLayoutParams(params);
//        viewById.addView(textView,params);
//        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
//        Log.i("wubingzhao", "onTextClicked layoutParams: "+layoutParams);
        Test test = new Test();
        test.setAge(10);
        test.setName("1");
//        Intent intent = new Intent(this,FragmentTestActivity.class);
//        intent.putExtra("test",test);
//        startActivity(intent);
//
//        try {
//            File directory = Environment.getExternalStorageDirectory();
//            File file = new File(directory,"test");
//            if(!file.exists()){
//                file.createNewFile();
//            }
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//            objectOutputStream.writeObject("a");
//            objectOutputStream.close();
//            Log.i("wubingzhao", "onTextClicked 写入成功: ");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            File directory = Environment.getExternalStorageDirectory();
            File file = new File(directory,"test");
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedOutputStream objectOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            Parcel parcel = Parcel.obtain();
            parcel.writeParcelable(test,0);
            objectOutputStream.write(parcel.marshall());
            objectOutputStream.close();
            Log.i("wubingzhao", "onTextClicked 写入成功: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
