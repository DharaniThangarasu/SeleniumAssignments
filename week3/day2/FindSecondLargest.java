package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		int[] data = { 3, 2, 11, 4, 6, 7, 2, 3, 3, 6, 7 };
		// Create a empty Set Using TreeSet
		Set<Integer> dataSet = new TreeSet<>();
		// Declare for loop iterator from 0 to data.length and add into Set
		for (int num : data) {
			dataSet.add(num);
		}
		// Convert Set into List
		List<Integer> dataList = new ArrayList<>(dataSet);
		// Print the second last element from List
		System.out.println("The second largest number in the array : " + dataList.get(dataList.size() - 2));
	}

}
