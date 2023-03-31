package practice;

import java.util.Arrays;

public class SampleBasic {
	// Prime number
	public void isPrime(int num) {
		boolean isPrime = true;
		// If the input number is less than or equal to 1, the number is not a prime
		// number. Set isPrime to false.
		if (num <= 1)
			isPrime = false;
		else {
			// Iterate from 2 until the input number.
			for (int i = 2; i < num; i++) {
				// If the input number is divisible by other numbers , then the number is not a
				// prime number. Set isPrime to false.
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		if (isPrime)
			System.out.println(num + "  is prime number");
		else
			System.out.println(num + "  is not a prime number");
	}

	// Factorial
	public int getFactorial(int num) {
		int factorial = 1;
		for (int i = 1; i < num; i++) {
			factorial = factorial * (i + 1);
		}
		return factorial;
	}

	// Armstrong number
	public void isArmStrong(long num) {
		long rem = 0;
		int count = 0;
		long temp = num;
		long sum = 1;
		while (temp > 0) {
			rem = temp % 10;
			temp = temp / 10;
			count++;
		}
		int tempCount = count;
		long tempsum = 0;
		temp = num;
		while (temp > 0) {
			while (tempCount != 0) {
				rem = temp % 10;
				sum = sum * rem;
				tempCount--;
			}
			tempsum += sum;
			sum = 1;
			tempCount = count;
			temp = temp / 10;
		}
		if (tempsum == num)
			System.out.println(num + " is armstrong number");
		else
			System.out.println(num + " is not armstrong number");
	}

	// Sum of the digits
	public int digitsSum(int num) {
		int rem = 0;
		int num1 = 0;
		while (num > 0) {
			rem = num % 10;
			num1 = rem + num1;
			num = num / 10;
		}
		return num1;
	}

	// Swap the number without using third variable
	public void swap(int num1, int num2) {
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		int[] arr = { num1, num2 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println("num" + (i + 1) + "= " + arr[i] + "  ");
		}
	}

// Anagram
	public boolean isAnagram(String input1, String input2) {
		input1 = input1.toLowerCase();
		input2 = input2.toLowerCase();
		char[] arr1 = input1.toCharArray();
		char[] arr2 = input2.toCharArray();
		boolean result = false;
		if (arr1.length == arr2.length) {
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			result = Arrays.equals(arr1, arr2);
		}
		return result;
	}

	// Reverse String
	public String reverseString(String input) {
		if(input.length() != 0)
		{
		char[] arr = input.toCharArray();
		char[] arr2 = new char[arr.length];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			arr2[j] = arr[i];
			j++;
		}
		String reverseString = new String(arr2);
		return reverseString;
		}
		else
			return "Invalid Input";
	}

	public static void main(String[] args) {
		SampleBasic obj = new SampleBasic();
		obj.isPrime(25);
		System.out.println("Factorial of 5 is :" + obj.getFactorial(5));
		obj.isArmStrong(153);
		System.out.println("Summ of the digits of 1024 : " + obj.digitsSum(1024));
		obj.swap(3, 2);
		System.out.println(obj.isAnagram("Post", "Stop"));
		System.out.println("Reverse string of Hello is : " + obj.reverseString("=+"));
	}
}
