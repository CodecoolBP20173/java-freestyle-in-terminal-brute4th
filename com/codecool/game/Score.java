package com.codecool.game;

import com.codecool.termlib.*;
import com.codecool.data_manager.*;

import java.util.*;


public class Score {
    public void printScore() {
        Terminal term = new Terminal();
        term.clearScreen();

        Printer print = new Printer();
        print.displayTopScore(15);

    }
    
    public void handleScore() {
        ConsoleIn consoleInputStream = new ConsoleIn();
        int userInput;
        boolean exit = false;

        while (!exit) {
            printScore();
            userInput = consoleInputStream.askInputInt(" Press 1 to go back! ");
            if (userInput == 1) {
            exit = true;
            break;
            }
        }
    }
}
