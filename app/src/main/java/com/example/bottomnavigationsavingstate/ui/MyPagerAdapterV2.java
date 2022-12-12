package com.example.bottomnavigationsavingstate.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class MyPagerAdapterV2 extends FragmentStateAdapter {

    Bundle bundle;
    ArrayList<Fragment> fragments;
    Fragment fragment;


    public MyPagerAdapterV2(
            Bundle bundle,
            ArrayList<Fragment> fragments,
            Fragment fragment
            ){
        super(fragment);

        this.bundle = bundle;
        this.fragments = fragments;
        this.fragment = fragment;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        fragments.get(position).setArguments(bundle);
        return fragments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }


}
