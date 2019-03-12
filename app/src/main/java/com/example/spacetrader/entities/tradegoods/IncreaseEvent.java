package com.example.spacetrader.entities.tradegoods;

public enum IncreaseEvent {
    DROUGHT(0),
    COLD(1),
    CROPFAIL(2),
    WAR(3),
    BOREDOM(4),
    PLAGUE(5),
    LACKOFWORKERS(6);

    private Integer code;

    IncreaseEvent(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
