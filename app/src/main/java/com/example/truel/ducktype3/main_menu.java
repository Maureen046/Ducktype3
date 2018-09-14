package com.example.truel.ducktype3;


import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;


public class main_menu extends AppCompatActivity {
    private SoundPool soundPool;
    private int tapSound, quackSound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_main_menu);


        Intent svc = new Intent(this, bgmusic_service.class);
        startService(svc);


        ImageButton button = (ImageButton) findViewById(R.id.main_play_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go2level_screen();
                playSound(view);
            }
        });

        ImageButton gearbutton = findViewById(R.id.settingsBTN);
        gearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go2settings();
                playSound(view);
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

        tapSound = soundPool.load(this, R.raw.tap_sound, 1);
        quackSound = soundPool.load(this, R.raw.quack, 1);
    }

    public void playSound(View view) {
        switch (view.getId()) {
            case R.id.main_play_button:
                soundPool.play(tapSound, 1, 1, 0, 0, 1);
                break;

            case R.id.settingsBTN:
                soundPool.play(tapSound, 1, 1, 0, 0, 1);
                break;
            case R.id.main_bg_pic:

                soundPool.play(quackSound, 1, 1, 0, 0, 1);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }


    protected void removeTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void go2level_screen() {
        Intent i = new Intent(this, level_screen.class);
        startActivity(i);
    }

    public void go2settings() {
        Intent settings = new Intent(this, settings.class);
        startActivity(settings);
    }
}











