package com.example.camerashooter;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundButton {


    private final SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    private Context context;


     public SoundButton(Context context){
         this.context = context;

     }

     public void playSound(){
//         int soundId = soundPool.load(context, R.raw.ringtone, 1);
//         soundPool.play(soundId, 1, 1, 0, 0, 1);

     }
}
