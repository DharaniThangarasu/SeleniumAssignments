package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DuplicateLead {

	public static void main(String[] args) throws Exception {
		/*http://leaftaps.com/opentaps/control/main		 
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)		
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
		//Click Find leads
		driver.findElement(By.xpath("//a[contains(text(), 'Find')]")).click();
		//Click on Email
		driver.findElement(By.xpath("//span[text() = 'Email']")).click();
		//Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("abc@gmail.com");
		//Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		//Capture name of First Resulting lead
		String name = driver.findElement(By.xpath("//a[contains(text(),'abc@gmail.com')]/preceding::a[3]")).getText();
		Thread.sleep(2000);
		//Click First Resulting lead
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]//a")).click();
		//Click Duplicate Lead
		WebElement duplicateLead = driver.findElement(By.linkText("Duplicate Lead"));
		String text = duplicateLead.getText();
		duplicateLead.click();		
		//Verify the title as 'Duplicate Lead'
		if(text.equals("Duplicate Lead"))
			System.out.println("The title is Duplicate Lead ");
		else
			System.out.println("Invalid Title");
		//Click Create Lead
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(2000);
		//Confirm the duplicated lead name is same as captured name
		if(driver.findElement(By.id("viewLead_firstName_sp")).getText().equals(name))
			System.out.println("Duplicated successfully");
		else
			System.out.println("Duplication failed");
		//Close the browser
		driver.close();
	}

}
