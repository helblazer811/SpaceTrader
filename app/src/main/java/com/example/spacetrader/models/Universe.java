package com.example.spacetrader.models;

import com.example.spacetrader.models.planet.Planet;

import java.util.ArrayList;

public class Universe {
    public static final Planet[] planets = generatePlanets();

    public static final int xRange = 30;
    public static final int yRange = 30;
    public static final int numPlanets = 10;

    private static Planet[] generatePlanets() {
        ArrayList<Integer> xLocs = new ArrayList<Integer>(numPlanets);
        ArrayList<Integer> yLocs = new ArrayList<Integer>(numPlanets);

        String [] names = {
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

        ArrayList<Planet> planets = new ArrayList<>(numPlanets);

        for (String name: names) {
            Planet planet = new Planet(name);
            while(xLocs.contains(planet.getxLoc())
                    && yLocs.contains(planet.getyLoc())) {
                planet = new Planet(name);
            }
            xLocs.add(planet.getxLoc());
            yLocs.add(planet.getyLoc());

            planets.add(planet);
        }

        return (Planet[]) planets.toArray();

    }
}
