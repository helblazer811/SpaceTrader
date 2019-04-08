package com.example.spacetrader.entities;

/**
 * Instances of game difficulty
 */
public enum GameDifficulty {
    BEGINNER(0),
    EASY(1),
    NORMAL(2),
    HARD(3),
    IMPOSSIBLE(4);

    private final Integer code;

    GameDifficulty(Integer code) {
        this.code = code;
    }

    /**
     * getter for code
     * @return the code Integer object
     */
    public Integer getCode() {
        return code;
    }
}
