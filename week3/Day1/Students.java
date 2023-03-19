package week3.Day1;

public class Students {
	public void getStudentInfo(String id) {
		System.out.println("Student ID : " + id);
	}

	public void getStudentInfo(String id, String name) {
		System.out.println("Student ID : " + id);
		System.out.println("Student Name : " + name);
	}

	public void getStudentInfo(String email, long num) {
		System.out.println("Student E-mail : " + email);
		System.out.println("Student Phone number : " + num);
	}

	public static void main(String[] args) {
		Students obj = new Students();
		obj.getStudentInfo("23ECE56");
		obj.getStudentInfo("23ECE45", "John");
		obj.getStudentInfo("abc@gmail.com", 6478238203l);
	}

}
