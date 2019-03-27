package com.example.spacetrader.entities.tradegoods;

import com.example.spacetrader.BR;

import java.util.HashMap;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Purchase extends BaseObservable {

    private HashMap<TradeGood, Integer> amounts;
    private HashMap<TradeGood, Double> prices;
    private HashMap<TradeGood, Integer> marketAvailability;
    private int fuel;
    private int maxFuel;

    private int availableSpace;
    private double availableCredits;

    public Purchase(int availableSpace, double availableCredits, int maxFuel) {
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
        System.out.println("Fuel  " + maxFuel);
        fuel = 0;
        this.maxFuel = maxFuel;
        
    }

    public double getPurchaseAmount() {
        double total = 0;
        for(TradeGood good: amounts.keySet()) {
            total += amounts.get(good) * prices.get(good);
        }

        return total + fuel * 2; // 2 is the price of fuel
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

        boolean lessThanAvailable = true;

        if (marketAvailability == null)
            return false;

        if (fuel > maxFuel)
            return false;

        for (TradeGood good: marketAvailability.keySet()) {
            lessThanAvailable = lessThanAvailable && (amounts.get(good) <= marketAvailability.get(good));
        }

        return getPurchaseAmount() <= availableCredits
                && getPurchaseCount() <= availableSpace
                && (getPurchaseCount()!=0 || fuel > 0 ) && lessThanAvailable;
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

    public HashMap<TradeGood, Integer> getMarketAvailability() {
        return marketAvailability;
    }

    public void setMarketAvailability(HashMap<TradeGood, Integer> marketAvailability) {
        this.marketAvailability = marketAvailability;
    }

    public void setAvailableCredits(double availableCredits) {
        this.availableCredits = availableCredits;
    }
}
