package com.example.truel.ducktype3.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.truel.ducktype3.R;

public class General {
    private static final General ourInstance = new General();

    public static General getInstance() {
        return ourInstance;
    }

    private General() {

    }

    public static void replace(AppCompatActivity activity, Fragment fragment, String tag) {
        if (activity != null) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.landing, fragment, tag).addToBackStack(tag).commitAllowingStateLoss();
        }

    }

    public static void replaceTHREE(AppCompatActivity activity, Fragment fragment, String tag) {
        if (activity != null) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.LevelThreeCodeAnswerLanding, fragment, tag).addToBackStack(tag).commitAllowingStateLoss();
        }
    }

    public static void add(AppCompatActivity activity, Fragment fragment, String tag) {
        if (activity != null) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.landing, fragment, tag).addToBackStack(null).commitAllowingStateLoss();
        }

    }

}
