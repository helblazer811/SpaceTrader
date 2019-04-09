package com.example.spacetrader;

import com.example.spacetrader.entities.Player;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for the isValidConfiguration method within the Player class.
 */
public class M10TestJustin {

    @Test
    public void highPointCount() {
        Player example = new Player();
        example.setEngineerPoints(4);
        example.setPilotPoints(4);
        example.setFighterPoints(4);
        example.setTraderPoints(5);
        assertFalse(example.isValidConfiguration(true));
        assertFalse(example.isValidConfiguration(false));
    }

    @Test
    public void lowPointCount() {
        Player example = new Player();
        example.setEngineerPoints(4);
        example.setPilotPoints(4);
        example.setFighterPoints(4);
        example.setTraderPoints(3);
        assertFalse(example.isValidConfiguration(true));
        assertFalse(example.isValidConfiguration(false));
    }

    @Test
    public void correctPointCount() {
        Player example = new Player();
        example.setEngineerPoints(4);
        example.setPilotPoints(4);
        example.setFighterPoints(4);
        example.setTraderPoints(4);
        assertTrue(example.isValidConfiguration(true));
        assertTrue(example.isValidConfiguration(false));
    }
}
