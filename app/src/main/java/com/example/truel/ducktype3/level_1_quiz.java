package com.example.truel.ducktype3;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import java.util.Random;


public class level_1_quiz extends AppCompatActivity {
    private int randomFragmentNum;
    private FrameLayout container;
    private FragmentTransaction fragmentTransaction;

    private level_1_quiz_fragment_1 question1;
    private level_1_quiz_fragment_2 question2;
    private level_1_quiz_fragment_3 question3;

//    SharedPreferences prefs = getApplicationContext().getSharedPreferences(
//            "MyPrefs", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_1_quiz);

        initUI();


//
//        ImageButton choice1 = (ImageButton) findViewById(R.id.lvl1Frag1_choice1);
//        choice1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", 0);
//
//                SharedPreferences.Editor editor = pref.edit();
//                editor.putBoolean("unlock_lvl2", true);
//                editor.apply();
//
//                clearedlevel(v);
//                finishthis();
//            }
//        });
//
//        ImageButton choice2 = (ImageButton) findViewById(R.id.lvl1Frag1_choice2);
//        choice2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                failedLevel(v);
//                finishthis();
//            }
//        });
//
//        ImageButton choice3 = (ImageButton) findViewById(R.id.lvl1Frag1_choice3);
//        choice3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                failedLevel(v);
//                finishthis();
//            }
//        });
//
//        ImageButton choice4 = (ImageButton) findViewById(R.id.lvl1Frag1_choice4);
//        choice4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                failedLevel(v);
//                finishthis();
//            }
//        });

    }

    private void initUI() {
        container = (FrameLayout) findViewById(R.id.quiz1_frameLayout);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        setRandomFragment();
    }

    private void setRandomFragment() {
        Random random = new Random();
        randomFragmentNum = random.nextInt(150);
        if (randomFragmentNum < 50) {
            randomFragmentNum = 0;
        } else if (randomFragmentNum < 100) {
            randomFragmentNum = 1;
        } else randomFragmentNum = 2;

        switch (randomFragmentNum) {
            case 0: {
                question1 = new level_1_quiz_fragment_1();
                fragmentTransaction.replace(R.id.quiz1_frameLayout, question1);
                fragmentTransaction.commit();

                try {
                    ImageButton choice1 = (ImageButton) findViewById(R.id.lvl1Frag1_choice1);
                    choice1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPrefs", 0);

                            SharedPreferences.Editor editor = pref.edit();
                            editor.putBoolean("unlock_lvl2", true);
                            editor.apply();

//                            clearedlevel(v);
//                            finishthis();
                        }
                    });
                }
                catch (Exception e){

                }


                break;
            }
            case 1: {
                question2 = new level_1_quiz_fragment_2();
                fragmentTransaction.replace(R.id.quiz1_frameLayout, question2);
                fragmentTransaction.commit();
                break;
            }
            case 2: {
                question3 = new level_1_quiz_fragment_3();
                fragmentTransaction.replace(R.id.quiz1_frameLayout, question3);
                fragmentTransaction.commit();
                break;
            }
        }
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
