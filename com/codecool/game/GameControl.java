package com.codecool.game;

import com.codecool.data_manager.*;
import com.codecool.game.Printer;
import com.codecool.game.ConsoleIn;
import com.codecool.termlib.Terminal;
import java.util.*;

public class GameControl {

    int numberOfQuestions=6;

    public void mainGame(){
        ReadFile read = new ReadFile();
        Printer pr = new Printer();
        ConsoleIn consoleInputStream = new ConsoleIn();

        ArrayList<HashMap<String, String>> questions = read.questions();
        ArrayList<Integer> questionOrder = randNumberList(numberOfQuestions);
        System.out.println(questionOrder);

        for (int num : questionOrder) {
            int userInput;
            System.out.println(num);
            pr.displayQuestionsAnswers(questions.get(num));
            userInput = consoleInputStream.askInputInt(" Select option: ");
        }
            
    }

    public ArrayList<Integer> randNumberList(int numberOfQuestions){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<numberOfQuestions; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        ArrayList<Integer> result = new ArrayList<Integer>(list.subList(0, 5));
        return result;
    }
}