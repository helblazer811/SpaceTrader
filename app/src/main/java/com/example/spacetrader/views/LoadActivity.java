package com.example.spacetrader.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.ActivityLoadBinding;
import com.example.spacetrader.databinding.ActivityPlayerConfigurationBinding;
import com.example.spacetrader.viewmodels.PlayerConfigurationViewModel;
import com.example.spacetrader.viewmodels.load.LoadAdapter;
import com.example.spacetrader.viewmodels.load.LoadViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class LoadActivity extends AppCompatActivity {

    LoadViewModel viewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        setupBindings(savedInstanceState);


        ListView listView = findViewById(R.id.load_list);
        listView.setAdapter(new LoadAdapter(this, viewModel.getPlayers()));
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
