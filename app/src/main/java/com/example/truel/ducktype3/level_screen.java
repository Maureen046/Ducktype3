package com.example.truel.ducktype3;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;


public class level_screen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTitleBar();
        setContentView(R.layout.activity_level_screen);

        ImageButton lvl1 = (ImageButton) findViewById(R.id.btnlvl1);
        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go2level1();
            }
        });

        ImageButton lvl2 = (ImageButton) findViewById(R.id.btnlvl2);
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go2level2();
            }
        });

        ImageButton lvl3 = (ImageButton) findViewById(R.id.btnlvl3);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go2level3();
            }
        });

        ImageButton lvl4 = (ImageButton) findViewById(R.id.btnlvl4);
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go2level4();
            }
        });

        ImageButton lvl5 = (ImageButton) findViewById(R.id.btnlvl5);
        lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go2level5();
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

    public void go2level1() {
        Intent a = new Intent(this, level_1.class);
        startActivity(a);
    }

    public void go2level2() {
        Intent a = new Intent(this, level_2.class);
        startActivity(a);
    }

    public void go2level3() {
        Intent a = new Intent(this, level_3.class);
        startActivity(a);
    }

    public void go2level4() {
        Intent a = new Intent(this, level_4.class);
        startActivity(a);
    }

    public void go2level5() {
        Intent a = new Intent(this, level_5.class);
        startActivity(a);
    }
}
