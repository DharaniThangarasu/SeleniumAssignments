package week3.day2;

import java.util.*;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		// Input
		String text = "We learn java basics as part of java sessions in java week1";
		// Split the text
		String[] splitText = text.split(" ");
		// Create LinkedHashSet
		Set<String> textSet = new LinkedHashSet<>(Arrays.asList(splitText));
		// Iterate through the set and print the words.
		for (String newText : textSet) {
			System.out.print(newText + " ");
		}
	}

}
