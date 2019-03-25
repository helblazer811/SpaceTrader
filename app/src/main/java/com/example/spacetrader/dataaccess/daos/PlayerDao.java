package com.example.spacetrader.dataaccess.daos;


import com.example.spacetrader.entities.Player;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
/*
Interface that provides functions for accessing database
 */
public interface PlayerDao {

    @Query("SELECT * FROM player")
    LiveData<List<Player>> getAllPlayers();

    @Query("SELECT * FROM player WHERE playerId LIKE :playerId")
    LiveData<Player> findByPlayerId(long playerId);

    @Query("SELECT COUNT(*) FROM player")
    int playerCount();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Player player);

    @Delete
    void delete(Player player);


}
