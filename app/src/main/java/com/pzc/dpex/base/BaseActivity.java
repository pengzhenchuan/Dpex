package com.pzc.dpex.base;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pzc.dpex.context.MyApplication;

//页面基类
public abstract class BaseActivity extends AppCompatActivity {

    public void initToolBar(TextView textView, Toolbar toolbar, boolean e, String txt){
        textView.setText(txt);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(e);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        hideBar();
        init();
    }

    private void hideBar() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    protected abstract int initLayout();
    protected abstract void init();
}
