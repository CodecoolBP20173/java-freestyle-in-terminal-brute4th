package com.codecool.game;

import java.util.ArrayList;
import com.codecool.termlib.Terminal;
import com.codecool.data_manager.*;
import java.lang.Thread;
import java.util.Random;

public class Animation {
    ReadFile txtInput = new ReadFile();
    Thread t;

    public void GoodAnswer(int height, int frames) {
        String[] filenames = new String[2]; // ide kell betölteni a txt fájl nevét 
        ArrayList<String> ascii_animation = txtInput.readFile(filenames[new Random().nextInt(filenames.length)]);
        int index = 0;
        for (int i = 0; i < frames; i++) {
            Terminal term = new Terminal();
            term.clearScreen();
            for (int j = 0; j < height; j++) {
                System.out.println(ascii_animation.get(index));
                index+=1;
            }
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void BadAnswer(int height, int frames) {
        String[] filenames = new String[2]; // ide kell betölteni a txt fájl nevét 
        ArrayList<String> ascii_animation = txtInput.readFile(filenames[new Random().nextInt(filenames.length)]);
        int index = 0;
        for (int i = 0; i < frames; i++) {
            Terminal term = new Terminal();
            term.clearScreen();
            for (int j = 0; j < height; j++) {
                System.out.println(ascii_animation.get(index));
                index+=1;
            }
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void MainMenu(int height, int frames) {
        ArrayList<String> menu = txtInput.readFile("main_menu.txt");
        int index = 0;
        for (int i = 0; i < frames; i++) {
            Terminal term = new Terminal();
            term.clearScreen();
            for (int j = 0; j < height; j++) {
                System.out.println(menu.get(index));
                index+=1;
            }
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    
}