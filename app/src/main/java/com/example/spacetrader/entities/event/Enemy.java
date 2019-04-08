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
     * @param currentHealth
     * @param maxHealth
     * @param damage
     */
    public Enemy(int currentHealth, int maxHealth, int damage) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.damage = damage;
    }

    /**
     *
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

    /**
     *
     * @return max health of enemy
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     *
     * @param maxHealth maximum health setter
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     *
     * @return damage variable
     */
    public int getDamage() {
        return damage;
    }

    /**
     *
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
     *
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
