package com.example.spacetrader.models;

import java.util.HashMap;

public class Player {

    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private GameDifficulty difficulty;
    private String name;
    private Ship gameShip;

    public Player() {
        pilotPoints = 0;
        fighterPoints = 0;
        traderPoints = 0;
        engineerPoints = 0;
        difficulty = GameDifficulty.BEGINNER;
        name = "";
        gameShip = null;
    }

    public Player(HashMap<String, Object> map) {
        pilotPoints = (int) map.get("pilot");
        engineerPoints = (int) map.get("engineer");
        traderPoints = (int) map.get("trader");
        fighterPoints = (int) map.get("fighter");
        difficulty = (GameDifficulty) map.get("game_difficulty");
        name = (String) map.get("name");
        gameShip = null;
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

}
