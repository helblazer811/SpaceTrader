package com.example.spacetrader.entities.event;

import androidx.room.Entity;

@Entity
public class Enemy {

    private int currentHealth;
    private int maxHealth;
    private int damage;

    public Enemy() {
        currentHealth = 100;
        maxHealth = 100;
        damage = 10;
    }

    public Enemy(int currentHealth, int maxHealth, int damage) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.damage = damage;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
