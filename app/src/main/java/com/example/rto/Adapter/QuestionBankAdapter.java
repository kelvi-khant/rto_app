package com.example.rto.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.rto.Fragment.QuestionFragment;
import com.example.rto.Fragment.TrafficSignsFragment;
import com.example.rto.Model.QuestionBankModel;

import java.util.ArrayList;

public class QuestionBankAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;
    public QuestionBankAdapter(Context context,@NonNull FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;

    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                QuestionFragment questionFragment = new QuestionFragment();
                return questionFragment;
            case 1:
                TrafficSignsFragment trafficSignsFragment = new TrafficSignsFragment();
                return trafficSignsFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
