package com.example.spacetrader.entities.planet;

public enum TechLevel {
    PRE_AGRICULTURE(0),
    AGRICULTURE(1),
    MEDIEVAL(2),
    RENAISSANCE(3),
    EARLY_INDUSTRIAL(4),
    INDUSTRIAL(5),
    POST_INDUSTRIAL(6),
    HI_TECH(7);

    public static final int numLevels = 8;

    private Integer code;

    TechLevel(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
