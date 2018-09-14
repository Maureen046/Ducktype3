package com.example.truel.ducktype3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, main_menu.class);
        startActivity(intent);
        finish();
    }
}
