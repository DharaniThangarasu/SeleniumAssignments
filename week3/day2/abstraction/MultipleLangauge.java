package week3.day2.abstraction;

public abstract class MultipleLangauge implements Language, TestTool {
	public void python() {
		System.out.println("Python is a high-level, general-purpose programming language");
	}

	public abstract void ruby();
}
