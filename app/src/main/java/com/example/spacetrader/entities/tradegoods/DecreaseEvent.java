package com.example.spacetrader.entities.tradegoods;

/**
 * DecreaseEvent is an enum with instances of planet characteristics that can affect
 * prices
 */
public enum DecreaseEvent {
    LOTSOFWATER(0),
    RICHFAUNA(1),
    RICHSOIL(2),
    MINERALRICH(3),
    ARTISTIC(4),
    WARLIKE(5),
    LOTSOFHERBS(6),
    WEIRDMUSHROOMS(7);

    private final Integer code;

    DecreaseEvent(Integer code){
        this.code = code;
    }


    /**
     * getter for the code
     * @return the Integer code
     */
    public Integer getCode() {
        return code;
    }
    }
