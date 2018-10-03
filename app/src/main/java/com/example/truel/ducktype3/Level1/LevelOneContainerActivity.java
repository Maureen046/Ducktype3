package com.example.truel.ducktype3.Level1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
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
import static com.example.truel.ducktype3.R.id.lvl1Frag1_choice1;
import static com.example.truel.ducktype3.R.id.lvl1Frag1_choice2;
import static com.example.truel.ducktype3.R.id.lvl1Frag1_choice3;
import static com.example.truel.ducktype3.R.id.lvl1Frag1_choice4;


public class LevelOneContainerActivity extends AppCompatActivity {
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
    private ImageButton FirstChoiceButton;
    private ImageButton SecondChoiceButton;
    private ImageButton ThirdChoiceButton;
    private ImageButton LastChoiceButton;

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

        FirstChoiceButton = (ImageButton) findViewById(lvl1Frag1_choice1);
        SecondChoiceButton = (ImageButton) findViewById(lvl1Frag1_choice2);
        ThirdChoiceButton = (ImageButton) findViewById(lvl1Frag1_choice3);
        LastChoiceButton = (ImageButton) findViewById(lvl1Frag1_choice4);

        setRandomQuestion();
    }

    private void setRandomQuestion() {
        int randomIndex = new Random().nextInt(questions.length);
        String randomName;

        if (randomIndex < 1) {
            randomName = questions[0];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<Body>");
            SecondChoice.setText("<Title>");
            ThirdChoice.setText("<!DOCTYPE html>");
            LastChoice.setText("Web Browser");

            SecondChoicePress(null);


        } else if (randomIndex < 2) {
            randomName = questions[1];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<Html>");
            SecondChoice.setText("<Title>");
            ThirdChoice.setText("<HTML! doctype>");
            LastChoice.setText("<!DOCTYPE html>");

            LastChoicePress(null);

        } else if (randomIndex < 3) {
            randomName = questions[2];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<html>");
            SecondChoice.setText("<Body>");
            ThirdChoice.setText("<Title>");
            LastChoice.setText("<!DOCTYPE html>");

            SecondChoicePress(null);

        } else if (randomIndex < 4) {
            randomName = questions[3];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<html>");
            SecondChoice.setText("</html>");
            ThirdChoice.setText("<end>");
            LastChoice.setText("</end>");

            SecondChoicePress(null);

        } else if (randomIndex < 5) {
            randomName = questions[4];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("Text");
            SecondChoice.setText("Normal Text");
            ThirdChoice.setText("Ordinary Text");
            LastChoice.setText("HTML Text");

            SecondChoicePress(null);

        } else if (randomIndex < 6) {
            randomName = questions[5];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("Hypertext Markup Language");
            SecondChoice.setText("Hypertext Mechanical Language");
            ThirdChoice.setText("Hypertext Markup Luggage");
            LastChoice.setText("Hypertext Marking Language");

            FirstChoicePress(null);

        } else if (randomIndex < 7) {
            randomName = questions[6];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices7[0]);
            SecondChoice.setText(choices7[1]);
            ThirdChoice.setText(choices7[2]);
            LastChoice.setText(choices7[3]);

            FirstChoicePress(null);

        } else if (randomIndex < 8) {
            randomName = questions[7];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices8[0]);
            SecondChoice.setText(choices8[1]);
            ThirdChoice.setText(choices8[2]);
            LastChoice.setText(choices8[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 9) {
            randomName = questions[8];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices9[0]);
            SecondChoice.setText(choices9[1]);
            ThirdChoice.setText(choices9[2]);
            LastChoice.setText(choices9[3]);

            LastChoicePress(null);

        } else if (randomIndex < 10) {
            randomName = questions[9];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices10[0]);
            SecondChoice.setText(choices10[1]);
            ThirdChoice.setText(choices10[2]);
            LastChoice.setText(choices10[3]);

            LastChoicePress(null);

        } else if (randomIndex < 11) {
            randomName = questions[10];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<b/>");
            SecondChoice.setText("</>");
            ThirdChoice.setText("<space>");
            LastChoice.setText("<br>");

            LastChoicePress(null);

        } else if (randomIndex < 12) {
            randomName = questions[11];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<h1>");
            SecondChoice.setText("<h>");
            ThirdChoice.setText("<ho>");
            LastChoice.setText("<heading1>");

            FirstChoicePress(null);

        } else if (randomIndex < 13) {
            randomName = questions[12];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<pr>");
            SecondChoice.setText("<p>");
            ThirdChoice.setText("<paragraph>");
            LastChoice.setText("<pg>");

            SecondChoicePress(null);

        } else if (randomIndex < 14) {
            randomName = questions[13];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<a=  >");
            SecondChoice.setText("<href=   >");
            ThirdChoice.setText("<ahref=   >");
            LastChoice.setText("<a href=  >");

            LastChoicePress(null);

        } else if (randomIndex < 15) {
            randomName = questions[14];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<b>");
            SecondChoice.setText("<bt>");
            ThirdChoice.setText("<button>");
            LastChoice.setText("<bn>");

            ThirdChoicePress(null);

        } else if (randomIndex < 16) {
            randomName = questions[15];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<bold>");
            SecondChoice.setText("<bo>");
            ThirdChoice.setText("<b>");
            LastChoice.setText("<o>");

            ThirdChoicePress(null);

        } else if (randomIndex < 17) {
            randomName = questions[16];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<i>");
            SecondChoice.setText("<italic>");
            ThirdChoice.setText("<it>");
            LastChoice.setText("<il>");

            FirstChoicePress(null);

        } else if (randomIndex < 18) {
            randomName = questions[17];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<underline>");
            SecondChoice.setText("<line>");
            ThirdChoice.setText("<u>");
            LastChoice.setText("<_>");

            ThirdChoicePress(null);

        } else if (randomIndex < 19) {
            randomName = questions[18];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices19[0]);
            SecondChoice.setText(choices19[1]);
            ThirdChoice.setText(choices19[2]);
            LastChoice.setText(choices19[3]);

            FirstChoicePress(null);


        } else if (randomIndex < 20) {
            randomName = questions[19];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices20[0]);
            SecondChoice.setText(choices20[1]);
            ThirdChoice.setText(choices20[2]);
            LastChoice.setText(choices20[3]);

            FirstChoicePress(null);

        } else if (randomIndex < 21) {
            randomName = questions[20];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<list>");
            SecondChoice.setText("<l>");
            ThirdChoice.setText("<li>");
            LastChoice.setText("<lt>");

            ThirdChoicePress(null);

        } else if (randomIndex < 22) {
            randomName = questions[21];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<ul>");
            SecondChoice.setText("<unordered>");
            ThirdChoice.setText("<ud>");
            LastChoice.setText("<un>");

            FirstChoicePress(null);

        } else if (randomIndex < 23) {
            randomName = questions[22];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<ul style = “list-style-type:default”>");
            SecondChoice.setText("<ul style = “list-style-type:disc”>");
            ThirdChoice.setText("<ul style = “list-style-type:circle”>");
            LastChoice.setText("<ul style = “list-style-type:round”>");

            ThirdChoicePress(null);

        } else if (randomIndex < 24) {
            randomName = questions[23];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<ul style = “list-style-type:box”>");
            SecondChoice.setText("<ul style = “list-style-type:square”>");
            ThirdChoice.setText("<ul style = “list-style-type:rectangle”>");
            LastChoice.setText("<ul style = “list-style-type:default”>");

            SecondChoicePress(null);

        } else if (randomIndex < 25) {
            randomName = questions[24];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<ul style = “list-style-type:none”>");
            SecondChoice.setText("<ul style = “list-style-type:”>");
            ThirdChoice.setText("<ul style = “list-style-type:blank”>");
            LastChoice.setText("<ul style = “list-style-type:empty”>");

            FirstChoicePress(null);

        } else if (randomIndex < 26) {
            randomName = questions[25];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<ul style = “list-style-type:disk”>");
            SecondChoice.setText("<ul style = “list-style-type:bullet”>");
            ThirdChoice.setText("<ul style = “list-style-type:circle”>");
            LastChoice.setText("<ul style = “list-style-type:round”>");

            FirstChoicePress(null);

        } else if (randomIndex < 27) {
            randomName = questions[26];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<img=\"XXXX.jpg\">");
            SecondChoice.setText("<img src=\"XXXX.jpg\">");
            ThirdChoice.setText("<img src \"XXXX.jpg\">");
            LastChoice.setText("<imgsrc=\"XXXX.jpg\">");

            SecondChoicePress(null);

        } else if (randomIndex < 28) {
            randomName = questions[27];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<alter>");
            SecondChoice.setText("<a>");
            ThirdChoice.setText("<alternative>");
            LastChoice.setText("<alt>");

            LastChoicePress(null);

        } else if (randomIndex < 29) {
            randomName = questions[28];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<t>");
            SecondChoice.setText("<tb>");
            ThirdChoice.setText("<table>");
            LastChoice.setText("<td>");

            ThirdChoicePress(null);

        } else if (randomIndex < 30) {
            randomName = questions[29];
            TextView place = (TextView) findViewById(R.id.LevelOneQuestionText);
            place.setText(randomName);

            FirstChoice.setText("<th>");
            SecondChoice.setText("<tr>");
            ThirdChoice.setText("<tb>");
            LastChoice.setText("<T>");

            FirstChoicePress(null);
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
                GoToMainScreen();
                finish();
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
        Intent a = new Intent(this, LevelClearedActivity.class);
        startActivity(a);
    }


    public void failedLevel(View view) {
        Intent b = new Intent(this, LevelFailedActivity.class);
        startActivity(b);
        finish();
    }


    protected void GoToMainScreen() {
        Intent c = new Intent(this, MainMenuActivity.class);
        startActivity(c);
    }

    protected void FirstChoicePress(View view) {
        FirstChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO add score system
                setRandomQuestion();
            }
        });
        SecondChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        ThirdChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        LastChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
    }

    protected void SecondChoicePress(View view) {
        FirstChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        SecondChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO add score system
                setRandomQuestion();
            }
        });
        ThirdChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        LastChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
    }

    protected void ThirdChoicePress(View view) {
        FirstChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        SecondChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        ThirdChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO add score system
                setRandomQuestion();
            }
        });
        LastChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
    }

    protected void LastChoicePress(View view) {
        FirstChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        SecondChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        LastChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failedLevel(v);
            }
        });
        LastChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO add score system
                setRandomQuestion();
            }
        });
    }
}
