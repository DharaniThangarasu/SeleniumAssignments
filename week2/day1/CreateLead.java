package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		/*
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login" 
		 * 2. Enter UserName and Password Using Id Locator 
		 * 3. Click on Login Button using Class Locator 
		 * 4. Click on CRM/SFA Link 
		 * 5. Click on Leads Button 
		 * 6. Click on Create Lead 
		 * 7. Enter CompanyName Field Using id Locator 
		 * 8. Enter FirstName Field Using id Locator 
		 * 9. Enter LastName Field Using id Locator 
		 * 10. Enter FirstName(Local)Field Using id Locator 
		 * 11. Enter Department Field Using any Locator of Your Choice 
		 * 12. Enter Description Field Using any Locator of your choice 
		 * 13. Enter your email in the E-mail address Field using the locator of your choice 
		 * 14. Select State/Province as NewYork Using Visible Text 
		 * 15. Click on Create Button 
		 * 16. Get the Title of Resulting Page.
		 */
		// Launch URL "http://leaftaps.com/opentaps/control/main/"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/main/");
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		// Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		// Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		// Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sample");
		// Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Text");
		// Enter FirstName(Local)Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Sample");
		// Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		// Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Create the Lead Form");
		// Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@gmail.com");
		// Select State/Province as NewYork Using Visible Text
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selState = new Select(state);
		selState.selectByVisibleText("New York");
		// Click on Create Button
		driver.findElement(By.name("submitButton")).click();
		// Get the Title of Resulting Page.
		System.out.println(driver.getTitle());
	}

}
