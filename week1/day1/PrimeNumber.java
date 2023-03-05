package week1.day1;

public class PrimeNumber {

	public static void main(String[] args) {
//		Iterate through all numbers from 2 to n-1 (input) and 
//		for every number check if it divides n (input). 
//		If we find any number that divides, print prime.
//		If nothing divides, then print non-prime
		int n = -15;
		boolean isPrime = true;
		if (n <= 1) 
		{
			isPrime = false;
		} 
		else 
		{
			for (int i = 2; i < n; i++) 
			{
				if (n % i == 0) 
				{
					isPrime = false;
					break;
				}
			}
		}
		if (isPrime)
				System.out.println(n + " is a prime number");
		else
				System.out.println(n + " is not a prime number");
		}

}
