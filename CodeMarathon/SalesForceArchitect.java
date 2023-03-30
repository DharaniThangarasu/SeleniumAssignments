package CodeMarathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForceArchitect {

	public static void main(String[] args) throws IOException {
		// Launch Salesforce application https://login.salesforce.com/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		// Login with Provided Credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		// Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowsList.get(1));
		driver.findElement(By.xpath("//button[text() ='Confirm']")).click();
		// Click On Learning
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text() ='Learning']").click();	
		// And mouse hover on Learning On Trailhead
		Actions builder = new Actions(driver);
		builder.moveToElement(dom.findElementByXPath("//span[text() ='Learning on Trailhead']")).perform();	
		// Click on Salesforce Certifications
		dom.findElementByXPath("//a[text() ='Salesforce Certification']").click();
		// Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("//div[text() ='Architect']")).click();
		// Get the Text(Summary) of Salesforce Architect
		System.out.println("Summary of Salesforce Architect : " + '\n' + driver.findElement(By.xpath("//div[contains(@class,'cert-site_text')]")).getText());
		// Get the List of Salesforce Architect Certifications Available
		List<WebElement> certificateList = driver.findElements(By.className("credentials-card_title"));
		System.out.println("List of Salesforce Architect Certifications Available : ");
		for(WebElement each : certificateList)
		{
			System.out.println(each.getText());
		}
		// Click on Application Architect
		driver.findElement(By.xpath("//a[text() ='Application Architect']")).click();
		// Get the List of Certifications available
		System.out.println("List of Salesforce Application Architect Certifications Available : ");
		certificateList = driver.findElements(By.className("credentials-card_title"));
		for(WebElement each : certificateList)
		{
			System.out.println(each.getText());
		}
		// Take a Snapshot of Certifications.
		builder.scrollToElement(driver.findElement(By.xpath("(//div[@class ='credentials-card_description'])[4]"))).perform();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/Architect.png");
		FileUtils.copyFile(source, dest);
		builder.scrollToElement(driver.findElement(By.xpath("(//div[@class ='credentials-card_description'])[8]"))).perform();
		source = driver.getScreenshotAs(OutputType.FILE);
		dest = new File("./snaps/Architect1.png");
		FileUtils.copyFile(source, dest);
	}

}
