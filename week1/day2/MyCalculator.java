package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		// Create an object for the class Calculator.
		Calculator obj = new Calculator();
		// Access the addition method and print the values.
		System.out.println("Addition:" + obj.add(1, 5, 18));
		// Access the multiplication method and print the values.
		System.out.println("Multiplication: " + obj.multiply(13.45f, 18.9f));
		// Access the subtraction method.
		obj.sub();
	}

}
