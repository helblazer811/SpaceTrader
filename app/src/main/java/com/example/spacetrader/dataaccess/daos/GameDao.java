package com.example.spacetrader.dataaccess.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.spacetrader.entities.Game;
import com.example.spacetrader.entities.Player;

@Dao
public interface GameDao {
    /*
        This interface declares all of the method signitures
        shared by all of the forms of storage.
     */

    /*
    @Query("SELECT ")
    Game loadGame();
    */
    @Insert
    void insertGame(Game game);

    /*
    @Query()
    Player loadPlayer();
    */
    @Insert
    void insertPlayer(Player player);


}
