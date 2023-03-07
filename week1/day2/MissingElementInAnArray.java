package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// Input array.
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };
		// Sort the array
		Arrays.sort(arr);
		// Iterate through the array from 0 to length of the array.
		for (int i = arr[0]; i < arr.length; i++) {
			// check if the iterator variable is not equal to the array values respectively
			if (arr[i] != i + 1) {
				// Print the missed element in the array
				System.out.println("Missing element in the array is :" + (i + 1));
				break;
			}
		}
	}
}
