//================================================================================================================================
//
// Copyright (c) 2015-2022 VisionStar Information Technology (Shanghai) Co., Ltd. All Rights Reserved.
// EasyAR is the registered trademark or trademark of VisionStar Information Technology (Shanghai) Co., Ltd in China
// and other countries for the augmented reality technology developed by VisionStar Information Technology (Shanghai) Co., Ltd.
//
//================================================================================================================================

package com.pzc.dpex.ui.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.pzc.dpex.R;
import com.pzc.dpex.ar.GLView;

import java.util.HashMap;

import cn.easyar.CameraDevice;
import cn.easyar.Engine;
import cn.easyar.ImageTracker;

public class ARActivity extends Activity {
    /*
     * Steps to create the key for this sample:
     *  1. login www.easyar.com
     *  2. create app with
     *      Name: HelloAR
     *      Package Name: cn.easyar.samples.helloar
     *  3. find the created item in the list and show key
     *  4. set key string bellow
     */
    private static String key="SnQ2rE5nLrBWAZKekEw6kUqz8xa0q1mhzJke13pGAIdOVgaaelsR1zUXU8w+DVfNOgRTtX5ES5ZgWEfZLVgEhntQF75qTCyRLQ9U2S1ZDJZqWxaQfBdfrnQXB4BhUQmQRlEW1zVuONktQwSHZlQLgXwXX64tVgqYYkALnHtMR6gjFxWZbkEDmn1YFtc1bkeCZlsBmnhGR9ktWASWLWhJ12JaAYBjUBbXNW5HhmpbFpAhfAiUaFAxh25WDpxhUkfZLUYAm3xQS7ZjWhCRXVAGmmhbDIFmWgvXIxcWkGFGANtdUAaafVEMm2gXSdd8UAuGahsql2VQBoFbRwSWZFwLki0ZR4ZqWxaQIWYQh2lUBpBbRwSWZFwLki0ZR4ZqWxaQIWYVlH1GAKZ/VBGcblkolH8XSdd8UAuGahsomntcCptbRwSWZFwLki0ZR4ZqWxaQIXEAm3xQNoVuQQyUY3gEhS0ZR4ZqWxaQIXYksVtHBJZkXAuSLWhJ12pNFZx9UDGcYlA2gW5YFdc1WxCZYxlHnHx5CpZuWUfPaVQJhmpISY4tVxCba1kAvGtGR89UFwaaYhsVj2wbAYVqTUeoIxcTlH1cBJt7RkfPVBcGmmJYEJtmQRzXUhlHhWNUEZNgRwiGLQ8+125bAYdgXAHXUhlHmGBREJlqRkfPVBcWkGFGANtGWASSamEXlGxeDJtoF0nXfFALhmobJplgQAGnalYKkmFcEZxgW0fZLUYAm3xQS6dqVgqHa1wLki0ZR4ZqWxaQIXoHn2pWEaF9VAaeZlsC1yMXFpBhRgDbXEAXk25WAKF9VAaeZlsC1yMXFpBhRgDbXEUEh3xQNoVuQQyUY3gEhS0ZR4ZqWxaQIXgKgWZaC6F9VAaeZlsC1yMXFpBhRgDbS1ALhmpmFZR7XASZQlQV1yMXFpBhRgDbTHQhoX1UBp5mWwLXUhlHkHdFDIdqYQyYamYRlGJFR89hQAmZIxcMhkNaBpRjF1+TblkWkHIZHtdtQAuRY1AskXwXX64tFzjZLUMEh2ZUC4F8F1+uLVYKmGJAC5x7TEeoIxcVmW5BA5p9WBbXNW5HnGBGR6gjFwiaa0AJkHwXX64tRgCbfFBLvGJUApBbRwSWZFwLki0ZR4ZqWxaQIXYJmnpRN5BsWgKbZkEMmmEXSdd8UAuGahs3kGxaF5FmWwLXIxcWkGFGANtAVw+QbEExh25WDpxhUkfZLUYAm3xQS6Z6RwOUbFAxh25WDpxhUkfZLUYAm3xQS6Z/VBeGamYVlHtcBJlCVBXXIxcWkGFGANtCWhGcYFsxh25WDpxhUkfZLUYAm3xQS7FqWxaQXEUEgWZUCbhuRUfZLUYAm3xQS7ZOcTGHblYOnGFSR6gjFwCNf1wXkFtcCJBcQQSYfxdfm3pZCdktXBa5YFYEmS0PA5RjRgCIUkhQ/v2lCh7NOgPnSKVJRrZs6BW+FbeGFi3jwMdVKkGAOhsypttfsDXoNa52B9OOf7gyhibNh9OIoqkTZag3E8z6g1olFvfMpMwQ2+Fqs40WlmMeKVMmAVcu8w2zkNl+6ln+lkS+lUm8loMp7sSx7haaQtBKFi29e3hAjFfIsCmH8S3rYgBZwRJY39e5ISjPP8hZfc+YmfPbzzvZJI53OiYlZv9RCLvbc15VBNm17fL/EGdvTm4+SNYyWillkoQh4z11d9cxq+Be6qlAf9nQHzw1F1yYkHPWoyCCmxdncmO395bXhwmpjdLJYO2TWSk1SlftHQEkXbblwWZli8wPNWX1";
    private GLView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        if (!Engine.initialize(this, key)) {
            Log.e("HelloAR", "Initialization Failed.");
            Toast.makeText(ARActivity.this, Engine.errorMessage(), Toast.LENGTH_LONG).show();
            return;
        }
        if (!CameraDevice.isAvailable()) {
            Toast.makeText(ARActivity.this, "CameraDevice not available.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!ImageTracker.isAvailable()) {
            Toast.makeText(ARActivity.this, "ImageTracker not available.", Toast.LENGTH_LONG).show();
            return;
        }

        glView = new GLView(this);

        requestCameraPermission(new PermissionCallback() {
            @Override
            public void onSuccess() {
                ((ViewGroup) findViewById(R.id.preview)).addView(glView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }

            @Override
            public void onFailure() {
            }
        });
    }

    private interface PermissionCallback {
        void onSuccess();

        void onFailure();
    }

    private HashMap<Integer, PermissionCallback> permissionCallbacks = new HashMap<Integer, PermissionCallback>();
    private int permissionRequestCodeSerial = 0;

    @TargetApi(23)
    private void requestCameraPermission(PermissionCallback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                int requestCode = permissionRequestCodeSerial;
                permissionRequestCodeSerial += 1;
                permissionCallbacks.put(requestCode, callback);
                requestPermissions(new String[]{Manifest.permission.CAMERA}, requestCode);
            } else {
                callback.onSuccess();
            }
        } else {
            callback.onSuccess();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (permissionCallbacks.containsKey(requestCode)) {
            PermissionCallback callback = permissionCallbacks.get(requestCode);
            permissionCallbacks.remove(requestCode);
            boolean executed = false;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    executed = true;
                    callback.onFailure();
                }
            }
            if (!executed) {
                callback.onSuccess();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (glView != null) {
            glView.onResume();
        }
    }

    @Override
    protected void onPause() {
        if (glView != null) {
            glView.onPause();
        }
        super.onPause();
    }
}
