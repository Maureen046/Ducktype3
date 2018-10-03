package com.example.truel.ducktype3.LevelFailedAndClearedActivities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.truel.ducktype3.BackgroundMusicService;
import com.example.truel.ducktype3.MainMenuActivity;
import com.example.truel.ducktype3.R;
import com.example.truel.ducktype3.level_screen;

public class LevelFailedActivity extends AppCompatActivity {
    private MediaPlayer failplay, failsound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_failed);

        Intent svc = new Intent(this, BackgroundMusicService.class);
        stopService(svc);

        //Intent fire =  new Intent(this, BackgroundMusicFail.class);
        //startService(fire);

        failplay = MediaPlayer.create(this, R.raw.fire_background);
        failplay.setLooping(true);
        failplay.setVolume(100, 100);
        failplay.start();

        failsound = MediaPlayer.create(this, R.raw.fail_sound);
        failsound.setLooping(false);
        failsound.setVolume(100, 100);
        failsound.start();

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.Failed_Layout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move2level(v);
            }
        });
    }




    protected void removeTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void move2level(View view) {
        Intent a = new Intent(this, MainMenuActivity.class);
        startActivity(a);
        finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        Intent firestop = new Intent(this, BackgroundMusicService.class);
        startService(firestop);

        failplay.stop();
        failplay.release();

        failsound.stop();
        failsound.release();
    }

    @Override
    public void onStop(){
        super.onStop();
        failplay.release();
        failsound.release();
    }


}
