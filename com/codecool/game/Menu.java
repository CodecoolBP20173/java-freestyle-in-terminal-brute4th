package com.codecool.game;

import com.codecool.game.*;
import com.codecool.termlib.*;

public class Menu {

    private int option;

    public void printMainMenu() {
        Animation menu = new Animation();
        menu.MainMenu(17,30);
    }
    
    public void handleMainMenu() throws Exception {
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
            Score show = new Score();
            show.handleScore();
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