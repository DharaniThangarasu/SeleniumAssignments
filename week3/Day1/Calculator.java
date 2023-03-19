package week3.Day1;


public class Calculator {
	public void add(int a, int b) {
		System.out.println(a+b);
	}
	public void add(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	public void multiply(int a, double b){
		System.out.println(a+b);
	}
	public void multiply(double a, double b) {
		System.out.println(a+b);
	}
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.add(2, 3);
		cal.add(2, 78, 123);
		cal.multiply(25, 56.678);
		cal.multiply(12.455, 76.345);
	}

}
