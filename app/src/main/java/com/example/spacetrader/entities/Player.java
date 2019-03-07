package com.example.spacetrader.entities;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.spacetrader.entities.planet.Planet;

import java.util.Map;

@Entity
public class Player {

    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;

    private GameDifficulty difficulty;
    @Embedded
    private Planet currentPlanet;

    @PrimaryKey
    @NonNull
    private String name;
    @Embedded
    private Ship gameShip;
    private int credits;

    public Player() {
        pilotPoints = 0;
        fighterPoints = 0;
        traderPoints = 0;
        engineerPoints = 0;
        difficulty = GameDifficulty.BEGINNER;
        name = "";
        gameShip = null;
        credits = 1000;
    }

    public Player(Map<String, Object> map) {
        pilotPoints = (int) map.get("pilot");
        engineerPoints = (int) map.get("engineer");
        traderPoints = (int) map.get("trader");
        fighterPoints = (int) map.get("fighter");
        difficulty = (GameDifficulty) map.get("game_difficulty");
        name = (String) map.get("name");
        gameShip = null;
        credits = 1000;
    }


    public int getPilotPoints() {
        return pilotPoints;
    }

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    public int getEngineerPoints() {
        return engineerPoints;
    }

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship getGameShip() {
        return gameShip;
    }

    public void setGameShip(Ship gameShip) {
        this.gameShip = gameShip;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pilotPoints=" + pilotPoints +
                ", fighterPoints=" + fighterPoints +
                ", traderPoints=" + traderPoints +
                ", engineerPoints=" + engineerPoints +
                ", difficulty=" + difficulty +
                ", name='" + name + '\'' +
                ", gameShip=" + gameShip +
                ", credits=" + credits +
                '}';
    }
}
