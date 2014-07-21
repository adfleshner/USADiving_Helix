package com.aaronfleshner.usadivinghelix.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.aaronfleshner.usadivinghelix.Divers;
import com.aaronfleshner.usadivinghelix.R;
import com.aaronfleshner.usadivinghelix.fragments.ProfileFragment;
import com.aaronfleshner.usadivinghelix.models.DtoDiver;
import com.aaronfleshner.usadivinghelix.transformers.DepthPageTransformer;

import java.util.ArrayList;


public class ProfileActivity extends FragmentActivity {
    private static final String DIVERS = "Divers";
    private static final String POSITION = "Position";
    ViewPager mPager;
    MyPagerAdapter mPagerAdapter;
    ArrayList<DtoDiver> divers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Divers d = new Divers(this);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(3);
        if (savedInstanceState == null) {
            divers = d.getDivers();
            mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
            mPager.setAdapter(mPagerAdapter);
        }else{
            divers = savedInstanceState.getParcelableArrayList(DIVERS);
            mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
            mPager.setAdapter(mPagerAdapter);
            mPager.setCurrentItem(savedInstanceState.getInt(POSITION));
        }
        mPager.setPageTransformer(true, new DepthPageTransformer());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(DIVERS,divers);
        outState.putInt(POSITION, mPager.getCurrentItem());
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ProfileFragment.fragmentInstance(divers.get(position));
        }

        @Override
        public int getCount() {
            return divers.size();
        }
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
}
