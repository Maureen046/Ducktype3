package com.example.truel.ducktype3;


import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.truel.ducktype3.Helper.General;


public class MainMenuActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int tapSound, quackSound, shorttapsound;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_main_menu);


        Intent svc = new Intent(this, BackgroundMusicService.class);
        startService(svc);


        ImageButton button = (ImageButton) findViewById(R.id.main_play_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go2level_screen();
                playSound(view);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()

                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
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
        shorttapsound = soundPool.load(this, R.raw.short_tap_sound, 1);
    }

    public void playSound(View view) {
        switch (view.getId()) {
            case R.id.main_play_button:
                soundPool.play(tapSound, 1, 1, 0, 0, 1);
                break;

            case R.id.main_bg_pic:

                soundPool.play(quackSound, 1, 1, 0, 0, 1);
                break;

            //case R.id.
        }
    }

    protected void removeTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void go2level_screen() {
        General.add(MainMenuActivity.this, new LevelScreenFragment(), LevelScreenFragment.TAG);

    }


//    @Override
//    public void onPause() {
//        super.onPause();
//        BackgroundMusicService musicService = new BackgroundMusicService();
//        musicService.Pause();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        BackgroundMusicService musicService = new BackgroundMusicService();
//        musicService.Pause();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        BackgroundMusicService musicService = new BackgroundMusicService();
//        musicService.Resume();
//    }

    @Override
    public void onPause() {
        super.onPause();
        Intent mPause = new Intent(this, BackgroundMusicService.class);
        stopService(mPause);
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent mResume = new Intent(this, BackgroundMusicService.class);
        startService(mResume);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

}











