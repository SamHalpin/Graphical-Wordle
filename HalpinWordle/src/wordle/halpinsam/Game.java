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
	/**
	 * get all letters in the word
	 * @param w
	 * @return returns a character array containing the letters
	 */
	public char[] getLetters(String w) {
		char[] arr = w.toCharArray();
		return arr;
	}
	/**
	 * Loads all 5 letter words from the sgb-words.txt file 
	 * @throws Exception
	 */
	private void loadWords() throws Exception {
	BufferedReader bufReader = new BufferedReader(new FileReader("sgb-words.txt")); 
	String line = bufReader.readLine();
	while (line != null) { 
		words.add(line); 
		line = bufReader.readLine(); 
		} 
	bufReader.close();
	}
/**
 * shuffles the list of words and gets the next word
 * @return returns random word
 */
	public String getWord() {
		Collections.shuffle(words);
		String word = words.get(0);
		return word;
		
	}

	

}

