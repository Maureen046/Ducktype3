package com.example.truel.ducktype3.Level1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.truel.ducktype3.MainMenuActivity;
import com.example.truel.ducktype3.LevelFailedAndClearedActivities.LevelClearedActivity;
import com.example.truel.ducktype3.LevelFailedAndClearedActivities.LevelFailedActivity;
import com.example.truel.ducktype3.R;

import java.util.Random;

import static com.example.truel.ducktype3.R.id.LevelOneFirstChoiceText;
import static com.example.truel.ducktype3.R.id.LevelOneLastChoiceText;
import static com.example.truel.ducktype3.R.id.LevelOneSecondChoiceText;
import static com.example.truel.ducktype3.R.id.LevelOneThirdChoiceText;


public class LevelOneContainer extends AppCompatActivity {
    private String[] choices7;
    private String[] choices8;
    private String[] choices9;
    private String[] choices10;
    private String[] choices19;
    private String[] choices20;
    private String[] questions;
    private TextView FirstChoice;
    private TextView SecondChoice;
    private TextView ThirdChoice;
    private TextView LastChoice;

//    SharedPreferences prefs = getApplicationContext().getSharedPreferences(
//            "MyPrefs", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_one_container);

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
    }

    private void initUI() {
        questions = getResources().getStringArray(R.array.QuestionsForLevelOne);
        choices7 = getResources().getStringArray(R.array.Question7);
        choices8 = getResources().getStringArray(R.array.Question8);
        choices9 = getResources().getStringArray(R.array.Question9);
        choices10 = getResources().getStringArray(R.array.Question10);
        choices19 = getResources().getStringArray(R.array.Question19);
        choices20 = getResources().getStringArray(R.array.Question20);

        FirstChoice = (TextView) findViewById(LevelOneFirstChoiceText);
        SecondChoice = (TextView) findViewById(LevelOneSecondChoiceText);
        ThirdChoice = (TextView) findViewById(LevelOneThirdChoiceText);
        LastChoice = (TextView) findViewById(LevelOneLastChoiceText);
        setRandomQuestion();
    }

    private void setRandomQuestion() {
        int randomIndex = new Random().nextInt(questions.length + 1);
        String randomName;

        if (randomIndex < 1) {
            randomName = questions[0];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<Body>"));
            SecondChoice.setText(Html.fromHtml("<Title>"));
            ThirdChoice.setText(Html.fromHtml("<!DOCTYPE html>"));
            LastChoice.setText(Html.fromHtml("Web Browser"));

        } else if (randomIndex < 2) {
            randomName = questions[1];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<Html>"));
            SecondChoice.setText(Html.fromHtml("<Title>"));
            ThirdChoice.setText(Html.fromHtml("<HTML! doctype>"));
            LastChoice.setText(Html.fromHtml("<!DOCTYPE html>"));

        } else if (randomIndex < 3) {
            randomName = questions[2];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<html>"));
            SecondChoice.setText(Html.fromHtml("<Body>"));
            ThirdChoice.setText(Html.fromHtml("<Title>"));
            LastChoice.setText(Html.fromHtml("<!DOCTYPE html>"));

        } else if (randomIndex < 4) {
            randomName = questions[3];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<html>"));
            SecondChoice.setText(Html.fromHtml("</html>"));
            ThirdChoice.setText(Html.fromHtml("<end>"));
            LastChoice.setText(Html.fromHtml("</end>"));

        } else if (randomIndex < 5) {
            randomName = questions[4];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("Text"));
            SecondChoice.setText(Html.fromHtml("Normal Text"));
            ThirdChoice.setText(Html.fromHtml("Ordinary Text"));
            LastChoice.setText(Html.fromHtml("HTML Text"));

        } else if (randomIndex < 6) {
            randomName = questions[5];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("Hypertext Markup Language"));
            SecondChoice.setText(Html.fromHtml("Hypertext Mechanical Language"));
            ThirdChoice.setText(Html.fromHtml("Hypertext Markup Luggage"));
            LastChoice.setText(Html.fromHtml("Hypertext Marking Language"));

        } else if (randomIndex < 7) {
            randomName = questions[6];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices7[0]);
            SecondChoice.setText(choices7[1]);
            ThirdChoice.setText(choices7[2]);
            LastChoice.setText(choices7[3]);

        } else if (randomIndex < 8) {
            randomName = questions[7];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices8[0]);
            SecondChoice.setText(choices8[1]);
            ThirdChoice.setText(choices8[2]);
            LastChoice.setText(choices8[3]);

        } else if (randomIndex < 9) {
            randomName = questions[8];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices9[0]);
            SecondChoice.setText(choices9[1]);
            ThirdChoice.setText(choices9[2]);
            LastChoice.setText(choices9[3]);

        } else if (randomIndex < 10) {
            randomName = questions[9];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices10[0]);
            SecondChoice.setText(choices10[1]);
            ThirdChoice.setText(choices10[2]);
            LastChoice.setText(choices10[3]);

        } else if (randomIndex < 11) {
            randomName = questions[10];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<b/>"));
            SecondChoice.setText(Html.fromHtml("</>"));
            ThirdChoice.setText(Html.fromHtml("<space>"));
            LastChoice.setText(Html.fromHtml("<br>"));

        } else if (randomIndex < 12) {
            randomName = questions[11];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<h1>"));
            SecondChoice.setText(Html.fromHtml("<h>"));
            ThirdChoice.setText(Html.fromHtml("<ho>"));
            LastChoice.setText(Html.fromHtml("<heading1>"));

        } else if (randomIndex < 13) {
            randomName = questions[12];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<pr>"));
            SecondChoice.setText(Html.fromHtml("<p>"));
            ThirdChoice.setText(Html.fromHtml("<paragraph>"));
            LastChoice.setText(Html.fromHtml("<pg>"));

        } else if (randomIndex < 14) {
            randomName = questions[13];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<a=  >"));
            SecondChoice.setText(Html.fromHtml("<href=   >"));
            ThirdChoice.setText(Html.fromHtml("<ahref=   >"));
            LastChoice.setText(Html.fromHtml("<a href=  >"));

        } else if (randomIndex < 15) {
            randomName = questions[14];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<b>"));
            SecondChoice.setText(Html.fromHtml("<bt>"));
            ThirdChoice.setText(Html.fromHtml("<button>"));
            LastChoice.setText(Html.fromHtml("<bn>"));

        } else if (randomIndex < 16) {
            randomName = questions[15];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<bold>"));
            SecondChoice.setText(Html.fromHtml("<bo>"));
            ThirdChoice.setText(Html.fromHtml("<b>"));
            LastChoice.setText(Html.fromHtml("<o>"));

        } else if (randomIndex < 17) {
            randomName = questions[16];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<i>"));
            SecondChoice.setText(Html.fromHtml("<italic>"));
            ThirdChoice.setText(Html.fromHtml("<it>"));
            LastChoice.setText(Html.fromHtml("<il>"));

        } else if (randomIndex < 18) {
            randomName = questions[17];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<underline>"));
            SecondChoice.setText(Html.fromHtml("<line>"));
            ThirdChoice.setText(Html.fromHtml("<u>"));
            LastChoice.setText(Html.fromHtml("<_>"));

        } else if (randomIndex < 19) {
            randomName = questions[18];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices19[0]);
            SecondChoice.setText(choices19[1]);
            ThirdChoice.setText(choices19[2]);
            LastChoice.setText(choices19[3]);

        } else if (randomIndex < 20) {
            randomName = questions[19];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices20[0]);
            SecondChoice.setText(choices20[1]);
            ThirdChoice.setText(choices20[2]);
            LastChoice.setText(choices20[3]);

        } else if (randomIndex < 21) {
            randomName = questions[20];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<list>"));
            SecondChoice.setText(Html.fromHtml("<l>"));
            ThirdChoice.setText(Html.fromHtml("<li>"));
            LastChoice.setText(Html.fromHtml("<lt>"));

        } else if (randomIndex < 22) {
            randomName = questions[21];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<ul>"));
            SecondChoice.setText(Html.fromHtml("<unordered>"));
            ThirdChoice.setText(Html.fromHtml("<ud>"));
            LastChoice.setText(Html.fromHtml("<un>"));

        } else if (randomIndex < 23) {
            randomName = questions[22];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<ul style = “list-style-type:default”>"));
            SecondChoice.setText(Html.fromHtml("<ul style = “list-style-type:disc”>"));
            ThirdChoice.setText(Html.fromHtml("<ul style = “list-style-type:circle”>"));
            LastChoice.setText(Html.fromHtml("<ul style = “list-style-type:round”>"));

        } else if (randomIndex < 24) {
            randomName = questions[23];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<ul style = “list-style-type:box”>"));
            SecondChoice.setText(Html.fromHtml("<ul style = “list-style-type:square”>"));
            ThirdChoice.setText(Html.fromHtml("<ul style = “list-style-type:rectangle”>"));
            LastChoice.setText(Html.fromHtml("<ul style = “list-style-type:default”>"));


        } else if (randomIndex < 25) {
            randomName = questions[24];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<ul style = “list-style-type:none”>"));
            SecondChoice.setText(Html.fromHtml("<ul style = “list-style-type:”>"));
            ThirdChoice.setText(Html.fromHtml("<ul style = “list-style-type:blank”>"));
            LastChoice.setText(Html.fromHtml("<ul style = “list-style-type:empty”>"));


        } else if (randomIndex < 26) {
            randomName = questions[25];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<ul style = “list-style-type:disk”>"));
            SecondChoice.setText(Html.fromHtml("<ul style = “list-style-type:bullet”>"));
            ThirdChoice.setText(Html.fromHtml("<ul style = “list-style-type:circle”>"));
            LastChoice.setText(Html.fromHtml("<ul style = “list-style-type:round”>"));


        } else if (randomIndex < 27) {
            randomName = questions[26];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<img=\"XXXX.jpg\">"));
            SecondChoice.setText(Html.fromHtml("<img src=\"XXXX.jpg\">"));
            ThirdChoice.setText(Html.fromHtml("<img src \"XXXX.jpg\">"));
            LastChoice.setText(Html.fromHtml("<imgsrc=\"XXXX.jpg\">"));


        } else if (randomIndex < 28) {
            randomName = questions[27];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<alter>"));
            SecondChoice.setText(Html.fromHtml("<a>"));
            ThirdChoice.setText(Html.fromHtml("<alternative>"));
            LastChoice.setText(Html.fromHtml("<alt>"));

        } else if (randomIndex < 29) {
            randomName = questions[28];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<t>"));
            SecondChoice.setText(Html.fromHtml("<tb>"));
            ThirdChoice.setText(Html.fromHtml("<table>"));
            LastChoice.setText(Html.fromHtml("<td>"));

        } else if (randomIndex < 30) {
            randomName = questions[29];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(Html.fromHtml("<th>"));
            SecondChoice.setText(Html.fromHtml("<tr>"));
            ThirdChoice.setText(Html.fromHtml("<tb>"));
            LastChoice.setText(Html.fromHtml("<T>"));
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
                finish();
                GoToMainScreen();
            }
        });
        backpress.setPositiveButton("Resume", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        backpress.show();
    }

    private void choices() {

    }

    public void clearedlevel(View view) {
        Intent a = new Intent(this, LevelClearedActivity.class);
        startActivity(a);
    }

    public void failedLevel(View view) {
        Intent b = new Intent(this, LevelFailedActivity.class);
        startActivity(b);
    }


    protected void GoToMainScreen() {
        Intent c = new Intent(this, MainMenuActivity.class);
        startActivity(c);
    }
}
