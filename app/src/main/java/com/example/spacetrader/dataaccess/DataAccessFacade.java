package com.example.spacetrader.dataaccess;

import android.content.Context;

import com.example.spacetrader.dataaccess.daos.GameDao;
import com.example.spacetrader.dataaccess.firebase.FirebaseStorage;
import com.example.spacetrader.dataaccess.room.RoomStorage;
import com.example.spacetrader.entities.Game;
import com.example.spacetrader.entities.Player;

public class DataAccessFacade{
    /*
        This class is a singleton
        It is a gateway to all of the data in the application.
        The viewmodels all have access to the data via this facade
        It has static variables with modes
     */
    private static final DataAccessFacade SINGLE_INSTANCE = new DataAccessFacade();
    /*
        todo remove the need for this enum by
        automatically referencing the correct GameDAO instance
     */
    private static StorageMode storageMode = StorageMode.ROOM;
    private static GameDao database;
    private static Context context;

    private DataAccessFacade(){
        //hides constructor
    }

    public static DataAccessFacade getInstance(Context appContext) {
        if (storageMode.equals(StorageMode.ROOM)) {
            database = new RoomStorage(appContext);
        } else if (storageMode.equals(StorageMode.FIREBASE)) {
            database = new FirebaseStorage();
        }
        context = appContext;
        return SINGLE_INSTANCE;
    }

    public StorageMode getStorageMode() {
        return storageMode;
    }

    public void setStorageMode(StorageMode storageMode) {
        this.storageMode = storageMode;

        if (storageMode.equals(StorageMode.ROOM)) {
            database = new RoomStorage(context);
        } else if (storageMode.equals(StorageMode.FIREBASE)) {
            database = new FirebaseStorage();
        }
    }

    public Game loadGame() {
        //uses the relevent GameDAO object
        /*return database.loadGame();*/
        return null;
    }

    public void insertGame(Game game){
        database.insertGame(game);
    }

    public Player loadPlayer() {
        /*return database.loadPlayer();*/
        return null;
    }

    public void insertPlayer(Player player) {
        database.insertPlayer(player);
    }
}
