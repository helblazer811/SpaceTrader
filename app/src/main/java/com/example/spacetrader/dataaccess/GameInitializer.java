package com.example.spacetrader.dataaccess;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.Universe;

import java.util.Map;

public class GameInitializer {
    /*
        This class is responsible for giving the
        player configuration view model starter objects
     */

    public Player initializePlayer(Map<String, Object> configuration) throws Exception{
        final PlayerInitializer playerInitializer = new PlayerInitializer();
        Player player = playerInitializer.initializePlayer(configuration);
        return player;
    }

    public Universe initializeUniverse() {
        Universe universe = new Universe();
        return universe;
    }
}
