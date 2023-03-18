package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FBLogin {
	/*
	 * Step 1: Download and set the path 
	 * Step 2: Launch the chromebrowser
	 * Step 3: Load the URL https://en-gb.facebook.com/ 
	 * Step 4: Maximise the window 
	 * Step 5: Add implicit wait 
	 * Step 6: Click on Create New Account button 
	 * Step 7: Enter the first name 
	 * Step 8: Enter the last name 
	 * Step 9: Enter the mobile number
	 * Step 10:Enter the password 
	 * Step 11: Handle all the three drop downs 
	 * Step 12: Select the radio button "Female"
	 */
	public static void main(String[] args) {
		// Download and set the path
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		// Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver(option);
		// Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Maximise the window
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Click on Create New Account button
		driver.findElement(By.xpath("//a[text() = 'Create new account']")).click();
		// Enter the first name
		driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys("Sample");
		// Enter the last name
		driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("Text");
		// Enter the mobile number
		driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys("1234567890");
		// Enter the password
		driver.findElement(By.xpath("//input[@id= 'password_step_input']")).sendKeys("Sample@123");
		// Handle all the three drop downs
		WebElement day = driver.findElement(By.xpath("//select[@id= 'day']"));
		Select date = new Select(day);
		date.selectByVisibleText("1");
		WebElement month = driver.findElement(By.xpath("//select[@id= 'month']"));
		Select mon = new Select(month);
		mon.selectByVisibleText("Jan");
		WebElement year = driver.findElement(By.xpath("//select[@id= 'year']"));
		Select yr = new Select(year);
		yr.selectByVisibleText("2006");
		// Select the radio button "Female"
		driver.findElement(By.xpath("//label[text ( )='Female']/following-sibling::input")).click();
	}
}
