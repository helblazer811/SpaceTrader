package com.example.spacetrader.entities.event;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.views.maingame.event.PirateActivity;
import com.example.spacetrader.views.maingame.event.PoliceActivity;
import com.example.spacetrader.views.maingame.event.TraderActivity;

/**
 * Triggers whether or not trader appear for the player
 */
public class TraderEvent extends RandomEvent {
    /**
     * constructor for trader events
     * @param chance for event to occur
     * @param player player that event is happening to
     */
    public TraderEvent(float chance, Player player) {
        super(chance, TraderActivity.class, player);
    }

}
