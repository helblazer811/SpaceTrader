package com.example.spacetrader.entities;


import com.example.spacetrader.BR;
import com.example.spacetrader.entities.tradegoods.Purchase;
import com.example.spacetrader.entities.tradegoods.Sale;
import com.example.spacetrader.entities.tradegoods.TradeGood;

import java.util.HashMap;

import androidx.databinding.BaseObservable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Inventory holds an inventory map.
 */
@Entity
public class Inventory extends BaseObservable {

    @PrimaryKey
    private long inventoryId;

    private HashMap<TradeGood, Integer> inventoryMap;
    private int capacity;
    private int count;

    /**
     * Constructor for inventory
     * @param capacity the capacity of the inventory
     */
    @Ignore
    public Inventory(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.inventoryMap = new HashMap<>();

        inventoryMap.put(TradeGood.WATER,0);
        inventoryMap.put(TradeGood.FURS,0);
        inventoryMap.put(TradeGood.FOOD,0);
        inventoryMap.put(TradeGood.ORE,0);
        inventoryMap.put(TradeGood.GAMES,0);
        inventoryMap.put(TradeGood.FIREARMS,0);
        inventoryMap.put(TradeGood.MEDICINE,0);
        inventoryMap.put(TradeGood.MACHINES,0);
        inventoryMap.put(TradeGood.NARCOTICS,0);
        inventoryMap.put(TradeGood.ROBOTS,0);
    }

    /**
     * overloaded constructor
     * @param inventoryId the id of the inventory
     * @param inventoryMap the map item passed in
     * @param capacity the capacity of the inventory
     * @param count the number desired to be created
     */
    public Inventory(long inventoryId, HashMap<TradeGood, Integer> inventoryMap,
                     int capacity, int count) {
        this.inventoryId = inventoryId;
        this.inventoryMap = inventoryMap;
        this.capacity = capacity;
        this.count = count;
    }

    /**
     * the put method for an inventory
     * @param type type of trade good
     * @param amount the amount of the good
     */
    public void put(TradeGood type, int amount) {
        if ((count + amount) > capacity) {
            throw new Exception("The Inventory is full!");
        } else {
            count += amount;
            this.inventoryMap.put(type, amount);
        }
    }

    /**
     * getter for inventory backer
     * @return the inventory map
     */
    public HashMap<TradeGood, Integer> getInventoryMap() {
        notifyPropertyChanged(BR.validPurchase);
        return inventoryMap;
    }

    /**
     * a setter for the backing map
     * @param inventoryMap the map to be modded
     */
    public void setInventoryMap(HashMap<TradeGood, Integer> inventoryMap) {

        notifyPropertyChanged(BR.validPurchase);
        this.inventoryMap = inventoryMap;
    }

    /**
     * a getter for capacity
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * a setter for capacity
     * @param capacity the capacity desired
     */
    public void setCapacity(int capacity) {
        notifyPropertyChanged(BR.validPurchase);
        this.capacity = capacity;
    }

    /**
     * a getter for the count of backing maps
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * a setter for the count of backers
     * @param count the count
     */
    public void setCount(int count) {
        notifyPropertyChanged(BR.validPurchase);
        this.count = count;
    }

    /**
     * a getter for the inventory id
     * @return the id
     */
    public long getInventoryId() {
        return inventoryId;
    }

    /**
     * a setter for the id
     * @param inventoryId the id
     */
    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    /**
     * a method that applies the purchase effects to the inventory
     * @param purchase the purchase object
     */
    public void applyPurchase(Purchase purchase) {
        notifyPropertyChanged(BR.validPurchase);
        for (TradeGood good: purchase.getAmounts().keySet()) {
            inventoryMap.put(good, inventoryMap.get(good) + purchase.getAmounts().get(good));
            count += purchase.getAmounts().get(good);

        }
    }

    /**
     * a method that applies the sale effects to the inventory
     * @param sale the sale object
     */
    public void applySale(Sale sale) {
        notifyPropertyChanged(BR.validPurchase);
        for (TradeGood good: sale.getSaleAmounts().keySet()) {
            inventoryMap.put(good, inventoryMap.get(good) - sale.getSaleAmounts().get(good));
            count -= sale.getSaleAmounts().get(good);
        }
    }

    /**
     * a method to empty out the inventory
     */
    public void emptyInventory() {
        inventoryMap.put(TradeGood.WATER,0);
        inventoryMap.put(TradeGood.FURS,0);
        inventoryMap.put(TradeGood.FOOD,0);
        inventoryMap.put(TradeGood.ORE,0);
        inventoryMap.put(TradeGood.GAMES,0);
        inventoryMap.put(TradeGood.FIREARMS,0);
        inventoryMap.put(TradeGood.MEDICINE,0);
        inventoryMap.put(TradeGood.MACHINES,0);
        inventoryMap.put(TradeGood.NARCOTICS,0);
        inventoryMap.put(TradeGood.ROBOTS,0);
    }

}
