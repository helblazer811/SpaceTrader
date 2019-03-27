package com.example.spacetrader.entities.planet;

import android.util.Log;

import com.example.spacetrader.entities.tradegoods.TradeGood;

import java.util.HashMap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class Planet {

    @PrimaryKey(autoGenerate = true)
    private long planetId;

    private String planetName;
    private int xLoc;
    private int yLoc;
    private TechLevel techLevel;
    private ResourceType resourceType;
    private HashMap<TradeGood, Integer> planetInventory;
    private HashMap<TradeGood, Double> planetPrices;

    public Planet(long planetId, String planetName, int xLoc, int yLoc, TechLevel techLevel, ResourceType resourceType, HashMap<TradeGood, Integer> planetInventory, HashMap<TradeGood, Double> planetPrices) {
        this.planetId = planetId;
        this.planetName = planetName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.techLevel = techLevel;
        this.resourceType = resourceType;
        this.planetInventory = planetInventory;
        this.planetPrices = planetPrices;

        Log.i("Planet Information: ", this.toString());
    }

    /**
     * This constructor randomly generates everything but the name
     * @param planetName
     */
    @Ignore
    public Planet(String planetName) {
        this.planetName = planetName;
        this.xLoc = (int)(Math.random() * Universe.xRange);
        this.yLoc = (int)(Math.random() * Universe.yRange);
        this.techLevel = TechLevel.values()[(int)(Math.random() * TechLevel.numLevels)];
        this.resourceType = ResourceType.values()[(int)(Math.random() * ResourceType.numTypes)];

        planetPrices = calculatePrices();
        planetInventory = calculateAmounts();

        Log.i("Planet Information: ", this.toString());
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getXLoc() {
        return xLoc;
    }

    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public long getPlanetId() {
        return planetId;
    }

    public void setPlanetId(long planetId) {
        this.planetId = planetId;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public HashMap<TradeGood, Integer> getPlanetInventory() {
        return planetInventory;
    }

    public void setPlanetInventory(HashMap<TradeGood, Integer> planetInventory) {
        this.planetInventory = planetInventory;
    }

    public HashMap<TradeGood, Double> getPlanetPrices() {
        return planetPrices;
    }

    public void setPlanetPrices(HashMap<TradeGood, Double> planetPrices) {
        this.planetPrices = planetPrices;
    }

    private HashMap<TradeGood, Double> calculatePrices() {
        HashMap<TradeGood, Double> planetPrices = new HashMap<>();

        planetPrices.put(TradeGood.WATER,getPriceFromGood(TradeGood.WATER));
        planetPrices.put(TradeGood.FURS,getPriceFromGood(TradeGood.FURS));
        planetPrices.put(TradeGood.FOOD,getPriceFromGood(TradeGood.FOOD));
        planetPrices.put(TradeGood.ORE,getPriceFromGood(TradeGood.ORE));
        planetPrices.put(TradeGood.GAMES,getPriceFromGood(TradeGood.GAMES));
        planetPrices.put(TradeGood.FIREARMS,getPriceFromGood(TradeGood.FIREARMS));
        planetPrices.put(TradeGood.MEDICINE,getPriceFromGood(TradeGood.MACHINES));
        planetPrices.put(TradeGood.MACHINES,getPriceFromGood(TradeGood.MACHINES));
        planetPrices.put(TradeGood.NARCOTICS,getPriceFromGood(TradeGood.NARCOTICS));
        planetPrices.put(TradeGood.ROBOTS,getPriceFromGood(TradeGood.ROBOTS));

        return planetPrices;
    }

    private HashMap<TradeGood, Integer> calculateAmounts() {
        HashMap<TradeGood, Integer> planetInventory = new HashMap<>();

        planetInventory.put(TradeGood.WATER, calculateAmount(TradeGood.WATER));
        planetInventory.put(TradeGood.FURS,calculateAmount(TradeGood.FURS));
        planetInventory.put(TradeGood.FOOD,calculateAmount(TradeGood.FOOD));
        planetInventory.put(TradeGood.ORE,calculateAmount(TradeGood.ORE));
        planetInventory.put(TradeGood.GAMES,calculateAmount(TradeGood.GAMES));
        planetInventory.put(TradeGood.FIREARMS,calculateAmount(TradeGood.FIREARMS));
        planetInventory.put(TradeGood.MEDICINE,calculateAmount(TradeGood.MEDICINE));
        planetInventory.put(TradeGood.MACHINES,calculateAmount(TradeGood.MACHINES));
        planetInventory.put(TradeGood.NARCOTICS,calculateAmount(TradeGood.NARCOTICS));
        planetInventory.put(TradeGood.ROBOTS,calculateAmount(TradeGood.ROBOTS));

        return planetInventory;
    }

    private int calculateAmount(TradeGood good) {
        if (good.minTechLevelProduce > techLevel.getCode())
            return 0;
        return (int) (Math.random() * 20);
    }

    private double getPriceFromGood(TradeGood good) {
        if (good.minTechLevelProduce > techLevel.getCode())
            return 0.0;
        return good.basePrice + (good.increacePerTechLevel * (techLevel.getCode() - good.minTechLevelProduce)) + good.variance;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + planetName + '\'' +
                ", xLoc=" + xLoc +
                ", yLoc=" + yLoc +
                ", techLevel=" + techLevel +
                ", resourceType=" + resourceType +
                '}';
    }


}
