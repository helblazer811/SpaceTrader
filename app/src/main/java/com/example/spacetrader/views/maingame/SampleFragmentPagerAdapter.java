package com.example.spacetrader.views.maingame;


import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * adapts the view fragments to the viewpager
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    /**
     * initialize the adapter given a group of fragments
     * @param manager the group of fragments
     */
    public SampleFragmentPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    /**
     * returns the fragment at a given position
     * @param position the position of the target fragment
     * @return the fragment at the given position
     */
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    /**
     * get number of fragments
     * @return number of fragments
     */
    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    /**
     * add a fragment to the list of fragments
     * @param fragment the fragment to add
     * @param title the title for the fragment
     */
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    /**
     * gets the title for a given fragment
     * @param position the position of the target fragment
     * @return the title of the fragment as a CharSequence
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}