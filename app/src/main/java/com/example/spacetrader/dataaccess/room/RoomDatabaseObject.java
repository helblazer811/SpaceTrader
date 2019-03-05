package com.example.spacetrader.dataaccess.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.spacetrader.dataaccess.daos.GameDao;
import com.example.spacetrader.dataaccess.daos.PlayerDao;
import com.example.spacetrader.dataaccess.typeconverters.GameDifficultyTypeConverter;
import com.example.spacetrader.entities.Game;
import com.example.spacetrader.entities.Player;

@Database(entities = {Player.class, Game.class }, version = 1)
@TypeConverters({GameDifficultyTypeConverter.class})
public abstract class RoomDatabaseObject extends RoomDatabase {
    /*
        This class contains the
     */

    public abstract GameDao getGameDao();
    public abstract PlayerDao getPlayerDao();
}
