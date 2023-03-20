package week3.day2.abstraction;

public class Automation extends MultipleLangauge {
	@Override
	public void Java() {
		System.out.println("Java is a high-level, class-based, object-oriented programming language");
	}

	@Override
	public void Selenium() {
		System.out.println("Selenium is an open-source tool that automates web browsers");
	}

	@Override
	public void ruby() {
		System.out.println("Ruby is an interpreted, high-level, general-purpose programming language ");
	}

	public static void main(String[] args) {
		Automation obj = new Automation();
		obj.Java();
		obj.python();
		obj.ruby();
		obj.Selenium();
	}

}
