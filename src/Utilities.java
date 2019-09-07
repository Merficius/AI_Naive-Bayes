import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Utilities {
	String[] uniqueWords;
	
	//separates words of a string and eliminates equals
	public void createMap(String words, HashMap uniqueWordsMap, HashMap fill) {
		String[] temp = words.split(" ");
		for (String word : temp) {
			int count = fill.containsKey(word) ? (int) fill.get(word) : 0;
			fill.put(word, count + 1);
			uniqueWordsMap.put(word, 0);
		}
		
	}
	
	//Returns a string containing separated words by spaces
	public String words(String file) {
		String words = "";
		try {
			Scanner read = new Scanner(new File(file));
			read.useDelimiter("\\s*[^a-zA-Z0-9]\\s*");//checks for only a-z characters and digits
			String temp;
			while (read.hasNext()) {
				temp = read.next();
				if (!temp.equals("")) {
					words += temp + " ";
				}
			}
			read.close();
			return words;
		}
		
		catch (IOException error) {
			System.out.println(error);
		}
		return words;
	}
	
	
}// end Utilities - class
