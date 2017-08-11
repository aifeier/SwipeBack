package com.ai.cwf.swipeback.swipeback;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

/**
 * Created at 陈 on 2017/8/11.
 * 手机信息
 *
 * @author chenwanfeng
 * @email 237142681@qq.com
 */

public class PhoneInfo {
    /**
     * 手机屏幕宽度
     */
    private int phoneWidth = 0;
    /**
     * 手机屏幕高度
     */
    private int phoneHeigh = 0;
    /**
     * 手机SDK版本号
     */
    private int phoneSDK = 0;

    private volatile static PhoneInfo instance;

    public static PhoneInfo getInstance(AppCompatActivity appCompatActivity) {
        if (instance == null) {
            synchronized (PhoneInfo.class) {
                if (instance == null) {
                    instance = new PhoneInfo(appCompatActivity);
                }
            }
        }
        return instance;
    }

    /**
     * 初始化手机信息
     *
     * @param activity
     */
    private PhoneInfo(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        // 获取屏幕信息
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        phoneWidth = dm.widthPixels;
        phoneHeigh = dm.heightPixels;
        phoneSDK = android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机屏幕宽度
     *
     * @return
     */
    public int getPhoneWidth() {
        return phoneWidth;
    }

    /**
     * 设置手机屏幕宽度
     *
     * @param phoneWidth
     */
    public void setPhoneWidth(int phoneWidth) {
        this.phoneWidth = phoneWidth;
    }

    /**
     * 获取手机屏幕高度
     *
     * @return
     */
    public int getPhoneHeigh() {
        return phoneHeigh;
    }

    /**
     * 设置手机屏幕高度
     *
     * @param phoneHeigh
     */
    public void setPhoneHeigh(int phoneHeigh) {
        this.phoneHeigh = phoneHeigh;
    }

    /**
     * 获取手机SDK版本号
     *
     * @return
     */
    public int getPhoneSDK() {
        return phoneSDK;
    }

    /**
     * 设置手机SDK版本号
     *
     * @param phoneSDK
     */
    public void setPhoneSDK(int phoneSDK) {
        this.phoneSDK = phoneSDK;
    }
}
