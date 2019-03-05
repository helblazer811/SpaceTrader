package com.example.spacetrader.dataaccess.room;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.spacetrader.dataaccess.daos.GameDao;
import com.example.spacetrader.entities.Game;
import com.example.spacetrader.entities.Player;

public class RoomStorage implements GameDao {

    public static final String NAME = "room_db";

    private RoomDatabaseObject roomDatabase;

    public RoomStorage(Context appContext){
        roomDatabase = Room.databaseBuilder(
                appContext,
                RoomDatabaseObject.class,
                NAME
                ).allowMainThreadQueries()
                .build();
    }

    public Game loadGame() {
        return null;
    }

    @Override
    public void insertGame(Game game) {

    }

    public Player loadPlayer() {
        return null;
    }

    @Override
    public void insertPlayer(Player player) {
        roomDatabase.getPlayerDao().insertPlayer(player);
    }
}
