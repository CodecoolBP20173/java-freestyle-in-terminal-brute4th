package com.codecool.game;

import com.codecool.data_manager.*;
import com.codecool.termlib.Terminal;
import java.util.*;
import com.codecool.game.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class GameControl {
    
    public Printer pr = new Printer();
    
    public static boolean helpHalving = true;
    public static Integer playerScore = 0;
    
    String[] filenames = {"dance", "narwhal.1", "narwhal.2", "narwhal.3"};
    int[] heights = {3, 15, 15, 15};
    int[] frames = {24, 13, 13, 28};
    int[] sleep = {150, 150, 150, 150};
    int[] x = {0, 65, 65, 65};
    int[] y = {30, 30, 30, 30};
    int numberOfQuestions=6;
    public static String username = "";    

    public String welcomePage() {
        username = pr.displayWelcomePage();
        return username;
    }

    public String getUsername(){
        return username;
    }

    public void mainGame() throws Exception{
        ReadFile read = new ReadFile();
        ConsoleIn consoleInputStream = new ConsoleIn();
        Terminal term = new Terminal();
        AsciiDrawer drawer = new AsciiDrawer();

        ArrayList<HashMap<String, String>> questions = read.questions();
        ArrayList<Integer> questionOrder = randNumberList(numberOfQuestions);
         
        for (int num : questionOrder) {
            int userInput;
            pr.displayQuestionsAnswers(questions.get(num), false);
            userInput = consoleInputStream.askInputInt(" Select option: ");
            if (userInput == 5) {
                updateScore(-20);
                toggleHelpHalving();
                pr.displayQuestionsAnswers(questions.get(num), true);
                userInput = consoleInputStream.askInputInt(" Select option: ");
                }
            int solution = pr.getCorrectAnswer();
            if(userInput == solution){
                updateScore(100);
                int index = new Random().nextInt(filenames.length);
                term.clearScreen();
                Animation a = new Animation();
                a.AnswerAnimation(filenames[index], heights[index], frames[index], sleep[index], x[index], y[index]);
                TimeUnit.SECONDS.sleep(1);
            } else {
                updateScore(-50);
                term.clearScreen();
                Animation a = new Animation();
                a.AnswerAnimation("fail", 8, 9, 400, 0, 30);
                TimeUnit.SECONDS.sleep(3);
            }
        }
        WriteFile save = new WriteFile();
        save.saveScore(username, playerScore);

        endScreen();
            
    }

    public void endScreen() {
        pr.displayEndScreen(username, playerScore);
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

    public void setUser(){
        ConsoleIn consoleInputStream = new ConsoleIn();
        username = consoleInputStream.askInputString(" Type your name: ");
    }

    public boolean getHelpHalving(){
        return helpHalving;
    }

    public void toggleHelpHalving(){
        helpHalving = !helpHalving;
    }

    public void updateScore(Integer points){
        playerScore += points;
    }

    public Integer getScore(){
        return playerScore;
    }
}