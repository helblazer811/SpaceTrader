package com.example.spacetrader.dataaccess.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.spacetrader.entities.Player;

import java.util.List;

@Dao
/*
Interface that provides functions for accessing database
 */
public interface PlayerDao {

    @Query("SELECT * FROM player")
    LiveData<List<Player>> getAllPlayers();

    @Query("SELECT * FROM player WHERE name LIKE :name LIMIT 1")
    LiveData<Player> findByName(String name);

    @Query("SELECT COUNT(*) FROM player")
    int playerCount();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Player player);

    @Delete
    void delete(Player player);


}
