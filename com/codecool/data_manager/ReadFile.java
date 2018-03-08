package com.codecool.data_manager;

import java.io.*;
import java.util.*;

public class ReadFile {
    public ArrayList<String> readFile(String file) {

        // The name of the file to open.
        String fileName = file + ".txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            ArrayList<String> dataFromFile = new ArrayList<String>();

            while((line = bufferedReader.readLine()) != null) {
                dataFromFile.add(line);
            }   
        
            // Always close files.
            bufferedReader.close();    
            return dataFromFile;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

    ArrayList<String> datat = new ArrayList<String>();
    String str="vmi";
    datat.add(str);
    return datat;
    }

    public  ArrayList<HashMap<String, String>> questions() {
        ArrayList<String> questionList = readFile("questions");
        int length = questionList.size()/6;
        ArrayList<HashMap<String, String>> questions = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < length; i++) {
            HashMap<String, String> question = new HashMap<String, String>();
            question.put("question",new String(questionList.get(1+(i*6))));
            question.put("aGood", questionList.get(2+(i*6)));
            question.put("a1", questionList.get(3+(i*6)));
            question.put("a2", questionList.get(4+(i*6)));
            question.put("a3", questionList.get(5+(i*6)));
            questions.add(question);
        }
        return questions;
    }
}