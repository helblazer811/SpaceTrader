package com.example.spacetrader.entities.planet;

import android.util.Log;

import com.example.spacetrader.entities.tradegoods.TradeGood;

import java.util.HashMap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Represents Planet in Space Trader
 */
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

    /**
     * Main constructor that creates Planet object
     * @param planetId Planet's unique number id
     * @param planetName name of Planet
     * @param xLoc x coordinate of Planet
     * @param yLoc y coordinate of Planet
     * @param techLevel the technology level of the Planet
     * @param resourceType the
     * @param planetInventory the inventory of  trade goods of the Planet
     * @param planetPrices the prices of the trade goods on this Planet
     */
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
     * This constructor randomly generates everything but the name for the Planet
     * @param planetName name of the Planet
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

    /**
     * Gets Planet name
     * @return name of the Planet
     */
    public String getPlanetName() {
        return planetName;
    }

    /**
     * Sets Planet name
     * @param planetName name of the Planet
     */
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    /**
     * Gets X coordinate of Planet
     * @return X coordinate of Planet
     */
    public int getXLoc() {
        return xLoc;
    }

    /**
     * Sets X coordinate of Planet
     * @param xLoc X coordinate of Planet
     */
    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    /**
     * Gets Y coordinate of Planet
     * @return Y coordinate of Planet
     */
    public int getYLoc() {
        return yLoc;
    }

    /**
     * Sets Y coordinate of Planet
     * @param yLoc Y coordinate of Planet
     */
    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    /**
     * Gets Tech Level
     * @return Tech Level
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Sets Tech Level
     * @param techLevel Tech Level of the Planet
     */
    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * Get Resource Type of the Planet
     * @return Resource Type
     */
    public ResourceType getResourceType() {
        return resourceType;
    }

    /**
     * Set Resource Type of the Planet
     * @param resourceType Resource Type of the Planet
     */
    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * Get Planet Id of Planet
     * @return Planet Id
     */
    public long getPlanetId() {
        return planetId;
    }

    /**
     * Set Planet Id of Planet
     * @param planetId Planet Id of Planet
     */
    public void setPlanetId(long planetId) {
        this.planetId = planetId;
    }

    /**
     * Gets Planet Inventory of Trade Goods of Planet
     * @return Planet Inventory
     */
    public HashMap<TradeGood, Integer> getPlanetInventory() {
        return planetInventory;
    }

    /**
     * Sets Planet Inventory of Trade Goods of Planet
     * @param planetInventory Planet Inventory
     */
    public void setPlanetInventory(HashMap<TradeGood, Integer> planetInventory) {
        this.planetInventory = planetInventory;
    }

    /**
     * Gets Planet prices of Trade Goods
     * @return Planet prices
     */
    public HashMap<TradeGood, Double> getPlanetPrices() {
        return planetPrices;
    }

    /**
     * Sets Planet prices of Trade Goods
     * @param planetPrices Planet prices
     */
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

    public int calculateAmount(TradeGood good) {
        if (good.minTechLevelProduce > techLevel.getCode())
            return 0;
        return (int) (Math.random() * 20);
    }

    private double getPriceFromGood(TradeGood good) {
        if (good.minTechLevelProduce > techLevel.getCode())
            return 0.0;
        double  price = good.basePrice + (good.increasePerTechLevel * (techLevel.getCode() - good.minTechLevelProduce)) + good.variance;
        return  price > 0 ? price : 0;
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
