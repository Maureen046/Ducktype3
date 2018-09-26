package com.example.truel.ducktype3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class levelFailed extends AppCompatActivity {
    private MediaPlayer failplay, failsound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_failed);

        Intent svc = new Intent (this, bgmusic_service.class);
        stopService(svc);

       //Intent fire =  new Intent(this, bgmusic_fail.class);
       //startService(fire);

        failplay = MediaPlayer.create(this, R.raw.fire_background);
        failplay.setLooping(true);
        failplay.setVolume(100, 100);
        failplay.start();

        failsound = MediaPlayer.create(this, R.raw.fail_sound);
        failsound.setLooping(false);
        failsound.setVolume(100,100);
        failsound.start();

        LinearLayout linearLayout =  (LinearLayout) findViewById(R.id.Failed_Layout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move2level(v);
            }
        });

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            AudioAttributes audioAttributes = new AudioAttributes.Builder()
//                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .build();
//
//            soundPool = new SoundPool.Builder()
//                    .setMaxStreams(1)
//                    .setAudioAttributes(audioAttributes)
//                    .build();
//        } else {
//            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
//        }
//
//        failSound = soundPool.load(this, R.raw.fail_sound, 1);
    }


    protected void removeTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void move2level(View view) {
        Intent a = new Intent(this, level_screen.class);
        startActivity(a);
        finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        Intent firestop = new Intent(this, bgmusic_service.class);
        startService(firestop);

        failplay.stop();
        failplay.release();

        failsound.stop();
        failsound.release();
    }


}
