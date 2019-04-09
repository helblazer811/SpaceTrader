package com.example.spacetrader;

import org.junit.Test;

import com.example.spacetrader.entities.Inventory;
import com.example.spacetrader.entities.tradegoods.TradeGood;
import com.example.spacetrader.*;
import static org.junit.Assert.*;
import java.util.HashMap;

public class M10TestsJoe {

    @Test
    public void countCheck() throws Exception {
        Inventory testInv = new Inventory(10);
        testInv.put(TradeGood.WATER,10);
        assertEquals(testInv.getCount(), 10);
    }

    @Test(expected = Exception.class)
    public void inventoryFullExceptionTest() throws Exception {
        Inventory testInv = new Inventory(10);
        testInv.put(TradeGood.WATER,11);
    }

    @Test(expected = Exception.class)
    public void nullTradeGoodExceptionCheck() throws Exception {
        Inventory testInv = new Inventory(10);
        testInv.put(null,1);
    }

    @Test(expected = Exception.class)
    public void negativeAmountExceptionCheck() throws Exception {
        Inventory testInv = new Inventory(10);
        testInv.put(TradeGood.WATER,-1);
    }

}
