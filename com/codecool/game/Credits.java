package com.codecool.game;

import com.codecool.termlib.*;
import com.codecool.game.*;

public class Credits{
    public void printCredits() throws Exception{
        Terminal term = new Terminal();
        boolean back = false;
        ConsoleIn consoleInputStream = new ConsoleIn();
        term.clearScreen();
        AsciiDrawer drawer = new AsciiDrawer();
        drawer.printTextArt(35, 10, "Credits", AsciiDrawer.ART_SIZE_MEDIUM);
        term.moveTo(65, 30);
        System.out.println("Barazutti Péter");
        term.moveTo(65, 32);
        System.out.println("Jeszmás László");
        term.moveTo(65, 34);
        System.out.println("Koroknay Ákos");
        term.moveTo(65, 36);
        System.out.println("Székesi Lilla");
        term.moveTo(30, 40);
        while (!back) {
            int userInput = consoleInputStream.askInputInt(" Press 1 to go back! ");
            if (userInput == 1) {
                back = true;
            }           
        }
    }
}    