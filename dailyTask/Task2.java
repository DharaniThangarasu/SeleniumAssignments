package dailyTask;

public class Task2 {
 
	public static double sqrt(double x) {
	    if (x < 0) {
	        throw new IllegalArgumentException("Cannot find square root of a negative number");
	    }

	    double guess = x / 2.0;
	    double prevGuess;

	    do {
	        prevGuess = guess;
	        guess = (guess + x / guess) / 2.0;
	    } while (Math.abs(guess - prevGuess) > 1e-9);

	    return guess;
	}

	public static void main(String[] args) {
		Task2 obj = new Task2();
		System.out.println(obj.sqrt(8));

	}

}
