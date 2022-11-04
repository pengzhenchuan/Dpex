package com.pzc.dpex.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.pzc.dpex.R;
import com.pzc.dpex.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        findViewById(R.id.button_start).setOnClickListener(new View.OnClickListener() {
            private long mLastClickTime = 0;
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                startActivity(new Intent(MainActivity.this, ARActivity.class));
            }
        });
    }
}