package week3.Day1;

public class ReverseString {

	public static void main(String[] args) {
		String str = "Amazon";
		char[] charAray = str.toCharArray();
		for (int i = charAray.length -1 ; i >=0 ; i--) {
			System.out.print(charAray[i]);
		}
	}

}
