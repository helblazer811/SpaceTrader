package com.example.spacetrader.entities;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.spacetrader.BR;
import com.example.spacetrader.entities.tradegoods.TradeGood;

import java.util.HashMap;

public class Purchase extends BaseObservable {

    private HashMap<TradeGood, Integer> amounts;
    private HashMap<TradeGood, Double> prices;

    private int availableSpace;
    private double availableCredits;

    public Purchase(int availableSpace, double availableCredits) {
        this.availableSpace = availableSpace;
        this.availableCredits = availableCredits;
        amounts = new HashMap<>();
        
        amounts.put(TradeGood.WATER,0);
        amounts.put(TradeGood.FURS,0);
        amounts.put(TradeGood.FOOD,0);
        amounts.put(TradeGood.ORE,0);
        amounts.put(TradeGood.GAMES,0);
        amounts.put(TradeGood.FIREARMS,0);
        amounts.put(TradeGood.MEDICINE,0);
        amounts.put(TradeGood.MACHINES,0);
        amounts.put(TradeGood.NARCOTICS,0);
        amounts.put(TradeGood.ROBOTS,0);
        
        prices = new HashMap<>();

        prices.put(TradeGood.WATER,0.0);
        prices.put(TradeGood.FURS,0.0);
        prices.put(TradeGood.FOOD,0.0);
        prices.put(TradeGood.ORE,0.0);
        prices.put(TradeGood.GAMES,0.0);
        prices.put(TradeGood.FIREARMS,0.0);
        prices.put(TradeGood.MEDICINE,0.0);
        prices.put(TradeGood.MACHINES,0.0);
        prices.put(TradeGood.NARCOTICS,0.0);
        prices.put(TradeGood.ROBOTS,0.0);
        
    }

    public double getPurchaseAmount() {
        double total = 0;
        for(TradeGood good: amounts.keySet()) {
            total += amounts.get(good) * prices.get(good);
        }

        return total;
    }

    public int getPurchaseCount() {
        int total = 0;
        for(TradeGood good: amounts.keySet()) {
            total += amounts.get(good);
        }

        return total;
    }

    @Bindable
    public boolean isValidPurchase() {
        notifyPropertyChanged(BR.validPurchase);
        return getPurchaseAmount() <= availableCredits
                && getPurchaseCount() <= availableSpace
                && getPurchaseCount()!=0;
    }

    public HashMap<TradeGood, Integer> getAmounts() {
        return amounts;
    }

    public void setAmounts(HashMap<TradeGood, Integer> amounts) {
        this.amounts = amounts;
    }

    public HashMap<TradeGood, Double> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<TradeGood, Double> prices) {
        this.prices = prices;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }

    public double getAvailableCredits() {
        return availableCredits;
    }

    public void setAvailableCredits(int availableCredits) {
        this.availableCredits = availableCredits;
    }
}
