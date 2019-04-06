package com.example.spacetrader.entities.event;

import com.example.spacetrader.entities.Player;

public class EventLoader {

    /**
     * determines the chance for the player to encounter a pirate
     * @param player the current player
     * @return chances of [irate attack
     */
    public static RandomEvent loadRandomEvent(Player player) {

        //performs event loading logic based on the players
        //stats and location

        //right now just returns a pirate random event
        return new PirateEvent(0.50f, player);//ten percent chance of happening
    }
}
