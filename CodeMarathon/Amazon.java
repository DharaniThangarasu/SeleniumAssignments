package CodeMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws Exception {
		/*
		 * 01) Launch Chrome 
		 * 02) Load https://www.amazon.in/ 
		 * 03) Type "Bags" in the Search box 
		 * 04) Choose the item in the result (bags for boys)
		 * 05) Print the total number of results (like 40000) 1-48 of over 40,000  results for "bags for boys" 
		 * 06) Select the first 2 brands in the left menu (like American Tourister, Generic) 
		 * 07) Choose New Arrivals (Sort) 
		 * 08) Print the first resulting bag info (name, discounted price) 
		 * 09) Get the page title close the browser(driver.close())
		 */
		// Load https://www.amazon.in/
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Type "Bags" in the Search box
		driver.findElement(By.xpath("//input[@id ='twotabsearchtextbox']")).sendKeys("Bags");
		// Choose the item in the result (bags for boys)
		driver.findElement(By.xpath("//span[text() =' for boys']")).click();
		//Print the total number of results (like 40000) 1-48 of over 40,000  results for "bags for boys" 
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'a-spacing-top-small')]")).getText());
		//Select the first 2 brands in the left menu (like American Tourister, Generic)
		driver.findElement(By.xpath("//a[contains(@class,'a-link-normal')]/span[text() ='American Tourister']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'a-link-normal')]/span[text() ='Skybags']")).click();
		//Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[@class = 'a-dropdown-item']/a[contains(text(),'Arrivals')]")).click();
		//Print the first resulting bag info (name, discounted price)
		System.out.println("Bag Info:");
		System.out.println(driver.findElement(By.xpath("//span[text() ='American Tourister']")).getText());
		System.out.println(driver.findElement(By.xpath("//span[@class ='a-size-base-plus a-color-base a-text-normal']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class ='a-row a-size-base a-color-base']")).getText());
		//Get the page title and close the browser(driver.close())	
		System.out.println(driver.getTitle());
		driver.close();
	}

}
