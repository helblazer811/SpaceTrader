package com.example.spacetrader.entities.event;

import android.app.Application;
import android.content.Intent;

import com.example.spacetrader.entities.Player;

public abstract class RandomEvent {

    private boolean happens;
    private boolean decided = false;
    private float chance;
    private Class eventActivityClass;
    private Player player;

    public RandomEvent(float chance, Class eventActivityClass, Player player) {
        this.chance = chance;
        this.eventActivityClass = eventActivityClass;
        this.player = player;
    }

    public float getChance() {
        return chance;
    }

    public void setChance(float chance) {
        this.chance = chance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean happens() {
        if (decided == false) {
            this.happens = Math.random() < chance;
            return this.happens;
        }
        return this.happens;
    }

    public Class getEventActivityClass() {
        return eventActivityClass;
    }

    public void setEventActivityClass(Class eventActivityClass) {
        this.eventActivityClass = eventActivityClass;
    }

    public void perform(Application application) {
        if (happens()) {
            //performs the actual event
            //call intent to the event activity
            Intent intent = new Intent(application.getApplicationContext(), eventActivityClass);
            intent.putExtra("playerId", player.getPlayerId());

            application.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        } else {
            //do nothing
        }
    }



}
