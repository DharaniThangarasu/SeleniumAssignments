package week3.Day1;

public class ReverseEvenWords {
	/*
	 * Pseudo Code:
	 * 
	 * 1.Declare the input as Follow String test = "I am a software tester"; 
	 * 2. split the words and have it in an array 
	 * 3. Traverse through each word (using loop)
	 * 4. find the odd index within the loop (use mod operator)
	 * 5.print the even position words in reverse order using another loop (nested loop) 
	 * 6. Convert words to character array if the position is even else print the word as it is(concatenate space at the end). 
	 */
	public static void main(String[] args) {
		// Declare the input as Follow String test = "I am a software tester"
		String test = "I am a software tester";
		// split the words and have it in an array
		String[] splitString = test.split(" ");
		// Traverse through each word (using loop)
		for (int i = 0; i < splitString.length; i++) {
			// find the odd index within the loop (use mod operator)
			if (i % 2 == 0)
				System.out.print(splitString[i] + " ");
			// print the even position words in reverse order using another loop (nested
			// loop)
			else {
				//Convert words to character array
				char[] charArray = splitString[i].toCharArray();
				for (int j = charArray.length - 1; j >= 0; j--) {
					System.out.print(charArray[j]);
				}
				System.out.print(" ");
			}
		}

	}

}
