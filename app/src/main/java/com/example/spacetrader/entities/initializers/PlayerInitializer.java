package com.example.spacetrader.entities.initializers;

import android.util.Log;

import com.example.spacetrader.entities.Player;

import java.util.Map;

public class PlayerInitializer {

    public PlayerInitializer(){

    }

    public Player initializePlayer(Map<String, Object> configuration) throws Exception {
        Player player;
        if (isValidSkillset(configuration)) {
            // creates an instnace of player
            player = new Player(configuration);
            Log.i("New player created",player.toString());
        } else {
            player = new Player();
        }

        return player;
    }

    /*
       Calculates whether or not skillset adds up to 16
    */
    private boolean isValidSkillset(Map<String, Object> configuration) throws Exception{
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
