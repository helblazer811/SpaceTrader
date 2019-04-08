package com.example.spacetrader.entities.ship;

import com.example.spacetrader.entities.planet.Planet;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

public class Ship extends BaseObservable {

    @PrimaryKey
    long shipId;

    int cargoLimit;
    int shipHealth;
    int shipMaxHealth;
    int fuel;
    int maxFuel;

    public Ship(long shipId, int cargoLimit, int shipHealth, int shipMaxHealth, int fuel, int maxFuel) {
        this.shipId = shipId;
        this.cargoLimit = cargoLimit;
        this.shipHealth = shipHealth;
        this.shipMaxHealth = shipMaxHealth;
        this.fuel = fuel;
        this.maxFuel = maxFuel;
    }

    @Ignore
    public Ship(ShipType type) {
        this.cargoLimit = type.cargoLimit;
        this.shipHealth = type.shipHealth;
        this.shipMaxHealth = type.shipMaxHealth;
        this.fuel = type.fuel;
        this.maxFuel = type.maxFuel;
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }

    public int getCargoLimit() {
        return cargoLimit;
    }

    public void setCargoLimit(int cargoLimit) {
        this.cargoLimit = cargoLimit;
    }

    public int getShipHealth() {
        return shipHealth;
    }

    public void setShipHealth(int shipHealth) {
        this.shipHealth = shipHealth;
    }

    public int getShipMaxHealth() {
        return shipMaxHealth;
    }

    public void setShipMaxHealth(int shipMaxHealth) {
        this.shipMaxHealth = shipMaxHealth;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    public boolean isAlive() {
        return shipHealth > 0;
    }

    public void takeDamage(int damage) {
        shipHealth -= damage;
        if (damage < 0)
            shipHealth = 0;
    }

    public void setHealthHalf() {
        shipHealth = shipMaxHealth/2;
    }
}
