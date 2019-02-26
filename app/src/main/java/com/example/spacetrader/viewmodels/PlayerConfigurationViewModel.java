package com.example.spacetrader.viewmodels;

import android.util.Log;

import com.example.spacetrader.models.Player;
import com.example.spacetrader.models.Universe;

import java.util.HashMap;

public class PlayerConfigurationViewModel {

    private Universe universe = new Universe();

    /*
        For now this initializes a connection between
     */
    public PlayerConfigurationViewModel() {

    }

    /*
        Handles the submission of the player configuration
     */
    public void onSubmit(HashMap<String, Object> configuration) throws Exception{

        if (isValidSkillset(configuration)) {
            // creates an instnace of player
            Player player = new Player(configuration);
            Log.i("New player created",player.toString());
        }
    }

    /*
        Calculates whether or not skillset adds up to 16
     */
    private boolean isValidSkillset(HashMap<String, Object> configuration) throws Exception{
        int sum = (int) configuration.get("engineer")
                + (int) configuration.get("pilot")
                + (int) configuration.get("trader")
                + (int) configuration.get("fighter");

        if (sum > 16) {
            throw new Exception("Too many points allocated");
        } else if (sum < 16) {
            throw new Exception("Not enough points allocated");
        }

        return sum == 16;
    }

}
