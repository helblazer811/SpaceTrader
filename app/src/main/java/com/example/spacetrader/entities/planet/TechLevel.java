package com.example.spacetrader.entities.planet;

/**
 * Represents Tech Levels of  Planet
 */
public enum TechLevel {
    PRE_AGRICULTURE(0, "Pre-Agriculture"),
    AGRICULTURE(1,"Agriculture"),
    MEDIEVAL(2,"Medieval"),
    RENAISSANCE(3,"Renaissance"),
    EARLY_INDUSTRIAL(4,"Early Industrial"),
    INDUSTRIAL(5, "Industrial"),
    POST_INDUSTRIAL(6, "Post-Industrial"),
    HI_TECH(7,"Hi-Tech");

    public static final int numLevels = 8;

    private Integer code;
    private String stringName;

    /**
     * Constructor for TechLevel
     * @param code code for Tech Level
     * @param stringName name of Tech Level
     */
    TechLevel(Integer code, String stringName) {
        this.code = code;
        this.stringName = stringName;
    }

    /**
     * Gets code of Tech Level
     * @return code of Tech Level
     */
    public Integer getCode() {
        return code;
    }

    /**
     * String representation of Tech Level
     * @return name of Tech Level
     */
    public String toString() {
        return stringName;
    }
}
