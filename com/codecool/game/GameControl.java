package com.codecool.game;

import com.codecool.data_manager.*;
import com.codecool.game.Printer;
import java.util.*;

public class GameControl {

    ArrayList<Integer> questionOrder;
    int numberOfQuestions=6;

    public void mainGame(){
        ReadFile read = new ReadFile();
        Printer pr = new Printer();

        ArrayList<HashMap<String, String>> questions = read.questions();
        questionOrder = randNumberList(numberOfQuestions);
        System.out.println(questions.get(5));
        System.out.println(questionOrder);

        while(true){
            int questionNumber = questionOrder.get(questionOrder.size() - 1);
            questionOrder.remove(questionNumber);
            System.out.println(questions.get(questionNumber));
            pr.displayQuestionsAnswers(questions.get(questionNumber));
            break;
        }
    }

    public ArrayList<Integer> randNumberList(int numberOfQuestions){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<numberOfQuestions-1; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        ArrayList<Integer> result = new ArrayList<Integer>(list.subList(0, 5));
        return result;
    }
}