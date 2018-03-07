package com.codecool;

import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;
import com.codecool.termlib.Direction;
import com.codecool.game.GameControl;
import com.codecool.game.Menu;
import com.codecool.data_manager.*;
import java.util.*;



public class quiz_game {
    public static void main(String[] args) {

        //Terminal term = new Terminal();
        //quiz_game game = new quiz_game();
        Menu HomeScreen = new Menu();
        HomeScreen.handleMainMenu();
        GameControl controller = new GameControl();
        switch(HomeScreen.getOption()){
            case 1:
                controller.mainGame();
                break;
            case 2:
                //controller.showScores();
                break;
            case 3:
                //controller.showCredits();
                break;
        }
        /* WriteFile write = new WriteFile();
        write.saveScore("Mucika", 852);

        ReadFile read = new ReadFile();
        ArrayList<HashMap<String, String>> questions = read.questions();
        System.out.println(questions.get(0)); */
    }

}