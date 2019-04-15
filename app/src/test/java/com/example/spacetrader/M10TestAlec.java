package com.example.spacetrader;

import org.junit.Test;

import com.example.spacetrader.entities.event.Enemy;

import static org.junit.Assert.*;

public class M10TestAlec {


    @Test
    public void combinedTest() throws Exception {
        Enemy testEnemy = new Enemy(100, 100, 10);
        testEnemy.doDamage(50);
        assertEquals(testEnemy.getCurrentHealth(), 50);
        testEnemy.doDamage(49);
        assertEquals(testEnemy.getCurrentHealth(), 1);
        testEnemy.doDamage(2);
        assertEquals(testEnemy.getCurrentHealth(), 0);
    }
    @Test
    public void healthEdgeCase() throws Exception {
        Enemy testEnemy = new Enemy(100, 100, 10);
        testEnemy.doDamage(50);
        testEnemy.doDamage(100);
        assertEquals(testEnemy.getCurrentHealth(), 0);

    }


    @Test
    public void damageDealtCheck() throws Exception {
        Enemy testEnemy = new Enemy(100, 100, 10);
        testEnemy.doDamage(10);
        assertEquals(testEnemy.getCurrentHealth(), 90);
        testEnemy.doDamage(50);
        assertEquals(testEnemy.getCurrentHealth(), 40);
    }


}
