package com.codecool.data_manager;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class ReadFile {
    public ArrayList<String> readFile(String file) {

        // The name of the file to open.
        String fileName;
        if (file == "questions") { 
            fileName = "questions.txt";
        } else {
            fileName = "score.txt";
        }

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
                System.out.println(line);
                dataFromFile.add(line);
            }   

            System.out.println(dataFromFile);
        
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
}