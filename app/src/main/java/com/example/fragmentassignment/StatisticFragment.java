package com.example.fragmentassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StatisticFragment extends Fragment {


    public StatisticFragment() {
        // Required empty public constructor
    }

    public static StatisticFragment newInstance(){
        return new StatisticFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_statistic, container, false);
        return rootview;
    }
}