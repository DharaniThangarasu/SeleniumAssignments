package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchApplication {

	public static void main(String[] args) {
		// For chrome version above 111
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// Load chrome above version 111
		ChromeDriver driver = new ChromeDriver(options);
		// Load chrome before version 111
		// ChromeDriver driver = new ChromeDriver();
		// Load the specific web page in browser.
		driver.get("https://www.facebook.com/");
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Close the current browser
		driver.close();
		// To close all the browser windows
		// driver.quit();
		
		 
	}

}
