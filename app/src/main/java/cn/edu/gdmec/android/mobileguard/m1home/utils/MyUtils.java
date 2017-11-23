package cn.edu.gdmec.android.mobileguard.m1home.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Created by killer on 2017/9/19.
 */

public class MyUtils {
    public static String getVersion(Context context){
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo =  packageManager.getPackageInfo(context.getPackageName(),0);
            return  packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace( );
            return "";
        }


    }
    /**
     * 安装新版本
     */
    public static void installApk(Activity activity, String apkFile){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setDataAndType(Uri.fromFile(
                new File(Environment.getExternalStoragePublicDirectory("/download/").getPath()+"/"+apkFile)),"application/vnd.android.package-archive");
        activity.startActivityForResult(intent,0);

    }
    /*//普通安装
    public static void installApk(Context context,String apkPath) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //版本在7.0以上是不能直接通过uri访问的
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            File file = (new File(apkPath));
            // 由于没有在Activity环境下启动Activity,设置下面的标签
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
            Uri apkUri = FileProvider.getUriForFile(context, "com.example.chenfengyao.installapkdemo", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            intent.setDataAndType(Uri.fromFile(
                    new File(Environment.getExternalStoragePublicDirectory("/download/").getPath()+"/"+apkPath)),"application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(new File(apkPath)), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }*/
}
