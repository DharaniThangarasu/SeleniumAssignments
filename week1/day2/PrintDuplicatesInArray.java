package week1.day2;

import java.util.Arrays;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		// Input array.
		int[] array = { 14, 12, 13, 11, 15, 14, 18, 16, 17, 19, 18, 17, 20 };
		System.out.println("Duplicate elements in given array: ");
		// Sort the array elements
		Arrays.sort(array);
		// Iterate through the elements until the length of the array.
		for (int i = 0; i < array.length - 1; i++) {
			// Compare the current element with the next element
			if (array[i] == array[i + 1])
				// Print the duplicates in the array.
				System.out.println(array[i]);
		}

	}

}
