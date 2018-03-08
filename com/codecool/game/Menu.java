package com.codecool.game;

import com.codecool.game.*;
import com.codecool.termlib.*;

public class Menu {

    private int option;

    public void printMainMenu() {
        Animation menu = new Animation();
        menu.MainMenu(17,40);
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
            option=1;
            exit = true;
            break;
            case 2:
            Score show = new Score();
            show.handleScore();
            break;
            case 3:
                Credits credit = new Credits();
                credit.printCredits();
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