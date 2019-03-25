package com.example.spacetrader.entities.planet;

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

    TechLevel(Integer code, String stringName) {
        this.code = code;
        this.stringName = stringName;
    }

    public Integer getCode() {
        return code;
    }

    public String toString() {
        return stringName;
    }
}
