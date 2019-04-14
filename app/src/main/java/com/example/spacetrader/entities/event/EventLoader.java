package com.example.spacetrader.entities.event;

import com.example.spacetrader.entities.Player;

/**
 * Event loader class, loads events for the player
 */
public class EventLoader {

    /**
     * determines the chance for the player to encounter a pirate
     * @param player the current player
     * @return chances of [irate attack
     */
    public static RandomEvent loadRandomEvent(Player player) {

        RandomEvent [] events = {
                new PirateEvent(0.50f, player),
                new PoliceEvent(0.50f, player),
                new TraderEvent(0.50f, player)
        };

        int choice = (int) (Math.random() * events.length);
        //performs event loading logic based on the players
        //stats and location
        return events[choice];
    }
}
