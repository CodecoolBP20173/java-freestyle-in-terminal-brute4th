package com.codecool.game;

import java.util.ArrayList;
import com.codecool.termlib.Terminal;
import com.codecool.data_manager.*;
import java.lang.Thread;

public class Animation {
    ReadFile txtInput = new ReadFile();
    Thread t;
    Terminal term = new Terminal();

    public void AnswerAnimation(String fname, int height, int frames, int sleep, int x, int y) {      
        int index = 0;
        ArrayList<String> ascii_animation = txtInput.readFile(fname);
        for (int i = 0; i < frames; i++) {
            term.clearScreen();
            term.moveTo(x, y);
            for (int j = 0; j < height; j++) {
                term.moveTo(x, y+j);
                System.out.println(ascii_animation.get(index));
                index+=1;
            }
            try {
                Thread.sleep(sleep);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void MainMenu(int height, int frames) {
        ArrayList<String> menu = txtInput.readFile("main_menu");
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