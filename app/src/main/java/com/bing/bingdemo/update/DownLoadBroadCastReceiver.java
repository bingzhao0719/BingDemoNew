package com.bing.bingdemo.update;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.File;

public class DownLoadBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
        String action = intent.getAction();
        Log.i("wubingzhao", "onReceive id: "+id+" action:"+action);
        if("android.intent.action.DOWNLOAD_COMPLETE".equals(action)){
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            installApk(context,new File(externalFilesDir,"update.apk"));

        }else if("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(action)){
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            installApk(context,new File(externalFilesDir,"update.apk"));

        }
    }
    private void installApk(final Context context, final File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // 由于没有在Activity环境下启动Activity,设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(Build.VERSION.SDK_INT>=24) { //判读版本是否在7.0以上
            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
            Uri apkUri =
                    FileProvider.getUriForFile(context, context.getPackageName()+".provider", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        }else{
            intent.setDataAndType(Uri.fromFile(file),
                    "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }
}
