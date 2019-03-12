package com.example.spacetrader.dataaccess.typeconverters;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.media.Image;

import com.example.spacetrader.entities.GameDifficulty;
import com.example.spacetrader.entities.planet.Planet;
import com.example.spacetrader.entities.planet.ResourceType;
import com.example.spacetrader.entities.planet.TechLevel;
import com.example.spacetrader.entities.tradegoods.TradeGood;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeConverterClass {
    //todo refactor this to be generic

    @TypeConverter
    public static GameDifficulty fromGameDifficultyInteger(Integer numeral){
        for(GameDifficulty ds : GameDifficulty.values()){
            if(ds.getCode() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static Integer toGameDifficultyInteger(GameDifficulty gameDifficulty) {
        return gameDifficulty.getCode();
    }

    @TypeConverter
    public static ResourceType fromResourceTypeInteger(Integer numeral){
        for(ResourceType ds : ResourceType.values()){
            if(ds.getCode() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static Integer toResourceTypeInteger(ResourceType resourceType) {
        return resourceType.getCode();
    }

    @TypeConverter
    public static TechLevel fromTechLevelInteger(Integer numeral){
        for(TechLevel ds : TechLevel.values()){
            if(ds.getCode() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static Integer toTechLevelInteger(TechLevel techLevel) {
        return techLevel.getCode();
    }



    @TypeConverter
    public static HashMap<TradeGood, Integer> fromString(String value) {
        Type mapType = new TypeToken<HashMap<TradeGood, Integer>>() {
        }.getType();
        return new Gson().fromJson(value, mapType);
    }

    @TypeConverter
    public static String fromStringMap(HashMap<TradeGood, Integer> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    @TypeConverter
    public static List<Planet> fromPlanetString(String value) {
        Type mapType = new TypeToken<HashMap<TradeGood, Integer>>() {
        }.getType();
        return new Gson().fromJson(value, mapType);
    }

    @TypeConverter
    public static String toPlanetString(List<Planet> planetList) {

        Gson gson = new Gson();
        System.out.println(gson.toJson(planetList));
        return gson.toJson(planetList);
    }

}
