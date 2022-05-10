package com.example.kinderenglishausbildung;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentPagerAdapter extends FragmentStateAdapter {
    List<Fragment> fragmentLis=new ArrayList<>();
    public MyFragmentPagerAdapter(@NonNull  FragmentManager fragmentManager, @NonNull  Lifecycle lifecycle,List<Fragment> fragments) {
        super(fragmentManager, lifecycle);
        fragmentLis=fragments;
    }

    @NonNull

    @Override
    public Fragment createFragment(int position) {
        return fragmentLis.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentLis.size();
    }
}
