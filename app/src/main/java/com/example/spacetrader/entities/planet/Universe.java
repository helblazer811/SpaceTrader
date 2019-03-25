package com.example.spacetrader.entities.planet;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.databinding.BaseObservable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Universe extends BaseObservable {

    @Ignore
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

    @PrimaryKey(autoGenerate = true)
    private long universeId;

    private List<Planet> planets = generatePlanets();

    @Ignore
    public static final int xRange = 30;
    @Ignore
    public static final int yRange = 30;
    @Ignore
    public static final int numPlanets = planetNames.length;

    @Ignore
    public Universe() {
        generatePlanets();
    }

    public Universe(long universeId, List<Planet> planets) {
        this.universeId = universeId;
        this.planets = planets;
    }

    public long getUniverseId() {
        return universeId;
    }

    public void setUniverseId(long universeId) {
        this.universeId = universeId;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    /*
            Generates a unique set of planets
         */
    private List<Planet> generatePlanets() {
        Set<Integer> xLocs = new HashSet<Integer>(numPlanets);
        Set<Integer> yLocs = new HashSet<Integer>(numPlanets);
        List<Planet> planets = new ArrayList<>(numPlanets);

        for (String name: planetNames) {
            Planet planet = new Planet(name);
            //recreates the planet until it is at a unique location
            while(xLocs.contains(planet.getXLoc())
                    && yLocs.contains(planet.getYLoc())) {
                planet = new Planet(name);
            }
            xLocs.add(planet.getXLoc());
            yLocs.add(planet.getYLoc());

            //saves created planet to LogCat
            Log.i("Planet object created: ", planet.toString());
            planets.add(planet);
        }

        return planets;

    }


    public Planet pickRandomPlanet() {
        int num = (int) (Math.random() * planets.size());

        return planets.get(num);
    }
}
