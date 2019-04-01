package com.example.spacetrader.entities.event;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.views.maingame.event.PirateActivity;

public class PoliceEvent extends RandomEvent {

    public PoliceEvent(float chance, Player player) {
        super(chance, PoliceActivity.class, player);
    }

}
