package CodeMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {
	public static void main(String[] args) throws Exception {
		/*
		 * 01) Launch Firefox / Chrome and add implicitlyWait
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		 * 02) Load https://www.redbus.in/ 
		 * 03) Type "Chennai" in the FROM text box 
		 * 04) Click the  first option from the pop up box 
		 * 05) Type "Bangalore" in the TO text box 
		 * 06) Click the first option from the pop up box 
		 * 07) Select tomorrow's date in the Date field 
		 * 08) Click Search Buses 
		 * 09) Print the number of buses shown as results (104 Buses found) (use .getText()) 
		 * 10) Choose SLEEPER in the left menu 
		 * 11) Print the name of the second resulting bus (use .getText()) 
		 * 12) Get the Title of the page(use .getTitle())
		 */
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Type "Chennai" in the FROM text box
		driver.findElement(By.xpath("//input[@id = 'src']")).sendKeys("Chennai");
		// Click the  first option from the pop up box 
		driver.findElement(By.xpath("//li[text() = 'Chennai']")).click();
		//Type "Bangalore" in the TO text box 
		driver.findElement(By.xpath("//input[@id = 'dest']")).sendKeys("Bangalore");
		//Click the first option from the pop up box
		driver.findElement(By.xpath("//li[text() = 'Bangalore']")).click();
		//Select tomorrow's date in the Date field 
		driver.findElement(By.xpath("//td[@class = 'wd day']")).click();
		//Click Search Buses
		driver.findElement(By.id("search_btn")).click();
		//Print the number of buses shown as results (104 Buses found) (use .getText()) 
		System.out.println(driver.findElement(By.xpath("//span[@class = 'f-bold busFound']")).getText());
		Thread.sleep(2000);
		//Choose SLEEPER in the left menu
		//driver.findElement(By.xpath("//input[@id ='bt_SLEEPER']")).click();
		WebElement clc2 = driver.findElement(By.xpath("//input[@id ='bt_SLEEPER']"));
		driver.executeScript("arguments[0].click();", clc2);
		//Print the name of the second resulting bus (use .getText()) 
		System.out.println(driver.findElement(By.xpath("//span[@class = 'f-bold busFound']")).getText());
		//Get the Title of the page(use .getTitle())
		System.out.println(driver.getTitle());
		
		
	}

}
