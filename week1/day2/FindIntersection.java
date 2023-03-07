package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {

		// Input arrays
		int array1[] = { 3, 2, 11, 4, 6, 7 };
		int array2[] = { 1, 2, 8, 4, 9, 7 };
		System.out.println("Intersection of two arrays are:");
		// Declare for loop iterator from 0 to array length
		for (int i = 0; i < array1.length; i++) {
			// Declare a nested for another array from 0 to array length
			for (int j = 0; j < array2.length; j++) {
				// Compare Both the arrays using a condition statement
				if (array1[i] == array2[j])
					// Print the first array (should match item in both arrays)
					System.out.println(array1[i]);
			}
		}

	}

}
