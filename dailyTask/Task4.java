package dailyTask;

import java.util.*;

public class Task4 {
	/*
	 * Given a non-empty array of integers nums, every element appears twice except
	 * for one. Find that single one.Given a non-empty array of integers nums, every
	 * element appears twice except for one. Find that single one.
	 */
	public void repeatNumber(int [] input) {
		Set<Integer>  dataSet = new TreeSet<>();
		for(Integer data : input)
		{
			boolean isUnique= dataSet.add(data);
			if(!isUnique)
				dataSet.remove(data);
		}
		System.out.println("The single element present in array is : " + dataSet);
	}
	public static void main(String[] args) {
		Task4 obj = new Task4();
		int [] input = {2,2,3,4,3};
		//int [] input = {1};
		obj.repeatNumber(input);	
	}

}
