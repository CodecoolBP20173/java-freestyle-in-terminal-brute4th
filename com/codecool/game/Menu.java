package com.codecool.game;

import com.codecool.game.*;
import com.codecool.termlib.*;

public class Menu {

    public void printMainMenu() {
        Animation menu = new Animation();
        menu.MainMenu(17,40);
    }
    
    public void handleMainMenu() throws Exception {
        ConsoleIn consoleInputStream = new ConsoleIn();
        int userInput;
        boolean exit = false;
        GameControl controller = new GameControl();

        while (!exit) {
            printMainMenu();
            exit = false;
            controller.playerScore = 0;
            userInput = consoleInputStream.askInputInt (" Select option: ");
            switch (userInput) {
            case 1:
                controller.welcomePage();
                controller.mainGame();
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
}   