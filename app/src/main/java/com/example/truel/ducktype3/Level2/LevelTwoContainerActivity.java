package com.example.truel.ducktype3.Level2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.truel.ducktype3.LevelFailedAndClearedActivities.LevelClearedActivity;
import com.example.truel.ducktype3.LevelFailedAndClearedActivities.LevelFailedActivity;
import com.example.truel.ducktype3.MainMenuActivity;
import com.example.truel.ducktype3.R;

import java.util.Random;

import static com.example.truel.ducktype3.R.id.LevelTwoFirstChoiceText;
import static com.example.truel.ducktype3.R.id.LevelTwoImageLanding;
import static com.example.truel.ducktype3.R.id.LevelTwoLastChoiceText;
import static com.example.truel.ducktype3.R.id.LevelTwoQuestionText;
import static com.example.truel.ducktype3.R.id.LevelTwoSecondChoiceText;
import static com.example.truel.ducktype3.R.id.LevelTwoThirdChoiceText;
import static com.example.truel.ducktype3.R.id.lvl2Frag2_choice1;
import static com.example.truel.ducktype3.R.id.lvl2Frag2_choice2;
import static com.example.truel.ducktype3.R.id.lvl2Frag2_choice3;
import static com.example.truel.ducktype3.R.id.lvl2Frag2_choice4;

public class LevelTwoContainerActivity extends AppCompatActivity {
    private String[] choices1;
    private String[] choices2;
    private String[] choices3;
    private String[] choices4;
    private String[] choices5;
    private String[] choices6;
    private String[] choices7;
    private String[] choices8;
    private String[] choices9;
    private String[] choices10;
    private String[] choices11;
    private String[] choices13;
    private String[] choices14;
    private String[] choices15;
    private String[] choices16;
    private String[] choices17;
    private String[] choices18;
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

    private ImageView LevelTwoCodeQuestion;
    private TextView LevelTwoQuestion;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_two_container);
        BGMusic();

        initUI();


    }

    private void BGMusic() {
        mediaPlayer =  new MediaPlayer();
        Context context =  getApplicationContext();
        mediaPlayer = MediaPlayer.create(context, R.raw.level2_backgroundmusic_arcadepuzzler_v001);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100, 100);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }


    private void initUI() {
        questions = getResources().getStringArray(R.array.QuestionsForLevelTwo);

        choices1 = getResources().getStringArray(R.array.TwoQuestion1);
        choices2 = getResources().getStringArray(R.array.TwoQuestion2);
        choices3 = getResources().getStringArray(R.array.TwoQuestion3);
        choices4 = getResources().getStringArray(R.array.TwoQuestion4);
        choices5 = getResources().getStringArray(R.array.TwoQuestion5);
        choices6 = getResources().getStringArray(R.array.TwoQuestion6);
        choices7 = getResources().getStringArray(R.array.TwoQuestion7);
        choices8 = getResources().getStringArray(R.array.TwoQuestion8);
        choices9 = getResources().getStringArray(R.array.TwoQuestion9);
        choices10 = getResources().getStringArray(R.array.TwoQuestion10);
        choices11 = getResources().getStringArray(R.array.TwoQuestion11);
        choices13 = getResources().getStringArray(R.array.TwoQuestion13);
        choices14 = getResources().getStringArray(R.array.TwoQuestion14);
        choices15 = getResources().getStringArray(R.array.TwoQuestion15);
        choices16 = getResources().getStringArray(R.array.TwoQuestion16);
        choices17 = getResources().getStringArray(R.array.TwoQuestion17);
        choices18 = getResources().getStringArray(R.array.TwoQuestion18);
        choices19 = getResources().getStringArray(R.array.TwoQuestion19);
        choices20 = getResources().getStringArray(R.array.TwoQuestion20);


        FirstChoice = (TextView) findViewById(LevelTwoFirstChoiceText);
        SecondChoice = (TextView) findViewById(LevelTwoSecondChoiceText);
        ThirdChoice = (TextView) findViewById(LevelTwoThirdChoiceText);
        LastChoice = (TextView) findViewById(LevelTwoLastChoiceText);

        FirstChoiceButton = (ImageButton) findViewById(lvl2Frag2_choice1);
        SecondChoiceButton = (ImageButton) findViewById(lvl2Frag2_choice2);
        ThirdChoiceButton = (ImageButton) findViewById(lvl2Frag2_choice3);
        LastChoiceButton = (ImageButton) findViewById(lvl2Frag2_choice4);

        LevelTwoCodeQuestion =  (ImageView) findViewById(LevelTwoImageLanding);
        LevelTwoQuestion = (TextView) findViewById(LevelTwoQuestionText);

        setRandomQuestion();
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


    private void setRandomQuestion() {
        int randomIndex = new Random().nextInt(questions.length+10);
        String randomName;

        if (randomIndex < 1) {
            ImageCheck();
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText("This is defined by using the <tr></tr> tag pair.");

            FirstChoice.setText(choices1[0]);
            SecondChoice.setText(choices1[1]);
            ThirdChoice.setText(choices1[2]);
            LastChoice.setText(choices1[3]);

            SecondChoicePress(null);


        } else if (randomIndex < 2) {
            ImageCheck();
            randomName = questions[1];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices2[0]);
            SecondChoice.setText(choices2[1]);
            ThirdChoice.setText(choices2[2]);
            LastChoice.setText(choices2[3]);

            LastChoicePress(null);

        } else if (randomIndex < 3) {
            ImageCheck();
            randomName = questions[2];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices3[0]);
            SecondChoice.setText(choices3[1]);
            ThirdChoice.setText(choices3[2]);
            LastChoice.setText(choices3[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 4) {
            ImageCheck();
            randomName = questions[3];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices4[0]);
            SecondChoice.setText(choices4[1]);
            ThirdChoice.setText(choices4[2]);
            LastChoice.setText(choices4[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 5) {
            ImageCheck();
            randomName = questions[4];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices5[0]);
            SecondChoice.setText(choices5[1]);
            ThirdChoice.setText(choices5[2]);
            LastChoice.setText(choices5[3]);

            FirstChoicePress(null);

        } else if (randomIndex < 6) {
            ImageCheck();
            randomName = questions[5];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices6[0]);
            SecondChoice.setText(choices6[1]);
            ThirdChoice.setText(choices6[2]);
            LastChoice.setText(choices6[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 7) {
            ImageCheck();
            randomName = questions[6];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices7[0]);
            SecondChoice.setText(choices7[1]);
            ThirdChoice.setText(choices7[2]);
            LastChoice.setText(choices7[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 8) {
            ImageCheck();
            randomName = questions[7];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices8[0]);
            SecondChoice.setText(choices8[1]);
            ThirdChoice.setText(choices8[2]);
            LastChoice.setText(choices8[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 9) {
            ImageCheck();
            randomName = questions[8];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices9[0]);
            SecondChoice.setText(choices9[1]);
            ThirdChoice.setText(choices9[2]);
            LastChoice.setText(choices9[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 10) {
            ImageCheck();
            randomName = questions[9];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices10[0]);
            SecondChoice.setText(choices10[1]);
            ThirdChoice.setText(choices10[2]);
            LastChoice.setText(choices10[3]);

            LastChoicePress(null);

        } else if (randomIndex < 11) {
            ImageCheck();
            randomName = questions[10];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices11[0]);
            SecondChoice.setText(choices11[1]);
            ThirdChoice.setText(choices11[2]);
            LastChoice.setText(choices11[3]);

            FirstChoicePress(null);

        } else if (randomIndex < 12) {
            ImageCheck();
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText("Required for frames that will allow targeting by other HTML documents via referencing the target " +
                    "attribute used in the <A>,<AREA>,<BASE> and <FORM> tag");

            FirstChoice.setText("Frame resize toggling attribute");
            SecondChoice.setText("Frame name attribute");
            ThirdChoice.setText("Frame document solo attribute");
            LastChoice.setText("Margin width attribute");

            LastChoicePress(null);

        } else if (randomIndex < 13) {
            ImageCheck();
            randomName = questions[12];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices13[0]);
            SecondChoice.setText(choices13[1]);
            ThirdChoice.setText(choices13[2]);
            LastChoice.setText(choices13[3]);

            ThirdChoicePress(null);

        } else if (randomIndex < 14) {
            ImageCheck();
            randomName = questions[13];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices14[0]);
            SecondChoice.setText(choices14[1]);
            ThirdChoice.setText(choices14[2]);
            LastChoice.setText(choices14[3]);

            FirstChoicePress(null);

        } else if (randomIndex < 15) {
            ImageCheck();
            randomName = questions[14];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices15[0]);
            SecondChoice.setText(choices15[1]);
            ThirdChoice.setText(choices15[2]);
            LastChoice.setText(choices15[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 16) {
            ImageCheck();
            randomName = questions[15];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices16[0]);
            SecondChoice.setText(choices16[1]);
            ThirdChoice.setText(choices16[2]);
            LastChoice.setText(choices16[3]);

            FirstChoicePress(null);

        } else if (randomIndex < 17) {
            ImageCheck();
            randomName = questions[16];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices17[0]);
            SecondChoice.setText(choices17[1]);
            ThirdChoice.setText(choices17[2]);
            LastChoice.setText(choices17[3]);

            SecondChoicePress(null);

        } else if (randomIndex < 18) {
            ImageCheck();
            randomName = questions[17];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices18[0]);
            SecondChoice.setText(choices18[1]);
            ThirdChoice.setText(choices18[2]);
            LastChoice.setText(choices18[3]);

            FirstChoicePress(null);

        } else if (randomIndex < 19) {
            ImageCheck();
            randomName = questions[18];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices19[0]);
            SecondChoice.setText(choices19[1]);
            ThirdChoice.setText(choices19[2]);
            LastChoice.setText(choices19[3]);

            LastChoicePress(null);


        } else if (randomIndex < 20) {
            ImageCheck();
            randomName = questions[19];
            TextView place = (TextView) findViewById(R.id.LevelTwoQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices20[0]);
            SecondChoice.setText(choices20[1]);
            ThirdChoice.setText(choices20[2]);
            LastChoice.setText(choices20[3]);

            FirstChoicePress(null);

        } else if (randomIndex < 21) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal01);

            FirstChoice.setText("<h1>");
            SecondChoice.setText("</head>");
            ThirdChoice.setText("</body>");
            LastChoice.setText("<br>");

            ThirdChoicePress(null);

        } else if (randomIndex < 22) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal02);

            FirstChoice.setText("<tr>");
            SecondChoice.setText("</head>");
            ThirdChoice.setText("<tb>");
            LastChoice.setText("</p>");

            LastChoicePress(null);

        } else if (randomIndex < 23) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal03);

            FirstChoice.setText("</body>");
            SecondChoice.setText("</head>");
            ThirdChoice.setText("<head>");
            LastChoice.setText("<h1>");

            SecondChoicePress(null);

        } else if (randomIndex < 24) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal04);

            FirstChoice.setText("<head>");
            SecondChoice.setText("</html>");
            ThirdChoice.setText("<p4>");
            LastChoice.setText("</p1>");

            FirstChoicePress(null);

        } else if (randomIndex < 25) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal05);

            FirstChoice.setText("<head>");
            SecondChoice.setText("<tb>");
            ThirdChoice.setText("<hr>");
            LastChoice.setText("<html>");

            LastChoicePress(null);

        } else if (randomIndex < 26) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal06);

            FirstChoice.setText(".jpg");
            SecondChoice.setText("</p>");
            ThirdChoice.setText("<p>");
            LastChoice.setText("<html>");

            ThirdChoicePress(null);

        } else if (randomIndex < 27) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal07);

            FirstChoice.setText("</a href>");
            SecondChoice.setText(".jpg");
            ThirdChoice.setText("</a>");
            LastChoice.setText("</href>");

            ThirdChoicePress(null);

        } else if (randomIndex < 28) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal08);

            FirstChoice.setText(".jpg");
            SecondChoice.setText("<a>");
            ThirdChoice.setText("</jpg>");
            LastChoice.setText("</href>");

            FirstChoicePress(null);

        } else if (randomIndex < 29) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal09);

            FirstChoice.setText("</head>");
            SecondChoice.setText(".jpg");
            ThirdChoice.setText("</body>");
            LastChoice.setText("<a href>");

            ThirdChoicePress(null);

        } else if (randomIndex < 30) {
            TextCheck();
            LevelTwoCodeQuestion.setBackgroundResource(R.drawable.normal10);

            FirstChoice.setText("</html>");
            SecondChoice.setText("/href");
            ThirdChoice.setText("<br>");
            LastChoice.setText("href");

            LastChoicePress(null);
        }
    }


    protected void removeTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

    private void ImageCheck() {
        if (LevelTwoCodeQuestion != null) {
            LevelTwoCodeQuestion.setBackgroundResource(0);
        }
    }

    private void TextCheck() {
        if (LevelTwoQuestion != null) {
            LevelTwoQuestion.setText("");
        }
    }
}


