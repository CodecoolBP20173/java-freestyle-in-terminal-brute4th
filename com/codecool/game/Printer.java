package com.codecool.game;

import com.codecool.termlib.Terminal;
import com.codecool.termlib.Direction;
import com.codecool.data_manager.*;

import java.util.*;


public class Printer {

    //terminal command: tput cols
    int cols=183;
    //terminal command: tput lines
    int lines=52;

    public void displayQuestionsAnswers(HashMap hm){
        String question = hm.get("question").toString();
        String answer1 = hm.get("a1").toString();
        String answer2 = hm.get("a2").toString();
        String answer3 = hm.get("a3").toString();
        String answer4 = hm.get("a4").toString();

        int refX=(cols/2);
        int refY=lines-15;

        Terminal pt = new Terminal();
        pt.clearScreen();
        pt.moveTo(refX -(question.length()/2), refY);
        System.out.print(question);
        pt.moveTo(refX - 35, refY + 6);
        System.out.print("1. " + answer1);
        pt.moveTo(refX + 35, refY + 6);
        System.out.print("2. " + answer2);
        pt.moveTo(refX - 35, refY + 13);
        System.out.print("3. " + answer3);
        pt.moveTo(refX + 35, refY + 13);
        System.out.println("4. " + answer4);
        drawBox(refX, refY, "large");
        drawBox(refX -35, refY + 6, "small");
        drawBox(refX +35, refY + 6, "small");
        drawBox(refX -35, refY + 13, "small");
        drawBox(refX +35, refY + 13, "small");

        pt.moveTo(0, lines);
    }

    public void drawBox(int x, int y, String size){
        Terminal pt = new Terminal();
        
        int boxWidth = 0;
        int boxHeight = 0;

        switch(size){
            case "large":
                boxWidth = 100;
                boxHeight = 6; 
                break;
            case "small":  
                boxWidth = 40;
                boxHeight = 4; 
                break;
        }
        
        String horizontalLine = new String(new char[boxWidth]).replace("\0", "_");
        pt.moveTo(x-boxWidth/2, y - (boxHeight/2));
        System.out.print(horizontalLine);
        pt.moveTo(x-boxWidth/2, y + (boxHeight/2-1));
        System.out.print(horizontalLine);
        pt.moveTo(x-boxWidth/2, y - (boxHeight/2)+1);
        for (Integer i=0; i<boxHeight-1; i++) {
            System.out.println("|");
            pt.moveCursor("C", x-boxWidth/2-1);
        }
        pt.moveTo(x + boxWidth/2, y - (boxHeight/2)+1);
        for (Integer i=0; i<boxHeight-1; i++) {
            System.out.println("|");
            pt.moveCursor("C", x + boxWidth/2-1);
        }
    }

    public void displayTopScore(int amount) {
        ReadFile read = new ReadFile();
        Map<String, Integer> topScore = read.getScore();
        int count = 0;
        for (String name : topScore.keySet()) {
            if (count >= amount) break;
            System.out.println(name + ": " + topScore.get(name));
            }
        
    }
}