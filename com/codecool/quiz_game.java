package com.codecool;

import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;
import com.codecool.termlib.Direction;
import com.codecool.data_manager.*;
import java.util.*;


public class quiz_game {
    public static void main(String[] args) {
        //Terminal term = new Terminal();
        /* ReadFile read = new ReadFile();
        ArrayList<HashMap<String, String>> questions = read.questions();
        System.out.println(questions.get(0)); */
        newGame();
    }


    public static void newGame() {
        // Loading a new screen
        int Score = 0;
        String player = getPlayerName();
        System.out.println("Welcome "+player+"!");
        System.out.println("Good luck and have fun!");
        // Get array of questions
        for (int questionNumber = 1; questionNumber < 15; questionNumber++) {
            questionCounter(questionNumber);
            try {
                waitForAnswer();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }    
        }

    }

    public static String getPlayerName () {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type in your name!");
        String name = reader.nextLine();
        return name;
    }

    public static void questionCounter(int questionNumber) {
        System.out.println(questionNumber + ". question!");
        System.out.println("Get ready!");
    }

    /*public static boolean checkAnswer() {
        if ( Something ) {
            return false;
        } else {
            return true;
        }
    }*/

    public static void waitForAnswer() throws InterruptedException {
        Thread taskThread = new Thread(counterThread());
        Scanner reader = new Scanner(System.in);
        
        taskThread.start();
        System.out.println("Give me a number!");
        int n = reader.nextInt();
        taskThread.interrupt();  
        taskThread.join(1_000);
        
        
    }

    private static Runnable counterThread() {
        return () -> {
            for (int i = 0; i < 9; i++) {
                try {
                    System.out.println(i);
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    break;                
                }
            }
                       
        };

 }
}