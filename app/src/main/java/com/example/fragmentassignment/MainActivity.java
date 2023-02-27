package com.example.fragmentassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTitle;
    private Boolean isFragmentDisplayedStatistic = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.view_button);
        mTitle = findViewById(R.id.title_child);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentDisplayedStatistic){
                    closeProfileFragment();
                    displayStatisticFragmet();
                }
                else {
                    closeStatisticFragment();
                    displayProfileFragment();
                }
            }
        });
    }

    public void displayProfileFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ProfileFragment profileFragment = ProfileFragment.newInstance();
        fragmentTransaction.add(R.id.fragment, profileFragment).addToBackStack(null).commit();
        isFragmentDisplayedStatistic = false;
        mButton.setText(R.string.button1);
        mTitle.setText(R.string.child1);
    }

    public void closeStatisticFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        StatisticFragment statisticFragment = (StatisticFragment) fragmentManager.findFragmentById(R.id.fragment_statistic);
        if (statisticFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(statisticFragment).commit();
        }
        isFragmentDisplayedStatistic = false;
    }

    public void displayStatisticFragmet() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StatisticFragment statisticFragment = StatisticFragment.newInstance();
        fragmentTransaction.add(R.id.fragment_statistic, statisticFragment).addToBackStack(null).commit();
        isFragmentDisplayedStatistic = true;
    }

    public void closeProfileFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ProfileFragment profileFragment = (ProfileFragment) fragmentManager.findFragmentById(R.id.fragment);
        if (profileFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(profileFragment).commit();
        }
        isFragmentDisplayedStatistic = true;
        mButton.setText(R.string.button2);
        mTitle.setText(R.string.child2);
    }
}