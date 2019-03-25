package com.example.spacetrader.entities.planet;

public enum ResourceType {
    NOSPECIALRESOURCES(0, "No Special Resources"),
    MINERALRICH(1, "Mineral Rich"),
    MINERALPOOR(2, "Mineral Poor"),
    DESERT(3, "Desert"),
    LOTSOFWATER(4, "Lots of Water"),
    RICHSOIL(5, "Rich Soil"),
    RICHFAUNA(6, "Rich Fauna"),
    LIFELESS(7, "Lifeless"),
    WEIRDMUSHROOMS(8, "Weird Mushrooms"),
    LOTSOFHERBS(9, "Lots of Herbs"),
    ARTISTIC(10, "Artistic"),
    WARLIKE(11, "Warlike");

    public static final int numTypes = 12;

    private Integer code;
    private String name;

    ResourceType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String toString() {
        return name;
    }
}
