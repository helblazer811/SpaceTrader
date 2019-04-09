package com.example.spacetrader.views.maingame.event;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.ActivityPirateEventBinding;
import com.example.spacetrader.viewmodels.event.PirateViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

/**
 * randomized pirate event during player transit
 */
public class PirateActivity extends EventActivity {

    private PirateViewModel viewModel;

    /**
     * initializes the pirate event
     * @param savedInstanceState the bundle containing the state
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pirate_event);

        setupBindings(savedInstanceState);

        Button evade = findViewById(R.id.evade_event);

        evade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button fight = findViewById(R.id.fight_event);

        fight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.fight();
                if (!viewModel.enemyIsAlive()) {
                    //end the fighting
                    finish();
                }
                //you lose all of your cargo if you die
                if (!viewModel.playerIsAlive()) {
                    //lose cargo
                    viewModel.emptyPlayerInventory();
                    //set health to half
                    viewModel.setPlayerHealthHalf();
                    finish();
                }

            }
        });

    }

    /**
     * sets up bindings for the event
     * @param savedInstanceState the bundle containing the state
     */
    private void setupBindings(Bundle savedInstanceState) {

        ActivityPirateEventBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_pirate_event);

        //create view mode
        viewModel = ViewModelProviders.of(this).get(PirateViewModel.class);

        if (savedInstanceState == null) {
            viewModel.init(getIntent().getExtras().getLong("playerId"), this);
        }

        binding.setViewmodel(viewModel);

        binding.setLifecycleOwner(this);
    }

}
