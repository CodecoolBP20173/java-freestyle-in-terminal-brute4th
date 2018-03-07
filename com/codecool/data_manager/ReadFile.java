package com.codecool.data_manager;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

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

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {
        
        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                                Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
        

    public Map<String, Integer> getScore() {
        ArrayList<String> scoreRaw = readFile("score");
        Map<String, Integer> topScore = new HashMap<String, Integer>();
        
        for (int i = 0; i < scoreRaw.size(); i+=2) {
            topScore.put(scoreRaw.get(i), Integer.parseInt(scoreRaw.get(i+1)));
        }

        Map<String, Integer> sortedTopScore = sortByValue(topScore);

        return sortedTopScore;
    }
}