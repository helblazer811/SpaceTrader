package com.example.spacetrader.models.planet;

import android.util.Log;

import com.example.spacetrader.models.Universe;

public class Planet {

    private String name;
    private int xLoc;
    private int yLoc;
    private TechLevel techLevel;
    private ResourceType resourceType;

    public Planet(String name, int xLoc, int yLoc, TechLevel techLevel, ResourceType resourceType) {
        this.name = name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.techLevel = techLevel;
        this.resourceType = resourceType;

        Log.i("Planet Information: ", this.toString());
    }

    /**
     * This constructor randomly generates everything but the name
     * @param name
     */
    public Planet(String name) {
        this.name = name;
        this.xLoc = (int)(Math.random() * Universe.xRange);
        this.yLoc = (int)(Math.random() * Universe.yRange);
        this.techLevel = TechLevel.values()[(int)(Math.random() * TechLevel.numLevels)];
        this.resourceType = ResourceType.values()[(int)(Math.random() * ResourceType.numTypes)];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
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

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", xLoc=" + xLoc +
                ", yLoc=" + yLoc +
                ", techLevel=" + techLevel +
                ", resourceType=" + resourceType +
                '}';
    }
}
