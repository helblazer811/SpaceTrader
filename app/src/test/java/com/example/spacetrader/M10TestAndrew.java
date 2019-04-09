package com.example.spacetrader;
import com.example.spacetrader.entities.ship.Ship;
import com.example.spacetrader.entities.ship.ShipType;

import org.junit.Test;
import static org.junit.Assert.*;

public class M10TestAndrew {

    @Test
    public void testTakeDamage() {
        Ship s = new Ship(ShipType.FIREFLY);
        s.takeDamage(10);
        assertEquals("Ship health incorrectly updated", 90, s.getShipHealth());
        s.takeDamage(-5);
        assertEquals("Ship Health is not set to 0 if damage is negative", 0, s.getShipHealth());
    }
}