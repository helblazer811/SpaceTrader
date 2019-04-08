package com.example.spacetrader.entities.event;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.views.maingame.event.PirateActivity;
import com.example.spacetrader.views.maingame.event.PoliceActivity;

/**
 * Triggers whether or not police appear for the player
 */
public class PoliceEvent extends RandomEvent {
    /**
     * constructor for police events
     * @param chance for event to occur
     * @param player player that event is happening to
     */
    public PoliceEvent(float chance, Player player) {
        super(chance, PoliceActivity.class, player);
    }

}
