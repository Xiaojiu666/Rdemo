package com.donglin.maintenance.Utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/12/19 0019.
 */

public class MLog {

    public static final String TAG = "DLmaintenance";
    public static boolean isShow = true;

    public MLog() {

    }

    public static void e(Object object) {
        if (isShow)
            Log.e(TAG, object + "");
    }

    public static void v(Object object) {
        if (isShow)
            Log.e(TAG, object + "");

    }

    public static void d(Object object) {
        if (isShow)
            Log.e(TAG, object + "");
    }

    public static void i(Object object) {
        if (isShow)
            Log.e(TAG, object + "");
    }

    public static void w(Object object) {
        if (isShow)
            Log.e(TAG, object + "");
    }


}
