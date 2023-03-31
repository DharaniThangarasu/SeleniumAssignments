package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Verification {
	/**
	 * Verify the web elements.
	 */
	public void WebElementVerification() {
		ChromeDriver driver = LaunchApplication();
		// Get the attribute value
		System.out.println("Attribute value: " + driver.findElement(By.id("username")).getAttribute("size"));
		// Get the location of the element
		System.out.println("Location: " + driver.findElement(By.id("username")).getLocation());
		System.out.println("Location X : " + driver.findElement(By.id("username")).getLocation().getX());
		System.out.println("Location Y : " + driver.findElement(By.id("username")).getLocation().getY());
		// Get the size of the element
		System.out.println("size " + driver.findElement(By.id("username")).getSize());
		System.out.println("Height " + driver.findElement(By.id("username")).getSize().getHeight());
		System.out.println("Width " + driver.findElement(By.id("username")).getSize().getWidth());
		// Get the tag name of the element
		System.out.println("size " + driver.findElement(By.id("username")).getTagName());
		// Get the value of css property value
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		System.out.println("Color : " + login.getCssValue("color"));
		System.out.println("Background Color : " + login.getCssValue("background-color"));
		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login
		driver.findElement(By.className("decorativeSubmit")).click();
		// Get the visible inner text of the element.
		System.out.println("Visible Inner Text" + driver.findElement(By.partialLinkText("CRM/SFA")).getText());
		// Click on Leads
		driver.findElement(By.linkText("Leads")).click();
		// Click on CreateLead Link
		driver.findElement(By.linkText("Create Lead")).click();
		boolean isSelected = driver.findElement(By.id("createLeadForm_marketingCampaignId")).isSelected();
		driver.close();
	}

	public void BrowserVerification() {
		ChromeDriver driver = LaunchApplication();
		// Get the title of the current page.
		System.out.println(driver.getTitle());
		// Get the url of the current page
		System.out.println(driver.getCurrentUrl());
		// Get the source of the page
		System.out.println(driver.getPageSource());
		driver.close();
	}

	public ChromeDriver LaunchApplication() {
		// Launch URL "http://leaftaps.com/opentaps/control/main/"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/main/");
		// Maximize the browser window.
		driver.manage().window().maximize();
		return driver;
	}

	public static void main(String[] args) {
		Verification obj = new Verification();
		// obj.WebElementVerification();
		obj.BrowserVerification();

	}

}
