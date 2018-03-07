package com.codecool.termlib;
import com.codecool.termlib.Color;

public class Terminal {
    private static final String CONTROL_CODE = "\033[";
    private static final String CLEAR = "2J";
    private static final String MOVE = "H";
    private static final String STYLE = "m";

    public void resetStyle() {
        command(CONTROL_CODE + "0" + STYLE);
    }

    public void clearScreen() {
        command(CONTROL_CODE + MOVE + CONTROL_CODE + CLEAR);
    }

    public void moveTo(Integer x, Integer y) {
        char escCode = 0x1B;
        command(String.format("%c[%d;%df",escCode,y,x));
    }

    public void setColor(int color) {
        command(CONTROL_CODE + color + STYLE);
    }

    public void setBgColor(int color) {
        color += 10;
        command(CONTROL_CODE + color + STYLE);
    }

    public void setUnderline(String s) {
        command(CONTROL_CODE + "4" + STYLE + s);
    }

    public void setBold(String s) {
        command(CONTROL_CODE + "1" + STYLE + s);
    }

    public void moveCursor(String direction, Integer amount) {
        command(CONTROL_CODE + amount + direction+ "\033[1;15m");
    }

    public void setChar(char c) {
        System.out.print(c);
        moveCursor("D", 1);
    }

    private void command(String commandString) {
        System.out.print(commandString);
    }
}
