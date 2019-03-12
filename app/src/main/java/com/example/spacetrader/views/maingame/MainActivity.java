package com.example.spacetrader.views.maingame;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.spacetrader.R;
import com.example.spacetrader.views.maingame.fragments.BuyFragment;
import com.example.spacetrader.views.maingame.fragments.InfoFragment;
import com.example.spacetrader.views.maingame.fragments.MapFragment;
import com.example.spacetrader.views.maingame.fragments.SellFragment;

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

        String playerId = getIntent().getExtras().getString("playerId");

        Bundle bundle = new Bundle();
        bundle.putString("playerId", playerId);

        adapter.addFragment(new MapFragment(), "Map");

        BuyFragment buyFragment = new BuyFragment();
        buyFragment.setArguments(bundle);
        adapter.addFragment(buyFragment, "Buy");

        adapter.addFragment(new SellFragment(), "Sell");
        adapter.addFragment(new InfoFragment(), "Info");
        viewPager.setAdapter(adapter);
    }
}
