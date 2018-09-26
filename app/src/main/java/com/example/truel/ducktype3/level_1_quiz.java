package com.example.truel.ducktype3;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;




public class level_1_quiz extends AppCompatActivity {
//    SharedPreferences prefs = getApplicationContext().getSharedPreferences(
//            "MyPrefs", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_1_quiz);



        ImageButton choice1 = (ImageButton) findViewById(R.id.lvl1Frag1_choice1);
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", 0);

                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("unlock_lvl2", true);
                editor.apply();

                clearedlevel(v);
                finishthis();
            }
        });

        ImageButton choice2 = (ImageButton) findViewById(R.id.lvl1Frag1_choice2);
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
                finishthis();
            }
        });

        ImageButton choice3 = (ImageButton) findViewById(R.id.lvl1Frag1_choice3);
        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
                finishthis();
            }
        });

        ImageButton choice4 = (ImageButton) findViewById(R.id.lvl1Frag1_choice4);
        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
                finishthis();
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

    @Override
    public void onBackPressed() {
        AlertDialog.Builder backpress = new AlertDialog.Builder(this);

        backpress.setCancelable(true);
        backpress.setTitle("Are you sure you want to quit?");
        backpress.setMessage("Going back will not save your current progress");

        backpress.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishthis();

            }
            });
        backpress.setPositiveButton("Resume", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        backpress.show();
    }

    public void clearedlevel(View view) {
        Intent a = new Intent(this, levelCleared.class);
        startActivity(a);
    }

    public void failedLevel(View view) {
        Intent b = new Intent(this, levelFailed.class);
        startActivity(b);
    }

    protected void finishthis() {
        finish();
    }
}
