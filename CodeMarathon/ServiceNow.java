package CodeMarathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {

	public static void main(String[] args) throws IOException {
		// Launch ServiceNow application
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://dev57553.service-now.com/");
		// Login with valid credentials username as admin and password
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2oaD6KN$q$vN");
		driver.findElement(By.id("sysverb_login")).click();
		// Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[@id = 'all']").click();
		dom.setImplicitWait(10);
		//dom.findElementByXPath("//input[@id ='filter']").sendKeys("Service catalog");
		dom.findElementByXPath("//span[text() = 'Service Catalog']").click();
		// Click on mobiles
		driver.switchTo().frame(dom.findElementByXPath("//iframe[@id = 'gsft_main']"));
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		// Select Apple iphone6s
		driver.findElement(By.xpath("//strong[text() = 'Apple iPhone 6s']")).click();
		// Update color field to gold and storage field to 128GB
		Select color = new Select(driver.findElement(By.xpath("(//select[contains(@class ,'cat_item_option ')])[2]")));
		color.selectByVisibleText("Gold");
		color = new  Select(driver.findElement(By.xpath("(//select[contains(@class ,'cat_item_option ')])[3]")));
		color.selectByValue("onetwentyeight");
		// Click on Order now option
		driver.findElement(By.id("oi_order_now_button")).click();
		// Verify order is placed and copy the request number"
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'notification-success')]/span")).getText());
		System.out.println("Request number : " + driver.findElement(By.id("requesturl")).getText());	
		// Take a Snapshot of order placed page.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/servicenow.png");
		FileUtils.copyFile(source, dest);
	}

}
