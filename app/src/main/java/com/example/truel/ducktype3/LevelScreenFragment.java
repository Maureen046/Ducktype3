package com.example.truel.ducktype3;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import com.example.truel.ducktype3.Helper.General;
import com.example.truel.ducktype3.Level1.LevelOneIntroScreenFragment;
import com.example.truel.ducktype3.Level2.LevelTwoIntroScreenFragment;
import com.example.truel.ducktype3.Level3.LevelThreeIntroScreenFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LevelScreenFragment extends Fragment {
    public static final String TAG = LevelScreenFragment.class.getSimpleName();


    public LevelScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_level_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ImageButton button1 = (ImageButton) view.findViewById(R.id.btnlvl1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment LevelOne = new LevelOneIntroScreenFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.landing, LevelOne);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ImageButton button2 = (ImageButton) view.findViewById(R.id.btnlvl2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment LevelTwo = new LevelTwoIntroScreenFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.landing, LevelTwo);
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });

        ImageButton button3 = (ImageButton) view.findViewById(R.id.btnlvl3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment LevelThree = new LevelThreeIntroScreenFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.landing, LevelThree);
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });

    }
}







