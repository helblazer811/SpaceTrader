package com.example.spacetrader.dataaccess.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.example.spacetrader.dataaccess.daos.PlayerDao;
import com.example.spacetrader.dataaccess.room.RoomDatabaseObject;
import com.example.spacetrader.entities.Player;

import java.util.concurrent.Executor;

public class PlayerRepository {

    private RoomDatabaseObject roomDatabase;
    private PlayerDao playerDao;
    private Executor executor;
    /*
        Dependency injection
     */
    public PlayerRepository(PlayerDao playerDao, Executor executor) {
        this.playerDao = playerDao;
        this.executor = executor;
    }

    public PlayerRepository(Context context) {
        this.roomDatabase = RoomDatabaseObject.getDatabase(context);
        this.playerDao = this.roomDatabase.getPlayerDao();
    }

    //todo implement player cache
    //private PlayerCache playerCache;

    public LiveData<Player> getPlayer(final String playerName) {
        LiveData<Player> data = playerDao.findByName(playerName);
        /*
        //todo implement pull from cache here
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        }.execute();
        */

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
