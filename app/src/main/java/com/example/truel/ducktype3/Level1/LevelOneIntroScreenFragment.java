package com.example.truel.ducktype3.Level1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.truel.ducktype3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LevelOneIntroScreenFragment extends Fragment {
    public static final String TAG = LevelOneIntroScreenFragment.class.getSimpleName();
    ImageButton LevelOneBegin;


    public LevelOneIntroScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_level_one_intro_screen, container, false);
        LevelOneBegin = (ImageButton) view.findViewById(R.id.LevelOneBeginButton);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton button1 = (ImageButton) view.findViewById(R.id.LevelOneBeginButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LevelOneIntent = new Intent(getActivity(), LevelOneContainerActivity.class);
                startActivity(LevelOneIntent);
            }
        });
    }


}
