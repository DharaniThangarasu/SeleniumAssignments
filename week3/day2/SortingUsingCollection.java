package week3.day2;

import java.util.Arrays;

public class SortingUsingCollection {

	public static void main(String[] args) {
		// Declare a String array and add the Strings values as (HCL, Wipro, Aspire
		// Systems, CTS)
		String[] array = { "HCL", "Wipro", "Aspire Systems", "CTS" };
		// get the length of the array
		int length = array.length;
		// sort the array
		Arrays.sort(array);
		// Iterate it in the reverse order
		for (int i = length - 1; i >= 0; i--) {
			// print the array
			System.out.println(array[i]);
		}
	}

}
