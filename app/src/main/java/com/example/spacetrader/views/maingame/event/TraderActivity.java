package com.example.spacetrader.views.maingame.event;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.ActivityTraderEventBinding;
import com.example.spacetrader.viewmodels.event.TraderViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class TraderActivity extends EventActivity {


    private TraderViewModel viewModel;

    /**
     * initializes the Police event
     * @param savedInstanceState the bundle containing the state
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_event);

        setupBindings(savedInstanceState);

        Button leave = findViewById(R.id.leave_event);

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button purchase = findViewById(R.id.purchase_event);

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.purchase();
                finish();
            }
        });

    }

    /**
     * sets up bindings for the event
     * @param savedInstanceState the bundle containing the state
     */
    private void setupBindings(Bundle savedInstanceState) {
        ActivityTraderEventBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_trader_event);

        //create view mode
        viewModel = ViewModelProviders.of(this).get(TraderViewModel.class);

        if (savedInstanceState == null) {
            viewModel.init(getIntent().getExtras().getLong("playerId"), this);
        }

        binding.setViewmodel(viewModel);

        binding.setLifecycleOwner(this);
    }

}
