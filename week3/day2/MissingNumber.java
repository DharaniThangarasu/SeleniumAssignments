package week3.day2;

import java.util.*;

public class MissingNumber {

	public static void main(String[] args) {
		// Input
		int[] data = { 1, 2, 9, 3, 4, 5, 6, 7, 1, 2, 3, 5, };
		// Create a empty Set Using TreeSet
		Set<Integer> dataSet = new TreeSet<>();
		// Add all the data in the array to set
		for (int num : data) {
			dataSet.add(num);
		}
		// Convert set to list
		List<Integer> dataList = new ArrayList<>(dataSet);
		// Iterate through the list and find the missing number
		for (int i = dataList.get(0); i < dataList.size(); i++) {
			if (dataList.get(i) != i + 1)
				System.out.println("The missing number is " + (i + 1));
		}
	}

}
