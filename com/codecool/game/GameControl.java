package com.codecool.game;

import com.codecool.data_manager.*;
import com.codecool.termlib.Terminal;
import java.util.*;
import com.codecool.game.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class GameControl {
    
    Printer pr = new Printer();
    
    public static boolean helpHalving = true;
    public static Integer playerScore = 0;
    int numberOfQuestions=6;
    public static String username = "";    
    String[] filenames = {"dance", "narwhal"};
    int[] heights = {3, 15};
    int[] frames = {24, 52};
    int[] sleep = {150, 150};
    int[] x = {0, 65};
    int[] y = {30, 30};
    
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

        for (int num = 0; num < questionOrder.size()-1; num++) {
            
            int timer = 20; 
            Integer userInput = 0;
            pr.displayQuestionsAnswers(questions.get(num), false);
            System.out.println(" Select option: ");
            while (true) {
                try {
                    pr.printTimer(timer--);
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    break;                
                }      
                userInput = consoleInputStream.askAnswerInt();
                if (timer <= 0) {
                   userInput = 9;
                   break;
                }
                if (userInput != null) {
                    if (userInput >= 1 && userInput <= 6) {
                        break;
                    } else {
                    //System.out.println(userInput);
                    }
                }
            }

            if (userInput == 6) {
                pr.displayQuestionsAnswers(questions.get(questionOrder.size()-1), false);
                userInput = consoleInputStream.askAnswerInt();
                    if (userInput == 5) {
                        updateScore(-20);
                        toggleHelpHalving();
                        pr.displayQuestionsAnswers(questions.get(questionOrder.size()-1), true);
                        userInput = consoleInputStream.askAnswerInt();
                        }    
            } else if (userInput == 5) {
                updateScore(-20);
                toggleHelpHalving();
                pr.displayQuestionsAnswers(questions.get(num), true);
                userInput = consoleInputStream.askAnswerInt();
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

        //save score here!!!
            
    }

    public ArrayList<Integer> randNumberList(int numberOfQuestions){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<numberOfQuestions; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        ArrayList<Integer> result = new ArrayList<Integer>(list.subList(0, 6));
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
