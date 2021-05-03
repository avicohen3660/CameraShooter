package com.example.camerashooter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

public class CameraActivity extends AppCompatActivity {

   FrameLayout frameLayout;
   Drawable aim;
   CameraManager camera;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        aim = getResources().getDrawable(R.drawable.aim);
        frameLayout = findViewById(R.id.container);

        frameLayout.setForegroundGravity(FrameLayout.TEXT_ALIGNMENT_CENTER);
        frameLayout.setForeground(aim);


    }
}