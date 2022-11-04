package com.pzc.dpex.ui.view;

import androidx.viewpager.widget.ViewPager;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyViewPager extends ViewPager {

    private onViewPagerTouchListener mListener = null;

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    // 这里是监听触摸事件
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            // 这里是指当用户按着图片的时候
            case MotionEvent.ACTION_DOWN:
                if (mListener != null) {
                    // 调用onTouch方法，将isTouch（true）传到MainActivity，实现图片停止自动翻转
                    mListener.onTouch(true);
                }
                break;
            // 这里是指当手松开的时候
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if (mListener != null) {
                    // 调用onTouch方法，将isTouch（false）传到MainActivity，实现图片继续翻转
                    mListener.onTouch(false);
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    // 下面是用了接口的回调
    // 设置回调方法
    public void setOnViewPagerTouchListener(onViewPagerTouchListener listener) {
        mListener = listener;
    }

    // 定义接口
    public interface onViewPagerTouchListener {
        // 定义一个onTouch方法
        void onTouch(boolean isTouch);
    }
}