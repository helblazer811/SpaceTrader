package com.example.spacetrader.entities.event;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.event.RandomEvent;
import com.example.spacetrader.views.maingame.event.PirateActivity;

/**
 * Pirate event class
 */
public class PirateEvent extends RandomEvent {
    /**
     * pirate event constructor
     * @param chance odds for event to occur
     * @param player event happens to this player
     */
    public PirateEvent(float chance, Player player) {
        super(chance, PirateActivity.class, player);
    }


}
