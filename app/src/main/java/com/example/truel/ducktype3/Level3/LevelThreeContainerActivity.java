package com.example.truel.ducktype3.Level3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.truel.ducktype3.LevelFailedAndClearedActivities.LevelClearedActivity;
import com.example.truel.ducktype3.LevelFailedAndClearedActivities.LevelFailedActivity;
import com.example.truel.ducktype3.MainMenuActivity;
import com.example.truel.ducktype3.R;

import java.util.Random;

import static android.view.View.INVISIBLE;
import static com.example.truel.ducktype3.R.id.LevelThreeFirstChoiceText;
import static com.example.truel.ducktype3.R.id.LevelThreeImageCodeLanding;
import static com.example.truel.ducktype3.R.id.LevelThreeLastChoiceText;
import static com.example.truel.ducktype3.R.id.LevelThreeSecondChoiceText;
import static com.example.truel.ducktype3.R.id.LevelThreeThirdChoiceText;
import static com.example.truel.ducktype3.R.id.lvl3Frag3_choice1;
import static com.example.truel.ducktype3.R.id.lvl3Frag3_choice2;
import static com.example.truel.ducktype3.R.id.lvl3Frag3_choice3;
import static com.example.truel.ducktype3.R.id.lvl3Frag3_choice4;

public class LevelThreeContainerActivity extends AppCompatActivity {

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
    private String[] choices12;
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

    private ImageView LevelThreeCodeQuestion;
    private MediaPlayer mediaPlayer;

    private FrameLayout ChildFrameLayout;

    private String GetAnswer;
    private String correctAnswer;
    private EditText AnswerHere;

    private Boolean ChoicesIsShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_three_container);
        BGMusic();

        initUI();
    }

    private void BGMusic() {
        mediaPlayer = new MediaPlayer();
        Context context = getApplicationContext();
        mediaPlayer = MediaPlayer.create(context, R.raw.level3_backgroundmusic_thebitbuilders);
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
        questions = getResources().getStringArray(R.array.QuestionsForLevelThree);

        choices2 = getResources().getStringArray(R.array.ThreeQuestion2);
        choices3 = getResources().getStringArray(R.array.ThreeQuestion3);
        choices4 = getResources().getStringArray(R.array.ThreeQuestion4);
        choices5 = getResources().getStringArray(R.array.ThreeQuestion5);
        choices6 = getResources().getStringArray(R.array.ThreeQuestion6);
        choices7 = getResources().getStringArray(R.array.ThreeQuestion7);
        choices8 = getResources().getStringArray(R.array.ThreeQuestion8);
        choices9 = getResources().getStringArray(R.array.ThreeQuestion9);
        choices10 = getResources().getStringArray(R.array.ThreeQuestion10);
        choices11 = getResources().getStringArray(R.array.ThreeQuestion11);
        choices12 = getResources().getStringArray(R.array.ThreeQuestion12);
        choices13 = getResources().getStringArray(R.array.ThreeQuestion13);
        choices14 = getResources().getStringArray(R.array.ThreeQuestion14);
        choices15 = getResources().getStringArray(R.array.ThreeQuestion15);
        choices16 = getResources().getStringArray(R.array.ThreeQuestion16);
        choices17 = getResources().getStringArray(R.array.ThreeQuestion17);
        choices18 = getResources().getStringArray(R.array.ThreeQuestion18);
        choices19 = getResources().getStringArray(R.array.ThreeQuestion19);
        choices20 = getResources().getStringArray(R.array.ThreeQuestion20);


        FirstChoice = (TextView) findViewById(LevelThreeFirstChoiceText);
        SecondChoice = (TextView) findViewById(LevelThreeSecondChoiceText);
        ThirdChoice = (TextView) findViewById(LevelThreeThirdChoiceText);
        LastChoice = (TextView) findViewById(LevelThreeLastChoiceText);

        FirstChoiceButton = (ImageButton) findViewById(lvl3Frag3_choice1);
        SecondChoiceButton = (ImageButton) findViewById(lvl3Frag3_choice2);
        ThirdChoiceButton = (ImageButton) findViewById(lvl3Frag3_choice3);
        LastChoiceButton = (ImageButton) findViewById(lvl3Frag3_choice4);

        LevelThreeCodeQuestion = (ImageView) findViewById(LevelThreeImageCodeLanding);
        ChildFrameLayout = findViewById(R.id.LevelThreeCodeAnswerLanding);


        setRandomQuestion();
    }

    public void setRandomQuestion() {
        int randomIndex = new Random().nextInt(questions.length + 10);
        String randomName;

        if (randomIndex < 1) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText("The CSS code is placed within the _______ tags of an html file.");

            FirstChoice.setText("<body></body>");
            SecondChoice.setText("<p></p>");
            ThirdChoice.setText("<head></head>");
            LastChoice.setText("<table></table>");

            ThirdChoicePress();


        } else if (randomIndex < 2) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[1];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices2[0]);
            SecondChoice.setText(choices2[1]);
            ThirdChoice.setText(choices2[2]);
            LastChoice.setText(choices2[3]);

            FirstChoicePress();

        } else if (randomIndex < 3) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[2];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices3[0]);
            SecondChoice.setText(choices3[1]);
            ThirdChoice.setText(choices3[2]);
            LastChoice.setText(choices3[3]);

            SecondChoicePress();

        } else if (randomIndex < 4) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[3];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices4[0]);
            SecondChoice.setText(choices4[1]);
            ThirdChoice.setText(choices4[2]);
            LastChoice.setText(choices4[3]);

            FirstChoicePress();

        } else if (randomIndex < 5) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[4];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices5[0]);
            SecondChoice.setText(choices5[1]);
            ThirdChoice.setText(choices5[2]);
            LastChoice.setText(choices5[3]);

            LastChoicePress();

        } else if (randomIndex < 6) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[5];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices6[0]);
            SecondChoice.setText(choices6[1]);
            ThirdChoice.setText(choices6[2]);
            LastChoice.setText(choices6[3]);

            FirstChoicePress();

        } else if (randomIndex < 7) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[6];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices7[0]);
            SecondChoice.setText(choices7[1]);
            ThirdChoice.setText(choices7[2]);
            LastChoice.setText(choices7[3]);

            ThirdChoicePress();

        } else if (randomIndex < 8) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[7];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices8[0]);
            SecondChoice.setText(choices8[1]);
            ThirdChoice.setText(choices8[2]);
            LastChoice.setText(choices8[3]);

            SecondChoicePress();

        } else if (randomIndex < 9) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[8];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices9[0]);
            SecondChoice.setText(choices9[1]);
            ThirdChoice.setText(choices9[2]);
            LastChoice.setText(choices9[3]);

            ThirdChoicePress();

        } else if (randomIndex < 10) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[9];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices10[0]);
            SecondChoice.setText(choices10[1]);
            ThirdChoice.setText(choices10[2]);
            LastChoice.setText(choices10[3]);

            LastChoicePress();

        } else if (randomIndex < 11) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[10];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices11[0]);
            SecondChoice.setText(choices11[1]);
            ThirdChoice.setText(choices11[2]);
            LastChoice.setText(choices11[3]);

            FirstChoicePress();

        } else if (randomIndex < 12) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[11];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices12[0]);
            SecondChoice.setText(choices12[1]);
            ThirdChoice.setText(choices12[2]);
            LastChoice.setText(choices12[3]);

            SecondChoicePress();

        } else if (randomIndex < 13) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[12];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices13[0]);
            SecondChoice.setText(choices13[1]);
            ThirdChoice.setText(choices13[2]);
            LastChoice.setText(choices13[3]);

            LastChoicePress();

        } else if (randomIndex < 14) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[13];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices14[0]);
            SecondChoice.setText(choices14[1]);
            ThirdChoice.setText(choices14[2]);
            LastChoice.setText(choices14[3]);

            ThirdChoicePress();

        } else if (randomIndex < 15) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[14];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices15[0]);
            SecondChoice.setText(choices15[1]);
            ThirdChoice.setText(choices15[2]);
            LastChoice.setText(choices15[3]);

            FirstChoicePress();

        } else if (randomIndex < 16) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[15];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices16[0]);
            SecondChoice.setText(choices16[1]);
            ThirdChoice.setText(choices16[2]);
            LastChoice.setText(choices16[3]);

            SecondChoicePress();

        } else if (randomIndex < 17) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[16];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices17[0]);
            SecondChoice.setText(choices17[1]);
            ThirdChoice.setText(choices17[2]);
            LastChoice.setText(choices17[3]);

            LastChoicePress();

        } else if (randomIndex < 18) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[17];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices18[0]);
            SecondChoice.setText(choices18[1]);
            ThirdChoice.setText(choices18[2]);
            LastChoice.setText("Within <>");

            FirstChoicePress();

        } else if (randomIndex < 19) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[18];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices19[0]);
            SecondChoice.setText(choices19[1]);
            ThirdChoice.setText(choices19[2]);
            LastChoice.setText(choices19[3]);

            ThirdChoicePress();


        } else if (randomIndex < 20) {
            ChoicesIsShown = true;
            ImageCheck();
            AddMultipleChoice();
            randomName = questions[19];
            TextView place = (TextView) findViewById(R.id.LevelThreeQuestionText);
            place.setText(randomName);

            FirstChoice.setText(choices20[0]);
            SecondChoice.setText(choices20[1]);
            ThirdChoice.setText(choices20[2]);
            LastChoice.setText(choices20[3]);

            LastChoicePress();

        } else if (randomIndex < 21) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard01);
            AddMultipleChoice();

            correctAnswer = ";";
            SubmitButtonClick();


        } else if (randomIndex < 22) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard02);
            AddMultipleChoice();
            correctAnswer = "href";
            SubmitButtonClick();

        } else if (randomIndex < 23) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard03);
            AddMultipleChoice();
            correctAnswer = "style";
            SubmitButtonClick();


        } else if (randomIndex < 24) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard04);
            AddMultipleChoice();
            correctAnswer = ":";
            SubmitButtonClick();

        } else if (randomIndex < 25) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard05);
            AddMultipleChoice();
            correctAnswer = "border-radius";
            SubmitButtonClick();

        } else if (randomIndex < 26) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard06);
            AddMultipleChoice();
            correctAnswer = "url";
            SubmitButtonClick();

        } else if (randomIndex < 27) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard07);
            AddMultipleChoice();
            correctAnswer = "}";
            SubmitButtonClick();

        } else if (randomIndex < 28) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard08);
            AddMultipleChoice();
            correctAnswer = "style";
            SubmitButtonClick();

        } else if (randomIndex < 29) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard09);
            AddMultipleChoice();
            correctAnswer = "rel";
            SubmitButtonClick();

        } else if (randomIndex < 30) {
            ChoicesIsShown = false;
            TextCheck();
            LevelThreeCodeQuestion.setBackgroundResource(R.drawable.hard10);
            AddMultipleChoice();
            correctAnswer = "</p>";
            SubmitButtonClick();
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
        Intent MainMenuIntent = new Intent(this, MainMenuActivity.class);
        startActivity(MainMenuIntent);
    }

    protected void FirstChoicePress() {
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

    protected void SecondChoicePress() {
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

    protected void ThirdChoicePress() {
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

    protected void LastChoicePress() {
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

    private void SubmitButtonClick() {
        ImageButton submit = (ImageButton) findViewById(R.id.SUBMIT_HERE_BUTTON);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText answer = (EditText) findViewById(R.id.ANSWER_HERE_EDITTEXT);
                GetAnswer = answer.getText().toString().trim();
                if (correctAnswer.equals(GetAnswer)) {
                    setRandomQuestion();
                } else {
                    failedLevel(v);
                }
            }
        });
    }

    private void ImageCheck() {
        if (LevelThreeCodeQuestion != null) {
            LevelThreeCodeQuestion.setBackgroundResource(0);
        }
    }

    private void TextCheck() {
        TextView LevelThreeQuestionText = (TextView) findViewById(R.id.LevelThreeQuestionText);
        if (LevelThreeQuestionText != null) {
            LevelThreeQuestionText.setText("");
        }
    }

    private void AddMultipleChoice() {
        if (ChoicesIsShown) {
            ChildFrameLayout.setVisibility(View.INVISIBLE);
            ChoicesIsShown = false;
        } else {

            ChildFrameLayout.setVisibility(View.VISIBLE);
            ChoicesIsShown = true;
            EditText answer = (EditText) findViewById(R.id.ANSWER_HERE_EDITTEXT);
            answer.setText("");
        }
    }
}

//    private void GetAnswer(View v) {
//        LevelThreeContainerCodeFragment codeFragment = new LevelThreeContainerCodeFragment();
//        codeFragment.onClick(v);
//    }

