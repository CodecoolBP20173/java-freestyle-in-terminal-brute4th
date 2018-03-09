package com.codecool.game;

import com.codecool.termlib.Terminal;
import com.codecool.termlib.Color;
import com.codecool.termlib.Direction;
import com.codecool.data_manager.*;
import com.codecool.game.*;

import java.util.*;

public class Printer {

    Terminal pt = new Terminal();
    ConsoleIn consoleInputStream = new ConsoleIn();

    //terminal command: tput cols
    int cols=183;
    //terminal command: tput lines
    int lines=52;

    int correctAnswer;
    int refX=(cols/2);
    int refY=lines-15;

    public String displayWelcomePage(){
        String question = "Welcome! Please type your name!";
        String input = "Name: ";

        pt.clearScreen();
        displayLogo();
        pt.moveTo(refX -(question.length()/2), refY);
        System.out.print(question);
        drawBox(refX, refY, "large");
        pt.moveTo(refX -(input.length()/2), refY + 6);
        String username = consoleInputStream.askInputString(input);
        return username;
    }

    public void displayQuestionsAnswers(HashMap hm, boolean halving) throws Exception{
        GameControl gc = new GameControl();
        AsciiDrawer drawer = new AsciiDrawer();
        
        //Read question and answers
        String question = hm.get("question").toString();
        String answer1 = hm.get("a1").toString();
        String answer2 = hm.get("a2").toString();
        String answer3 = hm.get("a3").toString();
        String answer4 = hm.get("aGood").toString();

        //randomize answers
        ArrayList<String> randomOrderList = new ArrayList<String>();
        if (!halving) {
        randomOrderList.add(answer1);
        randomOrderList.add(answer2);
        }
        randomOrderList.add(answer3);
        randomOrderList.add(answer4);
        
        Collections.shuffle(randomOrderList);
        correctAnswer = randomOrderList.indexOf(answer4) + 1;

        //display Q&A
        int refX=(cols/2) - 15;
        int refY=lines-15;

        pt.clearScreen();
        displayLogo();
        pt.moveTo(refX -(question.length()/2), refY);
        System.out.print(question);
        pt.moveTo(refX - 45, refY + 6);
        System.out.print("1. " + randomOrderList.get(0));
        pt.moveTo(refX + 15, refY + 6);
        System.out.print("2. " + randomOrderList.get(1));
        if (halving == false) {
        pt.moveTo(refX - 45, refY + 13);
        System.out.print("3. " + randomOrderList.get(2));
        pt.moveTo(refX + 15, refY + 13);
        System.out.println("4. " + randomOrderList.get(3));
        }
        drawBox(refX, refY, "large");
        drawBox(refX -30, refY + 6, "small");
        drawBox(refX +30, refY + 6, "small");
        drawBox(refX -30, refY + 13, "small");
        drawBox(refX +30, refY + 13, "small");

        //display help options
        boolean checkHelpHalving = gc.getHelpHalving();
        boolean checkHelpPass = gc.getHelpPass();

        if (checkHelpHalving || checkHelpPass){
            pt.moveTo(140, 29);
            pt.setUnderline("Available help: ");
            pt.resetStyle();
        } else {
            pt.moveTo(150, 38);
            System.out.print("No more help.");
        }

        if(checkHelpHalving){
            pt. moveTo(140, 31);
            System.out.print("Press 5: ");
            drawer.printTextArt(140, 33, "50 :50", AsciiDrawer.ART_SIZE_SMALL);
        }

        if(checkHelpPass){
            pt. moveTo(140, 44);
            System.out.print("Press 6: ");
            drawer.printTextArt(140, 46, "PASS", AsciiDrawer.ART_SIZE_SMALL);
        }

        //display score
        Integer playerScore = gc.getScore();
        pt.moveTo(160, 3);
        System.out.print("Score: " + playerScore.toString());

        //display name
        String username = gc.getUsername();
        pt.moveTo(140, 3);
        System.out.print("Player: " + username);
        
        pt.moveTo(0, lines); 
    }

    public void drawBox(int x, int y, String size){        
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
        
        String horizontalLine = new String(new char[boxWidth+1]).replace("\0", "_");
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

    public void displayEndScreen(String username, int score) throws Exception{
        String message = "Congratulation " + username + "! Your score is " + score + ".";
        String back = "Press 1 to go back to the main menu!";
        pt.clearScreen();
        displayLogo();
        pt.moveTo(refX -(message.length()/2), refY);
        pt.setColor(Color.GREEN.getColorCode());
        System.out.print(message);
        pt.setColor(Color.DEFAULT.getColorCode());
        drawBox(refX, refY, "large");
        pt.moveTo(refX -(back.length()/2), refY + 6);
        int input = consoleInputStream.askInputInt(back);
        Menu HomeScreen = new Menu();
        if (input == 1) {
            HomeScreen.handleMainMenu();
        }
    }    

    public void displayTopScore(int amount) throws Exception {
        ReadFile read = new ReadFile();
        AsciiDrawer drawer = new AsciiDrawer();

        Map<String, Integer> topScore = read.getScore();
        int count = 0;
        drawer.printTextArt(35, 10, "Top Scores", AsciiDrawer.ART_SIZE_MEDIUM);
        System.out.println();
        System.out.println();

        Integer placement=1;
        for (String name : topScore.keySet()) {
            if (count >= amount) break;
            pt.moveCursor("C", 80);
            System.out.println(placement.toString() + ". " + name + ": " + topScore.get(name));
            placement++;
            }
        pt.moveTo(80, 50);
    }
    public Integer getCorrectAnswer(){
        return correctAnswer;
    }

    public void printTimer(int time){
        Terminal pt = new Terminal();
        pt.moveTo(75, 30);
        System.out.println(" "+ time + " ");
        pt.moveTo(17, lines);
    }

    public void displayLogo(){
        ReadFile txtInput = new ReadFile();
        ArrayList<String> logo = txtInput.readFile("logo");
        pt.setColor(Color.YELLOW.getColorCode());
        pt.moveTo(17, 3);
        for (int i=0; i < logo.size(); i++) {
            pt.moveTo(17, 3+i);
            System.out.println(logo.get(i));
        }
        pt.setColor(Color.DEFAULT.getColorCode());
    }
}