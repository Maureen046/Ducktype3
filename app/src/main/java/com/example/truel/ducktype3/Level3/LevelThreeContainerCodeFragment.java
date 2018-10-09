package com.example.truel.ducktype3.Level3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.truel.ducktype3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LevelThreeContainerCodeFragment extends Fragment {
    public static final String TAG = LevelThreeContainerCodeFragment.class.getSimpleName();

    public LevelThreeContainerCodeFragment() {
        // Required empty public constructor
    }

//    interface Listener {
//        public void
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_level_three_container_code, container, false);
        return view;
    }


}
