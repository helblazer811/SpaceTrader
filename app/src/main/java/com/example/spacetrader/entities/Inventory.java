package com.example.spacetrader.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;

import com.example.spacetrader.entities.tradegoods.TradeGood;

import java.util.HashMap;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity
public class Inventory extends BaseObservable {

    @PrimaryKey
    private long inventoryId;

    private HashMap<TradeGood, Integer> inventoryMap;
    private int capacity;
    private int count;

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

    public Inventory(long inventoryId, HashMap<TradeGood, Integer> inventoryMap, int capacity, int count) {
        this.inventoryId = inventoryId;
        this.inventoryMap = inventoryMap;
        this.capacity = capacity;
        this.count = count;
    }

    public void put(TradeGood type, int amount) {
        if (count + amount > capacity) {
            //throw an inventory full exception
        } else {
            count += amount;
            this.inventoryMap.put(type, amount);
        }
    }

    public HashMap<TradeGood, Integer> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(HashMap<TradeGood, Integer> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }
}
