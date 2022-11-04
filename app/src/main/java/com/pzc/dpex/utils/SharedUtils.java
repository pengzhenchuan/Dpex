package com.pzc.dpex.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author pzc
 * shared 轻量级数据存储
 * fileName 文件名
 * key,data key,unData 键值对
 * isSave 不存则读
 */
public class SharedUtils {
    public static String shared(Context context,String fileName,String key,String data,boolean isSave){
        SharedPreferences preferences=context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        if (isSave){
            preferences.edit().putString(key, data).apply();
            return "save success";
        }else {
            return preferences.getString(key,data);
        }
    }
}
