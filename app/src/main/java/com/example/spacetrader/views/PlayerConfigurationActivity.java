package com.example.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.databinding.ActivityPlayerConfigurationBinding;
import com.example.spacetrader.entities.GameDifficulty;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.viewmodels.PlayerConfigurationViewModel;
import com.example.spacetrader.views.maingame.MainActivity;


public class PlayerConfigurationActivity extends AppCompatActivity {

    private PlayerConfigurationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBindings(savedInstanceState);
        setupSubmitButton();
        setupGameDifficultySpinner();
        setupCloseButton();

    }

    private void setupBindings(Bundle savedInstanceState) {
        ActivityPlayerConfigurationBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_player_configuration);

        //create view mode
        viewModel = ViewModelProviders.of(this).get(PlayerConfigurationViewModel.class);

        if (savedInstanceState == null) {
            viewModel.init();
        }

       binding.setViewmodel(viewModel);
    }

    private void setupSubmitButton() {
        viewModel.getSubmitButtonClick().observe(this, new Observer<Player>() {
            @Override
            public void onChanged(Player playerModel) {
                Toast.makeText(PlayerConfigurationActivity.this,
                        playerModel.toString(),
                        Toast.LENGTH_SHORT).show();
                //intent to go to next activity

                Intent myIntent = new Intent(
                                PlayerConfigurationActivity.this,
                                MainActivity.class
                    );

                System.out.println("Calling main activity intent");

                startActivity(myIntent);
            }
        });
    }
    private void setupGameDifficultySpinner(){
        AppCompatSpinner gameDifficultySpinner = (AppCompatSpinner) findViewById(R.id.game_difficulty_spinner);

        ArrayAdapter<GameDifficulty> gameDifficultySpinnerAdapter = new ArrayAdapter<GameDifficulty>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        gameDifficultySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(gameDifficultySpinnerAdapter);
    }


    private void setupCloseButton(){
        Button closeButton = (Button) findViewById(R.id.close);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

}
