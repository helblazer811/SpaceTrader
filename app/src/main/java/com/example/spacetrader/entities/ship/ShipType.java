package com.example.spacetrader.entities.ship;

public enum ShipType {
    FIREFLY(10,0,100,200,200);

    public int cargoLimit;
    public int shipHealth;
    public int shipMaxHealth;
    public int fuel;
    public int maxFuel;

    ShipType(int cargoLimit, int shipHealth, int shipMaxHealth, int fuel, int maxFuel) {
        this.cargoLimit = cargoLimit;
        this.shipHealth = shipHealth;
        this.shipMaxHealth = shipMaxHealth;
        this.fuel = fuel;
        this.maxFuel = maxFuel;
    }


}
