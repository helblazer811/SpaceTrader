package com.example.spacetrader.entities.event;

import com.example.spacetrader.entities.Player;

import androidx.room.Entity;
import androidx.room.Ignore;

@Entity
public class Enemy {

    private int maxHealth;
    private int currentHealth;
    private int damage;
    private int speed;

    public Enemy(int maxHealth, int currentHealth, int damage, int speed) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.damage = damage;
        this.speed = speed;
    }

    @Ignore
    public Enemy(){
        //generates default pirate
        this(100,100,10,10);
        //will impliment speed later
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if (this.currentHealth < 0)
            this.currentHealth = 0;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - damage);
    }

    public boolean flee(Player player) {
        //returns whether or not flee will work.
        //50 percent chance at first
        return Math.random() > 0.5;
    }
}
