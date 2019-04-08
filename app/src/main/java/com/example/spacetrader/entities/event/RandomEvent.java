package com.example.spacetrader.entities.event;

import android.app.Application;
import android.content.Intent;

import com.example.spacetrader.entities.Player;

/**
 * Abstract class for random event
 */
public abstract class RandomEvent {

    private boolean happens;
    private boolean decided = false;
    private float chance;
    private Class eventActivityClass;
    private Player player;

    /**
     *  constructor for a random event
     * @param chance odds for random event
     * @param eventActivityClass activity class for the random event
     * @param player the player object
     */
    public RandomEvent(float chance, Class eventActivityClass, Player player) {
        this.chance = chance;
        this.eventActivityClass = eventActivityClass;
        this.player = player;
    }

    /**
     * getter or chance
     * @return chance value of random event
     */
    public float getChance() {
        return chance;
    }

    /**
     * setter for event
     * @param chance chance value of random event
     */
    public void setChance(float chance) {
        this.chance = chance;
    }

    /**
     * getter for player
     * @return player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * setter for player
     * @param player player object
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * method to determine the chance an event happening
     * @return whether or not the random event actually happens
     */
    public boolean happens() {
        if (decided == false) {
            this.happens = Math.random() < chance;
            return this.happens;
        }
        return this.happens;
    }

    /**
     * getter for eventActivityClass
     * @return event activity class
     */
    public Class getEventActivityClass() {
        return eventActivityClass;
    }

    /**
     * setter for event activity class
     * @param eventActivityClass
     */
    public void setEventActivityClass(Class eventActivityClass) {
        this.eventActivityClass = eventActivityClass;
    }

    /**
     * performs the event if the the chance allows
     * @param application the event happening in the game
     */
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
