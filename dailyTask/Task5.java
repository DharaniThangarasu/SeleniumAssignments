package dailyTask;

public class Task5 {
	/*
	 * A happy number is a number defined by the following process:
	 * 
	 * Starting with any positive integer, replace the number by the sum of the
	 * squares of its digits. Repeat the process until the number equals 1 (where it
	 * will stay), or it loops endlessly in a cycle which does not include 1. Those
	 * numbers for which this process ends in 1 are happy.
	 */
	public int happyNumbers(int input) {
		int rem = 0;
		int sum = 0;
		while (input > 0) {
			rem = input % 10;
			sum = (rem * rem) + sum;
			input = input / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Task5 obj = new Task5();
		int num = 56;
		int result = num;
		while (result != 1 && result != 4) {
			result = obj.happyNumbers(result);
		}

		// Happy number always ends with 1
		if (result == 1)
			System.out.println(num + " is a happy number");
		// Unhappy number ends in a cycle of repeating numbers which contains 4
		else if (result == 4)
			System.out.println(num + " is not a happy number");
	}
}
