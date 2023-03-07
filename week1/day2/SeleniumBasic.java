package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasic {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
}
