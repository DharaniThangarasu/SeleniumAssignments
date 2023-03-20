package week3.day2;

import java.util.*;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// Declare a String as "PayPal India"
		String text = "PayPal India";
		// Convert it into a character array
		char[] charArray = text.toCharArray();
		// Declare a Set as charSet for Character
		Set<Character> charSet = new LinkedHashSet<>();
		// Iterate character array and add it into charSet
		for (char ch : charArray) {
			charSet.add(ch);
		}
		// Iterate using charSet
		for (Character ch : charSet) {
			// Check the iterator variable isn't equals to an empty space
			if (!(ch.equals(' ')))
				System.out.print(ch);
		}
	}

}
