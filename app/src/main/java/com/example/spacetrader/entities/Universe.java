package com.example.spacetrader.entities;

import android.util.Log;

import com.example.spacetrader.entities.planet.Planet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Universe {

    private static final String [] planetNames = {
            "Atlas",
            "Seneca",
            "Ezio",
            "Cronus",
            "Vulcan",
            "Plato",
            "Socrates",
            "Aristotle",
            "Pulomatis",
            "Gratis"
    };

    public static final List<Planet> planets = generatePlanets();

    public static final int xRange = 30;
    public static final int yRange = 30;
    public static final int numPlanets = planetNames.length;

    /*
        Generates a unique set of planets
     */
    private static List<Planet> generatePlanets() {
        Set<Integer> xLocs = new HashSet<Integer>(numPlanets);
        Set<Integer> yLocs = new HashSet<Integer>(numPlanets);
        List<Planet> planets = new ArrayList<>(numPlanets);

        for (String name: planetNames) {
            Planet planet = new Planet(name);
            //recreates the planet until it is at a unique location
            while(xLocs.contains(planet.getxLoc())
                    && yLocs.contains(planet.getyLoc())) {
                planet = new Planet(name);
            }
            xLocs.add(planet.getxLoc());
            yLocs.add(planet.getyLoc());

            //saves created planet to LogCat
            Log.i("Planet object created: ", planet.toString());
            planets.add(planet);
        }

        return planets;

    }
}
