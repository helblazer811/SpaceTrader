package com.example.spacetrader.dataaccess.room;

import android.content.Context;

import com.example.spacetrader.dataaccess.daos.PlayerDao;
import com.example.spacetrader.dataaccess.typeconverters.TypeConverterClass;
import com.example.spacetrader.entities.Inventory;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.planet.Planet;
import com.example.spacetrader.entities.planet.Universe;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Player.class, Planet.class, Inventory.class, Universe.class}, version = 2)
@TypeConverters({TypeConverterClass.class})
public abstract class RoomDatabaseObject extends RoomDatabase {
    /*
        This class contains the room database singleton
     */

    public static final String NAME = "room_db";

    public abstract PlayerDao getPlayerDao();

    private static RoomDatabaseObject instance;

    public static RoomDatabaseObject getDatabase(final Context context) {

        if (instance == null) {
            synchronized (RoomDatabaseObject.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabaseObject.class, NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
