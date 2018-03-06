package com.codecool.termlib;

public enum Color {
    BLACK (30),
    RED (31),
    GREEN (32),
    YELLOW (33),
    BLUE (34),
    MAGENTA (35),
    CYAN (36),
    WHITE (97),
    DEFAULT (39);

    private final int colorCode;

    Color(int colorCode) {
        this.colorCode = colorCode;
    }
    
    public int getColorCode() {
        return this.colorCode;
    }
}
