package com.example.spacetrader.dataaccess.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.example.spacetrader.entities.GameDifficulty;

public class GameDifficultyTypeConverter {

    @TypeConverter
    public static GameDifficulty fromRepresentation(Integer numeral){
        for(GameDifficulty ds : GameDifficulty.values()){
            if(ds.getCode() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static Integer toRepresentation(GameDifficulty gameDifficulty) {
        return gameDifficulty.getCode();
    }

}
