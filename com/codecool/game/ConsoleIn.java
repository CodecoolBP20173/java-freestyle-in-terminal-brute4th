package com.codecool.game;

import java.util.Scanner;
import java.io.*;

public class ConsoleIn {
    Scanner keyboard = new Scanner(System.in);

    public int askInputInt (String informationText) {
		Boolean error = false;
		String userInp = "";
		do {
			System.out.print(informationText);
			userInp = keyboard.nextLine();
			if (!isType(userInp, "int")) {
				error = true;
				System.err.println("Error: must be a whole number.");
			} else {
				error = false;
			}
		} while (error == true);
		return Integer.parseInt(userInp);
    }

    public static Integer askAnswerInt() {
		try {
            if (System.in.available() > 0) {
                String str = "";
                char c;
                while (true) {
                    c = (char)System.in.read ();
                        if ((c == '\n') || (c == ' ')) {
                        break;
                    }
                    str += c;
                }
                Integer n = new Integer(str.trim());
                return n.intValue();
            }    
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return null;
    } 

    public int askInputChar(String informationText) {
		Boolean error = false;
		String userInp = "";
		do {
			System.out.print(informationText);
			userInp = keyboard.nextLine();
			if (!isType(userInp, "char")) {
				error = true;
				System.err.println("Error: must be a singe character.");
			} else {
				error = false;
			}
		} while (error == true);
		return userInp.charAt(0);
	}

    public Boolean isType(String testStr, String type) {
		try {
			if (type.equalsIgnoreCase("char")) {
				testStr.charAt(0);
			} else if (type.equalsIgnoreCase("int")) {
				Integer.parseInt(testStr);
			} 
			 return true;
		} catch(Exception e) {
			return false;
		}
 
    }
}