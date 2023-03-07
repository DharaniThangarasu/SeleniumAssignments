package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		// Initialize first , second number and sum.
		int firstNum = 0, secoundNum = 1, sum = 0;
		System.out.println("Fibonacci series for first 11 numbers");
		// Iterate from 1 upto 11.
		for (int i = 1; i <= 11; i++) {
			// Print the number in the fibonacci series.
			System.out.println(firstNum);
			sum = firstNum + secoundNum;
			// Swap the numbers.
			firstNum = secoundNum;
			secoundNum = sum;
		}
	}

}
