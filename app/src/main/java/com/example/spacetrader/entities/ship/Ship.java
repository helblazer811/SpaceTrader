package com.example.spacetrader.entities.ship;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;

import com.example.spacetrader.entities.Player;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = Player.class,
                        parentColumns = "playerId",
                        childColumns = "playerId",
                        onDelete = CASCADE))
public abstract class Ship extends BaseObservable {
    /*
        This is an empty Ship class becuase there
        were not directions as to how this should be implemented.
     */

    @PrimaryKey(autoGenerate = true)
    private long shipId;

    private long playerId;

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
}
