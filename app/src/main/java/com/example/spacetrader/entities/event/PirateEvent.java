package com.example.spacetrader.entities.event;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.event.RandomEvent;
import com.example.spacetrader.views.maingame.event.PirateActivity;

public class PirateEvent extends RandomEvent {

    public PirateEvent(float chance, Player player) {
        super(chance, PirateActivity.class, player);
    }


}
