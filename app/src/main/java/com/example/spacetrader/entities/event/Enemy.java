package com.example.spacetrader.entities.event;

import androidx.room.Entity;

@Entity
public class Enemy {

    private int currentHealth;
    private int maxHealth;
    private int damage;

    /**
     * default constructor for enemy object
     */
    public Enemy() {
        currentHealth = 100;
        maxHealth = 100;
        damage = 10;
    }

    /**
     * Enemy constructor with values given
     * @param currentHealth the current amount of health you have
     * @param maxHealth the max amount of health you have
     * @param damage damage taken
     */
    public Enemy(int currentHealth, int maxHealth, int damage) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.damage = damage;
    }

    /**
     * getter for current health
     * @return current health of the enemy
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * modifies current health of enemy
     * @param currentHealth to set to the value of current health
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /** getter for max health
     *
     * @return max health of enemy
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     *  max health setter
     * @param maxHealth maximum health setter
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * damage getter
     * @return damage variable
     */
    public int getDamage() {
        return damage;
    }

    /**
     * damage setter
     * @param damage to be set to the damage variable
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * does damage to the player based on an algorithm
     * @param damage input for the enemy
     */
    public void doDamage(int damage) {
        this.currentHealth -= damage;
        if (this.currentHealth < 0)
            this.currentHealth = 0;
    }

    /**
     * returns true if enemys health if greater than 0, false otherwise
     * @return if the enemy is dead or not
     */
    public boolean isAlive() {
        return this.currentHealth > 0;
    }

    /**
     * resets health to the full value
     */
    public void resetHealth() {
        currentHealth = maxHealth;
    }
}
