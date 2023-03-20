package week3.day2;

import java.util.*;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		// Input
		String text = "Madam";
		boolean isUnique;
		text = text.toLowerCase();
		// Create a empty Set Using TreeSet
		Set<Character> unique = new TreeSet<>();
		// Convert String to Character array
		char[] charArray = text.toCharArray();
		// Iterate through the array
		for (int i = 0; i < charArray.length; i++) {
			// Add each character to the Set
			isUnique = unique.add(charArray[i]);
			// Remove the character if it is already present
			if (!isUnique)
				unique.remove(charArray[i]);
		}
		// Print the set
		System.out.println("Unique character in the given array : " + unique);
	}

}
