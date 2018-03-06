package com.codecool.termlib;

public enum Direction {
    UP ("A"),
    DOWN ("B"),
    FORWARD ("C"),
    BACKWARD ("D");

    private final String directionChar;

    Direction(String directionChar) {
        this.directionChar = directionChar;
    }
    
    public String getDirectionChar() {
        return this.directionChar;
    }
    
}
