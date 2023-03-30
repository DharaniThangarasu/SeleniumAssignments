package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// Go to https://www.nykaa.com/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		// Mouseover on Brands and Search L'Oreal Paris
		WebElement brandelement = driver.findElement(By.xpath("//a[text() = 'brands']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(brandelement).sendKeys("L'Oreal Paris").perform();
		// Click L'Oreal Paris
		driver.findElement(By.xpath("//a[contains(text(), 'Paris')]")).click();
		// Check the title contains L'Oreal Paris(Hint-GetTitle)
		if (driver.getTitle().contains("L'Oreal Paris"))
			System.out.println("L'Oreal Paris brand is loaded");
		else
			System.out.println("L'Oreal Paris brand is not loaded");
		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[contains(text() ,'Sort By')]")).click();
		driver.findElement(By.xpath("//span[text() ='customer top rated']")).click();
		// Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text() ='Category']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text() ='Hair']")).click();
		driver.findElement(By.xpath("//span[text() ='Hair']/following::span[text() = 'Hair Care']")).click();
		driver.findElement(By.xpath("//span[text() ='Shampoo']")).click();
		// Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text() ='Concern']")).click();
		driver.findElement(By.xpath("//span[text() ='Color Protection']")).click();
		// check whether the Filter is applied with Shampoo
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		if (text.equals("Shampoo"))
			System.out.println("Filter is applied with Shampoo");
		else
			System.out.println("Filter is not properly applied");
		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(), 'Paris Colour Protect Shampoo')]")).click();
		// GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		// Print the MRP of the product
		System.out.println("MRP of the product: " + driver.findElement(By.className("css-1d0jf8e")).getText());
		// Click on ADD to BAG
		driver.findElement(By.xpath("//span[text() ='Add to Bag']")).click();
		// Go to Shopping Bag
		driver.findElement(By.className("cart-count")).click();
		// Print the Grand Total amount
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='css-acpm4k']")));
		String total = driver.findElement(By.xpath("//span[contains(@class ,'css-1um1mkq')]")).getText();
		System.out.println("Grand Total amount : " + total);
		Thread.sleep(3000);
		// Click Proceed
		driver.findElement(By.xpath("//span[text() = 'Proceed']")).click();
		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[contains(text(),'guest')]")).click();
		// Check if this grand total is the same in step 14
		driver.findElement(By.xpath("//span[contains(@class,'css-175whwo ')]")).click();
		if (driver.findElement(By.xpath("//p[contains(@class,'css-1e59vjt')]")).getText().equals(total))
			System.out.println("Total is same");
		else
			System.out.println("Total is different");
		// Close all windows
		driver.quit();
	}

}
