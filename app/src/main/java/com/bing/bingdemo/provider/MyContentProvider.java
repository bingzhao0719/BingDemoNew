package com.bing.bingdemo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyContentProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        Log.i("wubingzhao", "MyContentProvider onCreate: ");
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.i("wubingzhao", "MyContentProvider query: "+Thread.currentThread());
        SystemClock.sleep(2000);
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Log.i("wubingzhao", "MyContentProvider getType: ");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.i("wubingzhao", "MyContentProvider insert: ");
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.i("wubingzhao", "MyContentProvider delete: ");
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.i("wubingzhao", "MyContentProvider update: ");
        return 0;
    }
}
