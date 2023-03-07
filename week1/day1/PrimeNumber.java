package week1.day1;

public class PrimeNumber {

	public static void main(String[] args) {
		// Input value.
		int n = 15;
		boolean isPrime = true;
		// If the input number is less than or equal to 1, the number is not a prime number. Set isPrime to false.
		if (n <= 1)
			isPrime = false;
		else {
			// Iterate from 2 until the input number.
			for (int i = 2; i < n; i++) {
				// If the input number is divisible by other numbers , then the number is not a prime number. Set isPrime to false.
				if (n % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		// Check the boolean isPrime and print the output
		if (isPrime)
			System.out.println(n + " is a prime number");
		else
			System.out.println(n + " is not a prime number");
	}

}
