package com.example.truel.ducktype3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class levelCleared extends AppCompatActivity {
    private MediaPlayer clearedsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_cleared);

        clearedsound = MediaPlayer.create(this, R.raw.cleared_sound);
        clearedsound.setLooping(true);
        clearedsound.setVolume(100, 100);
        clearedsound.start();

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.clearedLayout);
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

    private void move2level(View view)  {
        Intent a = new Intent(this, level_screen.class);
        startActivity(a);
    }

    @Override
    public void onPause() {
        super.onPause();
        clearedsound.release();
    }

    @Override
    public void onStop() {
        super.onStop();
        clearedsound.release();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clearedsound.release();
    }
}
