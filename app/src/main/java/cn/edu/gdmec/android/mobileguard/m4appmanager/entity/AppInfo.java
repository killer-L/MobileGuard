package cn.edu.gdmec.android.mobileguard.m4appmanager.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by killer on 2017/11/6.
 */

public class AppInfo {
    public String packageName;
    public Drawable icon;
    public String appName;
    public String apkPath;
    public long appSize;
    public boolean isInRoom;
    public boolean isUserApp;
    public boolean isSelected=false;
    /**版本号*/
    public String versionName;
    /**安装时间*/
    public long firstInstallTime;
    /**签名信息*/
    public String signature;
    /**权限信息*/
    public String requestedPermissions;
    public String getAppLocation(boolean isInRoom){
        if (isInRoom){
            return "手机内存";
        }else {
            return "外部存储";
        }
    }
}
