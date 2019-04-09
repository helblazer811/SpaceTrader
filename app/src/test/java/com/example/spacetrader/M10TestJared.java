package com.example.spacetrader;
import com.example.spacetrader.entities.planet.Planet;
import com.example.spacetrader.entities.tradegoods.TradeGood;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * JUnits for M10, covering the calculateAmount method in planet/planet
 */
public class M10TestJared {


    @Test
    public void calcAmount_isCorrect() {
        Planet planet = new Planet("Uranus");
        TradeGood good = TradeGood.WATER;
        double actual = planet.calculateAmount(good);
        double expected =  Math.random() * 20;
        System.out.println(good.getBasePrice());
        assertEquals(expected > 0 && expected < 20, actual);
    }


}
