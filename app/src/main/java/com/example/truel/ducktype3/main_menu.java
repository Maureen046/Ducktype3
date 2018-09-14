package com.example.truel.ducktype3;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;


public class main_menu extends AppCompatActivity {

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
            }
        });
    }

    public void quacking(View view) {

        final ImageView quacking = (ImageView) findViewById(R.id.main_bg_pic);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.quack);
        quacking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
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

    public void go2level_screen() {
        Intent i = new Intent(this, level_screen.class);
        startActivity(i);
    }

    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            // Enable vibrate
        } else {

        }
    }


    @Override
    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(this, bgmusic_service.class));
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent i = new Intent(this, bgmusic_service.class);
        startService(i);
    }
}











