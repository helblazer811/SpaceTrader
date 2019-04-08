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

/**
 * Represents Universe in Space Trader that consists of Planets
 */
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
    public static final int xRange = 300;
    @Ignore
    public static final int yRange = 300;
    @Ignore
    private static final int numPlanets = planetNames.length;

    /**
     * Creates Universe consisting of Planets
     */
    @Ignore
    public Universe() {
        generatePlanets();
    }

    /**
     * Main constructor that creates a Universe
     * @param universeId id of Universe
     * @param planets list of Planets
     */
    public Universe(long universeId, List<Planet> planets) {
        this.universeId = universeId;
        this.planets = planets;
    }

    /**
     * Gets Universe Id
     * @return Universe Id
     */
    public long getUniverseId() {
        return universeId;
    }

    /**
     * Sets Universe Id
     * @param universeId Universe Id
     */
    public void setUniverseId(long universeId) {
        this.universeId = universeId;
    }

    /**
     * Gets list of Planets
     * @return list of Planets
     */
    public List<Planet> getPlanets() {
        return planets;
    }

    /**
     * Sets list of Planets
     * @param planets list of Planets
     */
    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    /**
     * Generates a unique set of planets
     **/
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

    /**
     * Chooses a random Planet
     * @return Planet
     */
    public Planet pickRandomPlanet() {
        int num = (int) (Math.random() * planets.size());

        return planets.get(num);
    }
}
