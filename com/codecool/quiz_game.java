package com.codecool;

import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;
import com.codecool.termlib.Direction;
import com.codecool.data_manager.*;
import java.util.*;



public class quiz_game {
    public static void main(String[] args) {
        Terminal term = new Terminal();
        ReadFile read = new ReadFile();
        ArrayList<HashMap<String, String>> questions = read.questions();
        System.out.println(questions.get(0));
    }
}
