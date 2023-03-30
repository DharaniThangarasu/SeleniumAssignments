package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Launch https://www.snapdeal.com/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");		
		//Go to Mens Fashion
		WebElement mens = driver.findElement(By.xpath("//span[contains(text() ,'Fashion')]"));
		Actions act = new Actions(driver);
		act.moveToElement(mens).perform();		
		//Go to Sports Shoes
		driver.findElement(By.xpath("//span[text() ='Sports Shoes']")).click();
		//Get the count of the sports shoes
		System.out.println("count of the sports shoes" + driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText());
		//Click Training shoes

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		//Sort by Low to High
		driver.findElement(By.xpath("//span[text() = 'Sort by:']")).click();
		driver.findElement(By.xpath("//li[@class ='search-li']")).click();
		// Check if the items displayed are sorted correctly
//		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
//		String item1 = elements.get(0).getText();
//		String lastItem = elements.get(elements.size() -1).getText();
//			System.out.println(item1 + "-" + lastItem);
		//Select the price range (900-1200)
		WebElement priceFrom = driver.findElement(By.xpath("//input[@name ='fromVal']"));
		priceFrom.clear();
		priceFrom.sendKeys("590");
		WebElement priceTo = driver.findElement(By.xpath("//input[@name ='toVal']"));
		priceTo.clear();
		priceTo.sendKeys("700");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		//Filter with color Navy 
		Thread.sleep(3000);
		Actions builder = new Actions(driver);
		WebElement scrollele = driver.findElement(By.className("feedback-txt"));
		builder.scrollToElement(scrollele).perform();
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		//verify the all applied filters 
		System.out.println(driver.findElement(By.xpath("//div[@class='filters']//div")).getText());
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("(//div[@class='filters']//div)[2]")).getText());
		//Mouse Hover on first resulting Training shoes
		builder.moveToElement(driver.findElement(By.xpath("//p[@class='product-title']"))).perform();
		//click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		// Print the cost and the discount percentage
		System.out.println("Cost" + driver.findElement(By.xpath("//div[contains(@class,'product-price pdp-e-i-PAY-l')]")).getText());
		//Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snapdeal.png");
		FileUtils.copyFile(source, dest);
		// Close the current window
		driver.quit();


	}

}
