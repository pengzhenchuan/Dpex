package com.pzc.dpex.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/*
 * manager 消息 使用方法：getSupportFragmentManager() [activity] getActivity()[fragment]
 * id frameLayout控件id 使用方法：R.id.frameLayout
 * fragment 碎片类 使用方法：new fragment();
 * */
public class FragmentUtils {

    public static void ReplaceFragment(FragmentManager manager, int id, Fragment fragment) {
        manager.beginTransaction()
                .replace(id, fragment)
                .addToBackStack(null)
                //跟commit()方法的区别是允许状态值丢失
                .commitAllowingStateLoss();
    }
}
