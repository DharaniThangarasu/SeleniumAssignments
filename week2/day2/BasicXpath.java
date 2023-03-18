package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicXpath {

	public static void main(String[] args) {
		// Launch URL "http://leaftaps.com/opentaps/control/main/"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/main/");
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Enter UserName using attribute based xpath
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("DemoCSR");
		// Enter password using attribute based xpath
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("crmsfa");
		// Click on Login Button using attribute based xpath
		driver.findElement(By.xpath("//input[@class= 'decorativeSubmit']")).click();
		// Click on CRM/SFA Link using partial text based xpath
		driver.findElement(By.xpath("//a[contains (text() , 'CRM')]")).click();
		// Click on Leads Button using text based xpath
		driver.findElement(By.xpath("//a[(text() ='Leads')]")).click();

	}

}
