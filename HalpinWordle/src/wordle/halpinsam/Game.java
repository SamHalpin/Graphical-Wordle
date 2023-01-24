package wordle.halpinsam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {
	private ArrayList<String> words = new ArrayList<>();

	public Game()  {
		try {
		loadWords();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public char[] getLetters(String w) {
		char[] arr = w.toCharArray();
		return arr;
	}
	
	private void loadWords() throws Exception {
	BufferedReader bufReader = new BufferedReader(new FileReader("sgb-words.txt")); 
	String line = bufReader.readLine();
	while (line != null) { 
		words.add(line); 
		line = bufReader.readLine(); 
		} 
	bufReader.close();
	}

	public String getWord() {
		Collections.shuffle(words);
		String word = words.get(0);
		return word;
		
	}

	

}

