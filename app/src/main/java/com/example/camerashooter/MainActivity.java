package com.example.camerashooter;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Sound sound;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sound = new Sound(this, R.raw.bcs);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {

        sound.playSound();

        switch (v.getId()){

            case R.id.join_game:
                startActivity(new Intent(getApplicationContext(), ConnectionActivity.class));
                break;
            case R.id.setting:
                //todo make settings
                break;
        }

    }

}
