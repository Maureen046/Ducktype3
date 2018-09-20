package com.example.truel.ducktype3;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;


public class level_screen extends AppCompatActivity {
    private SoundPool soundPool;
    private int shorttapSound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_screen);


        ImageButton lvl1 = (ImageButton) findViewById(R.id.btnlvl1);
        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go2level1();
                playSound(v);
            }
        });

        ImageButton lvl2 = (ImageButton) findViewById(R.id.btnlvl2);
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                boolean unlocked = pref.getBoolean("unlock_lvl2", false);
                if(unlocked)
                {
                    go2level2();
                    playSound(v);
                }
                else{
                    playSound(v);
                    Toast.makeText(getApplicationContext(), "Level is locked. Finish level 1 first", Toast.LENGTH_SHORT).show();}


            }
        });

        ImageButton lvl3 = (ImageButton) findViewById(R.id.btnlvl3);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                boolean unlocked = pref.getBoolean("unlock_lvl3", false);
                if(unlocked)
                {

                    go2level3();
                    playSound(v);
                }
                else{
                    playSound(v);
                    Toast.makeText(getApplicationContext(), "Level is locked. Finish level 2 first", Toast.LENGTH_SHORT).show();}


            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }

        shorttapSound = soundPool.load(this, R.raw.short_tap_sound, 1);
    }

    protected void removeTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void playSound(View view) {
        soundPool.play(shorttapSound, 1, 1, 0, 0, 1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

    public void go2level1() {

        Intent a = new Intent(this, level_1.class);
        startActivity(a);
    }

    public void go2level2() {
        Intent a = new Intent(this, level_2.class);
        startActivity(a);
    }

    public void go2level3() {
        Intent a = new Intent(this, level_3.class);
        startActivity(a);
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, main_menu.class));
    }
}
