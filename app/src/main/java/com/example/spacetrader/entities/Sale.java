package com.example.spacetrader.entities;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.spacetrader.BR;
import com.example.spacetrader.entities.tradegoods.TradeGood;

import java.util.HashMap;

public class Sale extends BaseObservable {
    private HashMap<TradeGood, Integer> saleAmounts;
    private HashMap<TradeGood, Integer> playerAmounts;

    private HashMap<TradeGood, Double> prices;

    public Sale() {
        prices = new HashMap<>();


        prices.put(TradeGood.WATER, 0.0);
        prices.put(TradeGood.FURS, 0.0);
        prices.put(TradeGood.FOOD, 0.0);
        prices.put(TradeGood.ORE, 0.0);
        prices.put(TradeGood.GAMES, 0.0);
        prices.put(TradeGood.FIREARMS, 0.0);
        prices.put(TradeGood.MEDICINE, 0.0);
        prices.put(TradeGood.MACHINES, 0.0);
        prices.put(TradeGood.NARCOTICS, 0.0);
        prices.put(TradeGood.ROBOTS, 0.0);

        saleAmounts = new HashMap<>();

        saleAmounts.put(TradeGood.WATER, 0);
        saleAmounts.put(TradeGood.FURS, 0);
        saleAmounts.put(TradeGood.FOOD, 0);
        saleAmounts.put(TradeGood.ORE, 0);
        saleAmounts.put(TradeGood.GAMES, 0);
        saleAmounts.put(TradeGood.FIREARMS, 0);
        saleAmounts.put(TradeGood.MEDICINE, 0);
        saleAmounts.put(TradeGood.MACHINES, 0);
        saleAmounts.put(TradeGood.NARCOTICS, 0);
        saleAmounts.put(TradeGood.ROBOTS, 0);

        playerAmounts = new HashMap<>();

        playerAmounts.put(TradeGood.WATER, 0);
        playerAmounts.put(TradeGood.FURS, 0);
        playerAmounts.put(TradeGood.FOOD, 0);
        playerAmounts.put(TradeGood.ORE, 0);
        playerAmounts.put(TradeGood.GAMES, 0);
        playerAmounts.put(TradeGood.FIREARMS, 0);
        playerAmounts.put(TradeGood.MEDICINE, 0);
        playerAmounts.put(TradeGood.MACHINES, 0);
        playerAmounts.put(TradeGood.NARCOTICS, 0);
        playerAmounts.put(TradeGood.ROBOTS, 0);

    }

    @Bindable
    public boolean isValidSale() {
        notifyPropertyChanged(BR.validSale);
        for (TradeGood good: saleAmounts.keySet())  {
            if (saleAmounts.get(good) > playerAmounts.get(good))
                return false;
        }
        return true;
    }

    public HashMap<TradeGood, Integer> getSaleAmounts() {
        return saleAmounts;
    }

    public void setSaleAmounts(HashMap<TradeGood, Integer> saleAmounts) {
        this.saleAmounts = saleAmounts;
    }

    public HashMap<TradeGood, Integer> getPlayerAmounts() {
        return playerAmounts;
    }

    public void setPlayerAmounts(HashMap<TradeGood, Integer> playerAmounts) {
        this.playerAmounts = playerAmounts;
    }

    public double getSaleAmount() {
        double amount = 0.0;
        for (TradeGood good: playerAmounts.keySet()) {
            amount += saleAmounts.get(good) * prices.get(good);
        }
        return amount;
    }

    public HashMap<TradeGood, Double> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<TradeGood, Double> prices) {
        this.prices = prices;
    }
}

