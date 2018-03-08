package com.codecool.game;

import com.codecool.data_manager.*;
import com.codecool.game.Printer;
import com.codecool.game.ConsoleIn;
import com.codecool.termlib.Terminal;
import java.util.*;
import com.codecool.game.AsciiDrawer;
import java.util.concurrent.TimeUnit;
import com.codecool.game.Animation;

public class GameControl {

    int numberOfQuestions=6;

    public void mainGame() throws Exception{
        ReadFile read = new ReadFile();
        Printer pr = new Printer();
        ConsoleIn consoleInputStream = new ConsoleIn();
        Terminal term = new Terminal();
        AsciiDrawer drawer = new AsciiDrawer();
        Animation anim = new Animation();

        ArrayList<HashMap<String, String>> questions = read.questions();
        ArrayList<Integer> questionOrder = randNumberList(numberOfQuestions);

        for (int num : questionOrder) {
            int userInput;
            pr.displayQuestionsAnswers(questions.get(num));
            userInput = consoleInputStream.askInputInt(" Select option: ");
            int solution = pr.getCorrectAnswer();
            if(userInput == solution){
                //placeholder
                //System.out.println("telibe");
                //term.moveTo(10, 10);
                term.clearScreen();
                term.moveTo(30, 20);
                anim.GoodAnswer(15, 52, 100);
                //drawer.printTextArt(30, 20, "TELIBE", AsciiDrawer.ART_SIZE_HUGE);
                TimeUnit.SECONDS.sleep(3);
            } else {
                //placeholder
                term.clearScreen();
                drawer.printTextArt(70, 15, ": (", AsciiDrawer.ART_SIZE_HUGE);
                TimeUnit.SECONDS.sleep(3);
            }
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