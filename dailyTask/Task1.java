package dailyTask;

public class Task1 {
	/*
	 * Given a string s consisting of words and spaces, return the length of the
	 * last word in the string.
	 */
	public void lastWordLength(String input) {
		String[] splitText = input.split(" ");
		int length = splitText.length;
		int lastWordLength = splitText[length - 1].length();
		System.out.println("The length of the last word in a string " + input + "is : " + lastWordLength);
	}

	public static void main(String[] args) {
		Task1 obj = new Task1();
		obj.lastWordLength("Hello World");
		obj.lastWordLength("   fly me   to   the moon  ");
		obj.lastWordLength("luffy is still joyboy");
	}

}
