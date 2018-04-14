package com.sdirect.sports.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sdirect.sports.fragment.HomeFragment;
import com.sdirect.sports.fragment.ListFragment;
import com.sdirect.sports.fragment.ResultFragment;
import com.sdirect.sports.fragment.ScheduleFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private static final String TABS[] = {"News", "List", "Schedule", "Results"};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // returning current tabs using switch case
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ListFragment();
            case 2:
                return new ScheduleFragment();
            case 3:
                return new ResultFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TABS[position];
    }
}
