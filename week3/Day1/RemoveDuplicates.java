package week3.Day1;

public class RemoveDuplicates {
	
	/*
	 * Pseudo code 
	 
	 * a) Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";		
	 * b) Initialize an integer variable as count	  
	 * c) Split the String into array and iterate over it 
	 * d) Initialize another loop to check whether the word is there in the array
	 * e) if it is available then increase and count by 1. 
	 * f) if the count > 1 then replace the word as "" 
	 
	 * g) Displaying the String without duplicate words	
	 */
	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		//Initialize an integer variable as count	 
		int count = 0;
		//Split the String into array and iterate over it 
		String[] splitText = text.split(" ");		
		for (int i = 0; i < splitText.length; i++) {
			//Initialize another loop to check whether the word is there in the array
			for (int j = i + 1; j < splitText.length; j++) {
				//if it is available then increase and count by 1 and replace the word as "" 
				if (splitText[i].equalsIgnoreCase(splitText[j]))
					if (i != j) {
						splitText[j] = "";
						count++;
					}
			}
		}
		// Displaying the String without duplicate words	
		System.out.println("Removing Duplicate words:\n");
		if (count > 1) {
			for (int i = 0; i < splitText.length; i++) {
				if (splitText[i] != "") {
					System.out.print(splitText[i] + " ");

				}
			}
		} else
			System.out.println(text);
	}

}
