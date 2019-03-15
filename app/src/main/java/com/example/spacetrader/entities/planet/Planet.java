package com.example.spacetrader.entities.planet;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.tradegoods.TradeGood;

import java.util.HashMap;

import static android.arch.persistence.room.ForeignKey.CASCADE;

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

        planetInventory = new HashMap<>();
        planetPrices = new HashMap<>();

        planetInventory.put(TradeGood.WATER,0);
        planetInventory.put(TradeGood.FURS,0);
        planetInventory.put(TradeGood.FOOD,0);
        planetInventory.put(TradeGood.ORE,0);
        planetInventory.put(TradeGood.GAMES,0);
        planetInventory.put(TradeGood.FIREARMS,0);
        planetInventory.put(TradeGood.MEDICINE,0);
        planetInventory.put(TradeGood.MACHINES,0);
        planetInventory.put(TradeGood.NARCOTICS,0);
        planetInventory.put(TradeGood.ROBOTS,0);

        calculatePrices();

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

    private void calculatePrices() {

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
    }

    private double getPriceFromGood(TradeGood good) {
        return good.basePrice + (good.increacePerTechLevel * (good.techLevelMost - good.minTechLevelProduce)) + good.variance;
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
