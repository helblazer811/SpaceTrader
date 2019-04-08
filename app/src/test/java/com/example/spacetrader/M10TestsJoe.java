package com.example.spacetrader;

import org.junit.Test;

import com.example.spacetrader.entities.Inventory;
import com.example.spacetrader.entities.tradegoods.TradeGood;
import com.example.spacetrader.*;
import static org.junit.Assert.*;
import java.util.HashMap;

public class M10TestsJoe {
//    private HashMap<TradeGood, Integer> aMap;

    @Test
    public void check_put() {
        Inventory testInv = new Inventory(10);
        testInv.put(TradeGood.WATER,1);
        testInv.put(TradeGood.FURS,1);
        testInv.put(TradeGood.FOOD,1);
        testInv.put(TradeGood.ORE,1);
        testInv.put(TradeGood.GAMES,1);
        testInv.put(TradeGood.FIREARMS,1);
        testInv.put(TradeGood.MEDICINE,1);
        testInv.put(TradeGood.MACHINES,1);
        testInv.put(TradeGood.NARCOTICS,1);
        testInv.put(TradeGood.ROBOTS,1);
        assertEquals(testInv.getCount(), 10);
    }
}
