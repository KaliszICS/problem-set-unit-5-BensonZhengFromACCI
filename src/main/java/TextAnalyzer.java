import java.util.Scanner;
import java.util.HashMap;
/**
        * File: Problem Set 5 

        * Author: Benson Zheng

        * Date Created: May 17th, 2026

        * Date Last Modified: May 18th, 2026

        */
public class TextAnalyzer {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		/// introduces code and prompts input
		System.out.println("Welcome to the Text Analyzer.\n");
		System.out.print("Please enter a sentence or paragraph: ");
		String inWord = input.nextLine();
		///checks for num of spaces, vowels 
		int numSpaces = 0;
		int numVowels = 0;
		/// removes useless words and replaces sets to lower case then trims spaces
		inWord = inWord.toLowerCase().replaceAll("\\b(the|a|an|and|is)\\b", "")
									.replaceAll("[!,.?]", "")
									.replaceAll("\\s+", " ");
		String wordLower = inWord.trim();
		/// characters checked after useless words and puncuation removed
		int numChars = wordLower.length();
		for (int start = 0; start < wordLower.length(); start++) {
			char charCheck = wordLower.charAt(start);
			if (charCheck == ' ') {
				numSpaces++;
			}
			if (charCheck == 'a' || 
				charCheck == 'e' || 
				charCheck == 'i' ||
				charCheck == 'o' || 
				charCheck == 'u') {
				numVowels++;
			}
		}
		String[] words = wordLower.split("\\s+");
		int numWords = words.length;
		HashMap<String, Integer> wordFrequency = new HashMap<>();
		/// loops through every word in array "words"
		for (int start = 0; start < words.length; start++) {
			String word = words[start];
			/// checks if it is empty string 
			/// if hashmap contains the word adds one count the key
			if (!word.isEmpty()) {
				if (wordFrequency.containsKey(word)) {
					wordFrequency.put(word, wordFrequency.get(word) + 1);
				} 
				else {
					wordFrequency.put(word, 1);
				}
			}
		}
		/// Outputs all gathered data
		System.out.println("Total Characters: " + numChars);
		System.out.println("Total Words: " + numWords);
		System.out.println("Total Vowels: " + numVowels);
		System.out.println("Total Spaces: " + numSpaces);
		System.out.println("\nWord Frequency:");
		Object[] keys = wordFrequency.keySet().toArray();
		for (int start = 0; start < keys.length; start++) {
			String word = (String) keys[start];
			System.out.println(word + " - " + wordFrequency.get(word));
		}
	}	
}