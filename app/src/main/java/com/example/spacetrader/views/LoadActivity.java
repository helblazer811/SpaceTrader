package com.example.spacetrader.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.ActivityLoadBinding;
import com.example.spacetrader.databinding.ActivityPlayerConfigurationBinding;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.viewmodels.PlayerConfigurationViewModel;
import com.example.spacetrader.viewmodels.load.LoadAdapter;
import com.example.spacetrader.viewmodels.load.LoadViewModel;
import com.example.spacetrader.views.maingame.MainActivity;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class LoadActivity extends AppCompatActivity {

    LoadViewModel viewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        setupBindings(savedInstanceState);

        LiveData<List<Player>> players = viewModel.getPlayers();
        final Activity owner = this;
        players.observe(this, new Observer<List<Player>>() {
            @Override
            public void onChanged(List<Player> players) {
                ListView listView = findViewById(R.id.load_list);
                Intent myIntent = new Intent(
                        LoadActivity.this,
                        MainActivity.class
                );

                listView.setAdapter(new LoadAdapter(owner, players, myIntent));
            }
        });

    }

    private void setupBindings(Bundle savedInstanceState) {
        ActivityLoadBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_load);

        //create view mode
        viewModel = ViewModelProviders.of(this).get(LoadViewModel.class);

        if (savedInstanceState == null) {
            viewModel.init(this);
        }

        binding.setViewmodel(viewModel);
    }

}
