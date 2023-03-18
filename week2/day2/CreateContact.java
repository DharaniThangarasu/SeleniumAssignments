package week2.day2;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

public static void main(String[] args) throws Exception {
		
		/*
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 2. Enter UserName and Password Using Id Locator
		 * 3. Click on Login Button using Class Locator
		 * 4. Click on CRM/SFA Link
		 * 5. Click on contacts Button
		 * 6. Click on Create Contact 
		 * 7. Enter FirstName Field Using id Locator
		 * 8. Enter LastName Field Using id Locator
		 * 9. Enter FirstName(Local) Field Using id Locator
		 * 10. Enter LastName(Local) Field Using id Locator
		 * 11. Enter Department Field Using any Locator of Your Choice
		 * 12. Enter Description Field Using any Locator of your choice 
		 * 13. Enter your email in the E-mail address Field using the locator of your choice
		 * 14. Select State/Province as NewYork Using Visible Text
		 * 15. Click on Create Contact
		 * 16. Click on edit button  
		 * 17. Clear the Description Field using .clear
		 * 18. Fill ImportantNote Field with Any text
		 * 19. Click on update button using Xpath locator
		 * 20. Get the Title of Resulting Page.
         */
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
		// Click on Create Contact
		driver.findElement(By.xpath("//a[text() ='Create Contact']")).click();
		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Sample");
		// Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Text");
		// Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Sample_Local");
		// Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Text_Local");
		// Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Testing");
		// Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys("Automating the test case");
		// Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc@gmail.com");
		//Select State/Province as NewYork Using Visible Text
		Select state = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		state.selectByVisibleText("New York");
		// Click on Create Contact
		driver.findElement(By.className("smallSubmit")).click();
		// Click on edit button  
		driver.findElement(By.xpath("//a[text()= 'Edit']")).click();
		// Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
		// Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Updated the contact");
		// Click on update button using Xpath locator
		driver.findElement(By.xpath("//textarea[@id = 'updateContactForm_importantNote']/following::input")).click();
		// Get the Title of Resulting Page.
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
}
}
