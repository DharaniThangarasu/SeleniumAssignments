package week4.day1;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnFrame {

	public static void main(String[] args) {
		// Load the url https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		// Maximize the browser window.
		driver.manage().window().maximize();
		List<WebElement> list = driver.findElements(By.tagName("iframe"));
		System.out.println("tag "+ list.size());
		List<WebElement> list1 = driver.findElements(By.xpath("//iframe"));
		System.out.println("xpath" + list1.size());
		// click Try it button
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text() ='Try it']")).click();
		// Accept the alert
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		// get the text and verify
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframeResult");
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);

	}

}
