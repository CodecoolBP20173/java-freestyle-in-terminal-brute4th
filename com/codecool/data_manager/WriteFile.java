package com.codecool.data_manager;

import java.io.*;

public class WriteFile {

	private static final String FILENAME = "score.txt";

	public void saveScore(String name, int score) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String data = "\n" + name + "\n" + score;

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();

			} catch (IOException ex) {
				ex.printStackTrace();

			}
		}

	}

}