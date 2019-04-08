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
        testInv.put(TradeGood.WATER,10);
        assertEquals(testInv.getCount(), 10);
        assertEquals(testInv.put(TradeGood.WATER,1), new Exception("The Inventory is full!"));
    }
}
