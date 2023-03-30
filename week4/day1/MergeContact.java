package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) {
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		// Click on contacts Button
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();
		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text() = 'Merge Contacts']")).click();
		// Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@id = 'widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		// Click on First Resulting Contact
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("//div[contains(@class ,'x-grid3-cell-inner x-grid3-col-partyId')]/a")).click();
		// Click on Widget of To Contact
		driver.switchTo().window(windowList.get(0));
		driver.findElement(By.xpath("//table[@id = 'widget_ComboBox_partyIdTo']/following-sibling::a")).click();
		// Click on Second Resulting Contact
		windowHandles = driver.getWindowHandles();
		windowList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("(//div[contains(@class ,'x-grid3-cell-inner x-grid3-col-partyId')]/a)[2]"))
				.click();
		driver.switchTo().window(windowList.get(0));
		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text() = 'Merge']")).click();
		// Accept the Alert
		driver.switchTo().alert().accept();
		// Verify the title of the page
		System.out.println("Page Title: " + driver.getTitle());
		driver.close();
	}

}
