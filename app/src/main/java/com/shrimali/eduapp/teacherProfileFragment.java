package com.shrimali.eduapp;

/*
   @author: IT19024882 | Shrimali Senevirathna | SLIIT
   Firebase configuration class with initial firebase functions
*/


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class teacherProfileFragment extends Fragment {

    public teacherProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_profile, container, false);
    }
}