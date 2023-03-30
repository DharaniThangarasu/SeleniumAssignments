package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// Launch URL "https://www.amazon.in/"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// search as oneplus 9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		// Get the price of the first product
		WebElement firstProduct = driver.findElement(By.xpath("//span[@class ='a-price-whole']"));
		System.out.println("Price of the first product: " + firstProduct.getText());
		// Print the number of customer ratings for the first displayed product
		System.out.println("Customer ratings for the first displayed product : "
				+ driver.findElement(By.xpath("//div[contains(@class, 'a-row a-size-small') ]/span"))
						.getAttribute("aria-label"));
		// Click the first text link of the first image
		driver.findElement(By.xpath("//a[contains(@class, 'a-link-normal s-no-outline') ]")).click();
		//Take a screen shot of the product displayed
		driver.getScreenshotAs(OutputType.FILE);
		// Click 'Add to Cart' button
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'add-to-cart-button']")).click();
		// Get the cart subtotal and verify if it is correct.
		driver.findElement(By.xpath("//span[text()  = ' Cart ']/preceding-sibling::input[@class= 'a-button-input']"))
				.click();
		System.out.println("Cart subtotal : "
				+ driver.findElement(By.xpath("//span[@id  ='sc-subtotal-amount-buybox']"))
						.getText());
		// close the browser
	}

}
