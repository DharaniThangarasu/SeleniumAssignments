package week1.day2;

import java.util.ArrayList;

public class Solution {
	public static String reverseLetters(String str) {
			if(str.length() != 0)
		{
		char[] arr = str.toCharArray();
		char[] arr2 = new char[arr.length];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			arr2[j] = arr[i];
			j++;
		}
		String reverseString = new String(arr2);
		return reverseString;
		}
		else
			return "Invalid Input";

	}
  public static void main(String[] args) {
    Solution obj = new Solution();
  System.out.println(obj.reverseLetters("ab-cd"));
  }
}
