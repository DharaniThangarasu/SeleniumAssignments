package CodeMarathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForceAdmin {

	public static void main(String[] args) throws  IOException {
		//Launch Salesforce application https://login.salesforce.com/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		//Login with username as "hari.radhakrishnan@qeagle.com" and password as "Leaf@123"
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		//Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();	
		//Click confirm on Confirm redirect
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowsList.get(1));
		driver.findElement(By.xpath("//button[text() ='Confirm']")).click();
		// Click Learning 
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text() ='Learning']").click();	
		// And mouse hover on Learning On Trailhead
		Actions builder = new Actions(driver);
		builder.moveToElement(dom.findElementByXPath("//span[text() ='Learning on Trailhead']")).perform();		
		//Clilck on Salesforce Certifications
		dom.findElementByXPath("//a[text() ='Salesforce Certification']").click();
		// Click on first resulting Ceritificate
		driver.findElement(By.xpath("//div[text() ='Administrator']")).click();
		// verify - Administrator Overview page
		if(driver.getTitle().equals("Certification - Administrator Overview"))
			System.out.println("Page is loaded properly");
		else
			System.out.println("Page is not loaded properly");
		//Print the Certifications available for Administrator Certifications (List)
		List<WebElement> cetificateList = driver.findElements(By.xpath("//div[@class ='credentials-card_title']"));
		System.out.println(" Certifications available for Administrator Certifications  : ");
		for(WebElement each:cetificateList)
		{
			System.out.println(each.getText());
		}
		//Take a Snapshot of Certifications.
		builder.scrollToElement(driver.findElement(By.xpath("(//div[@class ='credentials-card_description'])[4]"))).perform();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/salesforce.png");
		FileUtils.copyFile(source, dest);
		
	}

}
