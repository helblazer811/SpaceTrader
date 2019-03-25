package com.example.spacetrader.views.maingame;

import android.os.Bundle;

import com.example.spacetrader.R;
import com.example.spacetrader.views.maingame.fragments.BuyFragment;
import com.example.spacetrader.views.maingame.fragments.InfoFragment;
import com.example.spacetrader.views.maingame.fragments.MapFragment;
import com.example.spacetrader.views.maingame.fragments.SellFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SampleFragmentPagerAdapter adapter =
                new SampleFragmentPagerAdapter(getSupportFragmentManager());

        long playerId = getIntent().getExtras().getLong("playerId");
        Bundle bundle = new Bundle();
        bundle.putLong("playerId", playerId);

        adapter.addFragment(new MapFragment(), "Map");

        BuyFragment buyFragment = new BuyFragment();
        buyFragment.setArguments(bundle);
        adapter.addFragment(buyFragment, "Buy");

        SellFragment sellFragment = new SellFragment();
        sellFragment.setArguments(bundle);
        adapter.addFragment(sellFragment, "Sell");

        adapter.addFragment(new InfoFragment(), "Info");
        viewPager.setAdapter(adapter);
    }
}
