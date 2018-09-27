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
    private level_1_quiz_fragment_4 question4;
    private level_1_quiz_fragment_5 question5;
    private level_1_quiz_fragment_6 question6;
    private level_1_quiz_fragment_7 question7;
    private level_1_quiz_fragment_8 question8;
    private level_1_quiz_fragment_9 question9;
    private level_1_quiz_fragment_10 question10;
    private level_1_quiz_fragment_11 question11;
    private level_1_quiz_fragment_12 question12;
    private level_1_quiz_fragment_13 question13;
    private level_1_quiz_fragment_14 question14;
    private level_1_quiz_fragment_15 question15;
    private level_1_quiz_fragment_16 question10;
    private level_1_quiz_fragment_17 question11;
    private level_1_quiz_fragment_18 question12;
    private level_1_quiz_fragment_19 question13;
    private level_1_quiz_fragment_1 question14;
    private level_1_quiz_fragment_15 question15;

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
        randomFragmentNum = random.nextInt(29)+1;

//        if (randomFragmentNum < 50) {
//            randomFragmentNum = 0;
//        } else if (randomFragmentNum < 100) {
//            randomFragmentNum = 1;
//        } else if (randomFragmentNum < 150) {
//            randomFragmentNum = 2;
//        } else if (randomFragmentNum < 200) {
//            randomFragmentNum = 3;
//        } else if (randomFragmentNum < 250) {
//            randomFragmentNum = 4;
//        } else if (randomFragmentNum < 300) {
//            randomFragmentNum = 5;
//        } else if (randomFragmentNum < 350) {
//            randomFragmentNum = 6;
//        } else if (randomFragmentNum < 400) {
//            randomFragmentNum = 7;
//        } else if (randomFragmentNum < 450) {
//            randomFragmentNum = 8;
//        } else if (randomFragmentNum < 500) {
//            randomFragmentNum = 9;
//        } else if (randomFragmentNum < 550) {
//            randomFragmentNum = 10;
//        } else if (randomFragmentNum < 600) {
//            randomFragmentNum = 11;
//        } else if (randomFragmentNum < 650) {
//            randomFragmentNum = 12;
//        } else if (randomFragmentNum < 700) {
//            randomFragmentNum = 13;
//        } else if (randomFragmentNum < 750) {
//            randomFragmentNum = 14;
//        } else if (randomFragmentNum < 800) {
//            randomFragmentNum = 15;
//        } else if (randomFragmentNum < 850) {
//            randomFragmentNum = 16;
//        } else if (randomFragmentNum < 900) {
//            randomFragmentNum = 17;
//        } else if (randomFragmentNum < 950) {
//            randomFragmentNum = 18;
//        } else if (randomFragmentNum < 1000) {
//            randomFragmentNum = 19;
//        } else if (randomFragmentNum < 1050) {
//            randomFragmentNum = 20;
//        } else if (randomFragmentNum < 1100) {
//            randomFragmentNum = 21;
//        } else if (randomFragmentNum < 1150) {
//            randomFragmentNum = 22;
//        } else if (randomFragmentNum < 1200) {
//            randomFragmentNum = 23;
//        } else if (randomFragmentNum < 1250) {
//            randomFragmentNum = 24;
//        } else if (randomFragmentNum < 1300) {
//            randomFragmentNum = 25;
//        } else if (randomFragmentNum < 1350) {
//            randomFragmentNum = 26;
//        } else if (randomFragmentNum < 1400) {
//            randomFragmentNum = 27;
//        } else if (randomFragmentNum < 1450) {
//            randomFragmentNum = 28;
//        } else if (randomFragmentNum < 1500) {
//            randomFragmentNum = 29;
//        }




        switch (randomFragmentNum) {
            case 0: {
                question1 = new level_1_quiz_fragment_1();
                fragmentTransaction.replace(R.id.quiz1_frameLayout, question1);
                fragmentTransaction.commit();

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
