package com.example.spacetrader.entities.tradegoods;

public enum DecreaseEvent {
    LOTSOFWATER(0),
    RICHFAUNA(1),
    RICHSOIL(2),
    MINERALRICH(3),
    ARTISTIC(4),
    WARLIKE(5),
    LOTSOFHERBS(6),
    WEIRDMUSHROOMS(7);

    private Integer code;

    DecreaseEvent(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
    }
