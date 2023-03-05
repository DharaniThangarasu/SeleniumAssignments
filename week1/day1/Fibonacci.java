package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		int firstNum = 0, secoundNum = 1, sum = 0;
		System.out.println("Fibonacci series for first 11 numbers");
		for (int i = 1; i <= 11; i++) {
			System.out.println(firstNum);
			sum = firstNum + secoundNum;
			firstNum = secoundNum;
			secoundNum = sum;
		}
	}

}
