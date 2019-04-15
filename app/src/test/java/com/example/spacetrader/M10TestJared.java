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
        //amount must be a random number between 0 and 20
        Planet planet = new Planet("Uranus");
        TradeGood good = TradeGood.WATER;
        double actual = planet.calculateAmount(good);
        double expected =  Math.random() * 20;
        for (int i = 0; i < 1000; i++) {
            expected =  Math.random() * 20;
            assertEquals(expected > 0 && expected < 20, actual > 0 && actual < 20);
        }

        //test when goods tech level produce is bigger than the goods tech level
        good.setMinTechLevelProduce(1000);
        actual = planet.calculateAmount(good);
        //should be 0.0
        assertEquals(0.0, actual);


    }


}
