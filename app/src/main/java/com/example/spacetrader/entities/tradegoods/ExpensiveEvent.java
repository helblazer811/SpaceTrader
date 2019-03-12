package com.example.spacetrader.entities.tradegoods;

public enum ExpensiveEvent {
    DESERT(0),
    LIFELESS(1),
    POORSOIL(2),
    MINERALPOOR(3);

    private Integer code;

    ExpensiveEvent(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
