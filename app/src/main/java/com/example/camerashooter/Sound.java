package com.example.camerashooter;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Sound {

    private SoundPool soundPool;
    private Context context;
    private int tag;
    private int soundId;

     public Sound(Context context, int tag){
         this.context = context;
         this.tag = tag;

         soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
     }

     public void playSound(){

       switch (tag){
           case R.raw.button_click_sound:
               soundId = soundPool.load(this.context, R.raw.button_click_sound, 1);
               break;

           case R.raw.shot_sound:
               soundId = soundPool.load(this.context, R.raw.shot_sound, 1);
               break;
       }

     }
}
