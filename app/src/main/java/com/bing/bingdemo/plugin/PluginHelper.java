package com.bing.bingdemo.plugin;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;

public class PluginHelper {
    public static void loadPluginApk(Context context,ClassLoader classLoader) {
        File file = Environment.getExternalStorageDirectory().getAbsoluteFile();
        Log.i("wubingzhao", "onBtnClicked1: " + file.getAbsolutePath());
        File fileApk = new File(file, "order.apk");
        Log.i("wubingzhao", "onBtnClicked1 fileApk.exists(): " + fileApk.exists());
        String dexopt = context.getDir("dexopt", 0).getAbsolutePath();
        DexClassLoader dexClassLoader = new DexClassLoader(fileApk.getAbsolutePath(),dexopt,null,classLoader);
        try {
//            Class<?> aClass = dexClassLoader.loadClass("com.bing.order.Test");
//            Log.i("wubingzhao", "loadPluginApk aClass: " + aClass);
            Field pathListField = BaseDexClassLoader.class.getDeclaredField("pathList");
            pathListField.setAccessible(true);
            Object pathList = pathListField.get(dexClassLoader);
            Field dexElementField = pathList.getClass().getDeclaredField("dexElements");
            dexElementField.setAccessible(true);
            Object[] dexElements = (Object[])dexElementField.get(pathList);

            Field baseDexpathList1 = BaseDexClassLoader.class.getDeclaredField("pathList");
            baseDexpathList1.setAccessible(true);
            Object pathlist1 = baseDexpathList1.get(classLoader);
            Field dexElementsFiled1 = pathlist1.getClass().getDeclaredField("dexElements");
            dexElementsFiled1.setAccessible(true);
            Object[] dexElements1 = (Object[]) dexElementsFiled1.get(pathlist1);

            Object[] finalArray = (Object[]) Array.newInstance(dexElements.getClass().getComponentType(),
                                                               dexElements.length + dexElements1.length);
            System.arraycopy(dexElements,0,finalArray,0,dexElements.length);
            System.arraycopy(dexElements1,0,finalArray,dexElements.length,dexElements1.length);

            dexElementsFiled1.set(pathlist1,finalArray);
            Log.i("wubingzhao", "插件加载完成=====");
        } catch (Exception e) {
            Log.i("wubingzhao", "loadPluginApk Exception: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
