package com.example.truel.ducktype3;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class level_1 extends AppCompatActivity {
    private SoundPool soundPool;
    private int tapSound, shorttapSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_1);

        ImageButton next = findViewById(R.id.imageButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                go2level1quiz(view);
                playSound(view);

            }
        }
        );

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
        shorttapSound = soundPool.load(this, R.raw.short_tap_sound,1);
    }



    protected void removeTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void playSound(View view) {
        switch (view.getId()) {
            case R.id.imageButton:
                shorttapSound = soundPool.play(shorttapSound, 1,1,0,0,1);
        }

    }

    public void go2level1quiz(View view) {
        Intent moveforward = new Intent(this, level_1_quiz.class);
        startActivity(moveforward);
    }
}
