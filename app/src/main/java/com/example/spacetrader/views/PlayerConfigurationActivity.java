package com.example.spacetrader.views;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.entities.GameDifficulty;
import com.example.spacetrader.viewmodels.PlayerConfigurationViewModel;
import com.example.spacetrader.views.maingame.MainActivity;

import java.util.HashMap;
import java.util.Map;

public class PlayerConfigurationActivity extends AppCompatActivity {

    private PlayerConfigurationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_configuration);


        //create view mode
        viewModel = ViewModelProviders.of(this).get(PlayerConfigurationViewModel.class);

        //difficulty spinner
        final Spinner gameDifficultySpinner = defineGameDifficultySpinner();

        final EditText nameString =  ((EditText) findViewById(R.id.nameString));
        final EditText pilotPoints = ((EditText) findViewById(R.id.pilot_number));
        final EditText fighterPoints = ((EditText) findViewById(R.id.fighter_number));
        final EditText engineerPoints = ((EditText) findViewById(R.id.engineer_number));
        final EditText traderPoints = ((EditText) findViewById(R.id.trader_number));

        Button submit = (Button) findViewById(R.id.submit_button);

        defineCloseButton();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> configuration = new HashMap<String, Object>();
                //get all of the data from the forms
                configuration.put("name", nameString.getText().toString());
                configuration.put("game_difficulty", gameDifficultySpinner.getSelectedItem());
                configuration.put("pilot", Integer.parseInt(pilotPoints.getText().toString()));
                configuration.put("fighter", Integer.parseInt(fighterPoints.getText().toString()) );
                configuration.put("trader", Integer.parseInt(traderPoints.getText().toString()));
                configuration.put("engineer", Integer.parseInt(engineerPoints.getText().toString()));

                try {
                    viewModel.onSubmit(configuration);

                    Intent myIntent =
                            new Intent(
                                    PlayerConfigurationActivity.this,
                                    MainActivity.class
                            );
                    System.out.println("Calling main activity intent");

                    startActivity(myIntent);

                } catch (Exception e) {
                    e.printStackTrace();
                    displayExceptionMessage(e.getMessage());
                }
            }
        });
    }

    private void displayExceptionMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void defineCloseButton(){
        Button btn1 = (Button) findViewById(R.id.close);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
    }

    private Spinner defineGameDifficultySpinner(){
        Spinner gameDifficultySpinner = (Spinner) findViewById(R.id.game_difficulty_spinner);

        ArrayAdapter<GameDifficulty> gameDifficultySpinnerAdapter = new ArrayAdapter<GameDifficulty>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        gameDifficultySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(gameDifficultySpinnerAdapter);

        return gameDifficultySpinner;
    }


}
