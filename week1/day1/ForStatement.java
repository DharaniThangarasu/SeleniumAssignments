package week1.day1;

public class ForStatement {

	public static void main(String[] args) {
		System.out.println("Odd Numbers between 1 to 20");
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
	}

}
