package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnAlert {

	public static void main(String[] args) {
		// Load the url https://www.leafground.com/alert.xhtml
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/alert.xhtml");
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Simple alert
		driver.findElement(By.xpath("//span[text() = 'Show']")).click();
		// Switch to alert
		Alert simpleAlert = driver.switchTo().alert();
		String simpleAlertText = simpleAlert.getText();
		System.out.println("Simple Alert Text : " + simpleAlertText);
		// Accept the alert
		simpleAlert.accept();
		// Verify alert is handled
		System.out.println(driver.findElement(By.id("simple_result")).getText());
		// Confirmation alert
		driver.findElement(By.xpath("//h5[contains(text(),'Confirm ')]/following::span[text() = 'Show']")).click();
		// Switch to alert
		Alert confirmAlert = driver.switchTo().alert();
		String confirmAlertText = confirmAlert.getText();
		// Read the text of the Confirmation alert
		System.out.println("Confirmation Alert Text : " + confirmAlertText);
		// Accept the alert
		confirmAlert.dismiss();
		// Confirm whether you have successfully handled the alert
		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
	}

}
