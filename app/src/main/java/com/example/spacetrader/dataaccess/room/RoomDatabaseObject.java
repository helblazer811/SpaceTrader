package com.example.spacetrader.dataaccess.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.spacetrader.dataaccess.daos.GameDao;
import com.example.spacetrader.dataaccess.daos.PlayerDao;
import com.example.spacetrader.dataaccess.typeconverters.GameDifficultyTypeConverter;
import com.example.spacetrader.entities.Game;
import com.example.spacetrader.entities.Player;

@Database(entities = {Player.class, Game.class }, version = 1)
@TypeConverters({GameDifficultyTypeConverter.class})
public abstract class RoomDatabaseObject extends RoomDatabase {
    /*
        This class contains the room database singleton
     */

    public static final String NAME = "room_db";

    public abstract GameDao getGameDao();
    public abstract PlayerDao getPlayerDao();

    private static RoomDatabaseObject instance;

    public static RoomDatabaseObject getDatabase(final Context context) {

        if (instance == null) {
            synchronized (RoomDatabaseObject.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabaseObject.class, NAME)
                            .build();
                }
            }
        }
        return instance;
    }
}
