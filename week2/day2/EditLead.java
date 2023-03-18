package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLead {

	public static void main(String[] args) throws Exception {
		/*http://leaftaps.com/opentaps/control/main	
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
		*/
		// Launch the browser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Enter UserName and Password
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login Button
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		// Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		// Click Find leads
		driver.findElement(By.xpath("//a[contains(text(), 'Find')]")).click();
		//Enter first name
		driver.findElement(By.xpath("//label[contains(text(),'ID:')]/following::input[@name = 'firstName']")).sendKeys("name");
		//Click Find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		Thread.sleep(2000);
		//Click on first resulting lead 
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]/a")).click();		
		//Verify title of the page
		if(driver.getTitle().equals("View Lead | opentaps CRM"))
			System.out.println("Page title is correct");
		else
			System.out.println("Page title is incorrect");
		//Click Edit
		driver.findElement(By.linkText("Edit")).click();
		//Change the company name
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("Selenium");
		//Click Update
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']/following::input")).click();
		//Confirm the changed name appears
		if(driver.findElement(By.id("viewLead_companyName_sp")).getText().equals("Selenium"))
			System.out.println("Company name changed");
		else
			System.out.println("Edit lead unsucessfull");
		//Close the browser (Do not log out)
		driver.close();
	}

}
