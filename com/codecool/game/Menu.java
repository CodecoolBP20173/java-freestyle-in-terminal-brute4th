package com.codecool.game;

import com.codecool.game.ConsoleIn;
import com.codecool.termlib.Terminal;;

public class Menu {

    private int option;

    public void printMainMenu() {
        Terminal term = new Terminal();
        term.clearScreen();

        System.out.println("============================");
        System.out.println("|        QUIZ  GAME        |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. New Game       |");
        System.out.println("|        2. High Scores    |");
        System.out.println("|        3. Credits        |");
        System.out.println("|        4. Exit           |");
        System.out.println("============================");
    }
    
    public void handleMainMenu() {
        ConsoleIn consoleInputStream = new ConsoleIn();
        int userInput;
        boolean exit = false;

        while (!exit) {
            printMainMenu();
            userInput = consoleInputStream.askInputInt(" Select option: ");
            switch (userInput) {
            case 1:
            System.out.println("Option 1 selected");
            option=1;
            exit = true;
            break;
            case 2:
            System.out.println("Option 2 selected");
            option=2;
            exit = true;
            break;
            case 3:
            System.out.println("Option 3 selected");
            break;
            case 4:
            System.out.println("Good bye! See you next time ;)");
            exit = true;
            break;
            default:
            System.out.println("Invalid selection");
            break;
            }
        }
    }

    public Integer getOption(){
        return option;
    }
    
}   