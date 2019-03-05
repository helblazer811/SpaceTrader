package com.example.spacetrader.entities;

import android.arch.persistence.room.PrimaryKey;

public class Ship {
    /*
        This is an empty Ship class becuase there
        were not directions as to how this should be implemented.
     */

    private String shipName;

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
}
