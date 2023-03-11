package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicLocator {

	public static void main(String[] args) throws Exception {
		/*
		 * 1.Launch the browser 
		 * 2. Launch http://leaftaps.com/opentaps/control/main 
		 * 3.Maximize the browser 
		 * 4. Enter username as DemoCSR 
		 * 5. Enter password as crmsfa
		 * 6. Click on Login 
		 * 7. Click on CRM/SFA
		 *  8. Click on Leads 
		 *  9. Click on CreateLead Link 
		 * 10. Enter the Companyname 
		 * 11. Enter the Firstname 
		 * 12. Enter the Lastname 
		 * 13. Click on CreateLead button
		 */
		// For chrome version above 111
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// Load chrome above version 111
		ChromeDriver driver = new ChromeDriver(options);
		// Load the specific web page in browser.
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Enter username as DemoCSR
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		// Enter password as crmsfa
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on CRM/SFA
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		// Click on Leads
		driver.findElement(By.linkText("Leads")).click();
		// Click on CreateLead Link
		driver.findElement(By.linkText("Create Lead")).click();
		// Enter the Companyname
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		// Enter the Firstname
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sample");
		// Enter the Lastname
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Text");
		// Click on CreateLead button
		driver.findElement(By.className("smallSubmit")).click();
		
	}

}
