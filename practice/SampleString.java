package practice;

import java.util.Arrays;

public class SampleString {
	// Anagram
	// Two strings are said to be anagram if we can form one string by arranging the
	// characters of another string.
	// For example, Race and Care. Here, we can form Race by arranging the
	// characters of Care.
	public boolean isAnagram(String input1, String input2) {

		input1 = input1.toLowerCase();
		input2 = input2.toLowerCase();
		char[] arr1 = input1.toCharArray();
		char[] arr2 = input2.toCharArray();
		boolean result = false;
		if (arr1.length == arr2.length) {
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			result = Arrays.equals(arr1, arr2);
		}
		return result;
	}

	/*
	 * Reverse the String according to the below rules: All the letters that are
	 * alphabets(upper/lower case) should be reversed All other characters should be
	 * placed as it is
	 */
//	public static String reverseLetters(String str) {
//		char[] arr1 = str.toCharArray();
//		char[] arr2 = new char[str.length()];
//		int j =0;
//		for (int i = arr1.length -1 ; i >=0 ; i--) {
//			/*
//			 * The ASCII value of A is 65. 
//			 * The ASCII value of Z is 90. 
//			 * The ASCII value of a is 97.
//			 * The ASCII value of z is 122.
//			 */
//			if((arr1[i] >=65 && arr1[i] <= 90) || (arr1[i] >=97 && arr1[i] <= 122))
//				arr2[j] = arr1[i];
//			else
//				arr2[i] = arr1[i];
//		}
//
//
//		return str;
//
//	}
	/*
	 * Remove specific character from string
	 */
	public static String removeChar(String str, char ch) {
		String s = Character.toString(ch);
		str = str.replace(s.toLowerCase(), "");
		str = str.replace(s.toUpperCase(), "");
		return str;

	}

	/*
	 * Reverse the words from the String which are in even position.
	 */
	public String reverseEvenWords(String str) {
		String[] splitString = str.split(" ");
		String newString = "";
		String string = "";
		for (int i = 0; i < splitString.length; i++) {
			if (i % 2 == 0)
				newString = splitString[i] + " ";
			else {
				char ch;
				for (int j = 0; j < splitString[i].length(); j++) {
					ch = splitString[i].charAt(j);
					newString = ch + newString;
				}
				newString = newString + " ";
			}
			string = string + newString;
			newString = "";
		}
		return string;
	}

	public boolean palindrome(String str) {
		String newString = "";
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i); // extracts each character
			newString = ch + newString; // adds each character in front of the existing string
		}
		if (newString.toLowerCase().equals(str.toLowerCase()))
			return true;
		else
			return false;
	}

	public int charOccurance(String str, char ch) {
		int count = 0;
		str = str.toLowerCase();
		ch = Character.toLowerCase(ch);
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ch)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		SampleString obj = new SampleString();
//		if (obj.isAnagram("Post", "Stop"))
//			System.out.println("The string are anagram");
//		else
//			System.out.println("The strings are not anagram");
//      System.out.println(obj.removeChar("Testleaf", 't'));
		System.out.println(obj.palindrome("Madam"));
//		System.out.println(obj.reverseEvenWords("I am a software tester"));
//		System.out.println(obj.charOccurance("Welcome to chennai", 'e'));
	}

}
