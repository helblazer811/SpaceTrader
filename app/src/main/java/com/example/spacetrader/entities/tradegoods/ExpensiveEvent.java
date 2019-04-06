package com.example.spacetrader.entities.tradegoods;
/**
 * ExpensiveEvent is an enum with instances of planet characteristics that can affect
 * prices upwards
 */
public enum ExpensiveEvent {
    DESERT(0),
    LIFELESS(1),
    POORSOIL(2),
    MINERALPOOR(3);

    private final Integer code;

    ExpensiveEvent(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
