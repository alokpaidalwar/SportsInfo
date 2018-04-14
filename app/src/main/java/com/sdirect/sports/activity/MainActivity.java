package com.sdirect.sports.activity;


import android.databinding.DataBindingUtil;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.kekstudio.dachshundtablayout.DachshundTabLayout;
import com.kekstudio.dachshundtablayout.indicators.DachshundIndicator;
import com.sdirect.sports.adapter.PagerAdapter;
import com.sdirect.sports.R;
import com.sdirect.sports.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       // setSupportActionBar(activityMainBinding.toolbar);
        activityMainBinding.viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        activityMainBinding.viewPager.setOffscreenPageLimit(4);
        activityMainBinding.tabLayout.setupWithViewPager(activityMainBinding.viewPager);
        activityMainBinding.tabLayout.setAnimatedIndicator(new DachshundIndicator(activityMainBinding.tabLayout));
    }

}
