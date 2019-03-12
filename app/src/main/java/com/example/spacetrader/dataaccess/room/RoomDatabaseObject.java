package com.example.spacetrader.dataaccess.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.spacetrader.dataaccess.daos.PlayerDao;
import com.example.spacetrader.dataaccess.typeconverters.TypeConverterClass;
import com.example.spacetrader.entities.Inventory;
import com.example.spacetrader.entities.Player;
import com.example.spacetrader.entities.planet.Planet;
import com.example.spacetrader.entities.ship.Ship;

@Database(entities = {Player.class, Planet.class, Ship.class, Inventory.class}, version = 2)
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
                            .build();
                }
            }
        }
        return instance;
    }
}
