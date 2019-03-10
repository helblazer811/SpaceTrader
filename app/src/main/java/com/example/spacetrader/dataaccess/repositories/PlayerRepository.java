package com.example.spacetrader.dataaccess.repositories;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.example.spacetrader.dataaccess.daos.PlayerDao;
import com.example.spacetrader.dataaccess.room.RoomDatabaseObject;
import com.example.spacetrader.entities.Player;

import java.util.concurrent.Executor;

/*
the single interface to interact with player objects
 */
public class PlayerRepository {

    private RoomDatabaseObject roomDatabase;
    private PlayerDao playerDao;

    /*
        Dependency injection
     */
    public PlayerRepository(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public PlayerRepository(Context context) {
        this.roomDatabase = RoomDatabaseObject.getDatabase(context);
        this.playerDao = this.roomDatabase.getPlayerDao();
    }

    //todo implement player cache
    //private PlayerCache playerCache;

    public LiveData<Player> getPlayer(final String playerName) {
        LiveData<Player> data = playerDao.findByName(playerName);

        return data;
    }

    public void insertPlayer(final Player player) {
        //implement thread safety
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                playerDao.insert(player);
                return null;
            }
        }.execute();

    }


}
