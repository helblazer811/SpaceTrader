package com.example.spacetrader.entities;

public enum GameDifficulty {
    BEGINNER(0),
    EASY(1),
    NORMAL(2),
    HARD(3),
    IMPOSSIBLE(4);

    private Integer code;

    GameDifficulty(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
