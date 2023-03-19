package week3.Day1;

public class Palindrome {
	/*
	 * Pseudo Code
	
	 * a) Declare A String value as"madam"	 
	 * b) Declare another String rev value as ""
	 * c) Iterate over the String in reverse order
	 * d) Add the char into rev
	 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
	 
	 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
	 */
	public static void main(String[] args) {
		// Declare A String value as"madam"
		String str = "Madam";
		// Declare another String rev value as ""
		String newString = "";
		char ch;
		// Iterate over the String in reverse order
		for (int i = str.length() - 1; i >= 0; i--) {
			// Add the char into rev
			ch = str.charAt(i);
			newString = newString + ch;
		}
		// Compare the original String with the reversed String, if it is same then
		// print palinDrome
		if (newString.equalsIgnoreCase(str))
			System.out.println(str + " is palindrome");
		else
			System.out.println(str + " is not palindrome");
	}

}
