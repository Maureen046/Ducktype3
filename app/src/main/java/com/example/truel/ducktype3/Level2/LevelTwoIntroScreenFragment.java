package com.example.truel.ducktype3.Level2;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.truel.ducktype3.Level1.LevelOneIntroScreenFragment;
import com.example.truel.ducktype3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LevelTwoIntroScreenFragment extends Fragment {
    public static final String TAG = LevelTwoIntroScreenFragment.class.getSimpleName();
    ImageButton LevelTwoBegin;


    public LevelTwoIntroScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_level_two_intro_screen, container, false);
        LevelTwoBegin = (ImageButton) view.findViewById(R.id.LevelTwoBeginButton);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton button2 = (ImageButton) view.findViewById(R.id.LevelTwoBeginButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LevelTwoIntent = new Intent (getActivity(), LevelTwoContainer.class);
                startActivity(LevelTwoIntent);

            }
        });
    }


}
