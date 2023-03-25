package dailyTask;

public class Task3 {
	/*
	 * A phrase is a palindrome if, after converting all uppercase letters into
	 * lowercase letters and removing all non-alphanumeric characters, it reads the
	 * same forward and backward. Alphanumeric characters include letters and
	 * numbers.
	 */
	/**
	 * Check whether the given phrase is palindrome or not
	 * 
	 * @param input phrase to check palindrome
	 */
	public void ispalindrome(String input) {
		input = input.replaceAll("[^a-zA-z0-9]", "");
		String revInput = "";
		char ch;
		for (int i = input.length() - 1; i >= 0; i--) {
			ch = input.charAt(i);
			revInput = revInput + ch;
		}
		if (input.equalsIgnoreCase(revInput))
			System.out.println("The given phrase is palindrome");
		else
			System.out.println("The given phrase is not palindrome");
	}

	public static void main(String[] args) {
		Task3 obj = new Task3();
		obj.ispalindrome("A man, a plan, a canal: Panama");
		obj.ispalindrome("race a car");
		obj.ispalindrome("1 2 3 !Razar $ 321");

	}

}
