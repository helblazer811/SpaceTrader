package com.example.spacetrader.dataaccess.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.spacetrader.entities.Player;

@Dao
public interface PlayerDao {

    @Query("SELECT * FROM player WHERE name LIKE :name LIMIT 1")
    Player findByName(String name);

    @Insert
    void insertPlayer(Player player);

}
