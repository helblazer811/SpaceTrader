package com.example.spacetrader.entities.planet;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.Universe;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = Player.class,
        parentColumns = "playerId",
        childColumns = "playerId",
        onDelete = CASCADE),
        indices = {})
public class Planet {

    @PrimaryKey(autoGenerate = true)
    private long planetId;

    private long playerId;

    private String planetName;
    private int xLoc;
    private int yLoc;
    private TechLevel techLevel;
    private ResourceType resourceType;

    public Planet(String planetName, int xLoc, int yLoc, TechLevel techLevel, ResourceType resourceType) {
        this.planetName = planetName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.techLevel = techLevel;
        this.resourceType = resourceType;

        Log.i("Planet Information: ", this.toString());
    }

    /**
     * This constructor randomly generates everything but the name
     * @param planetName
     */
    @Ignore
    public Planet(String planetName) {
        this.planetName = planetName;
        this.xLoc = (int)(Math.random() * Universe.xRange);
        this.yLoc = (int)(Math.random() * Universe.yRange);
        this.techLevel = TechLevel.values()[(int)(Math.random() * TechLevel.numLevels)];
        this.resourceType = ResourceType.values()[(int)(Math.random() * ResourceType.numTypes)];
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getXLoc() {
        return xLoc;
    }

    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public long getPlanetId() {
        return planetId;
    }

    public void setPlanetId(long planetId) {
        this.planetId = planetId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }


    @Override
    public String toString() {
        return "Planet{" +
                "name='" + planetName + '\'' +
                ", xLoc=" + xLoc +
                ", yLoc=" + yLoc +
                ", techLevel=" + techLevel +
                ", resourceType=" + resourceType +
                '}';
    }
}
