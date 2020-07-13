package com.bing.bingdemo.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bing.bingdemo.R;


public class SqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
    }

    public void onBtnInsert(View view) {
        SqliteBaseHelper helper = new SqliteBaseHelper(this,"test_db",null,1);
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CrimeDbSchema.CrimeTable.Cols.UUID,"1");
        values.put(CrimeDbSchema.CrimeTable.Cols.TITLE,"title1");
        values.put(CrimeDbSchema.CrimeTable.Cols.DATE,"今天");
        values.put(CrimeDbSchema.CrimeTable.Cols.SOLVED,"solved1");
        long id = database.insert("crimes", null, values);
        Log.i("wubingzhao", "onBtnInsert id: "+id);

    }

    public void onBtnQuery(View view) {
        SqliteBaseHelper helper = new SqliteBaseHelper(this,"test_db",null,1);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("crimes", new String[]{"title"}, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String title = cursor.getString(cursor.getColumnIndex("title"));
            Log.i("wubingzhao", "onBtnQuery title: "+title);
            cursor.moveToNext();
        }
        cursor.close();
    }
}
