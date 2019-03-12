package com.example.spacetrader.entities.planet;

public enum ResourceType {
    NOSPECIALRESOURCES(0),
    MINERALRICH(1),
    MINERALPOOR(2),
    DESERT(3),
    LOTSOFWATER(4),
    RICHSOIL(5),
    RICHFAUNA(6),
    LIFELESS(7),
    WEIRDMUSHROOMS(8),
    LOTSOFHERBS(9),
    ARTISTIC(10),
    WARLIKE(11);

    public static final int numTypes = 12;

    private Integer code;

    ResourceType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
