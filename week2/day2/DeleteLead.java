package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) {
		/*http://leaftaps.com/opentaps/control/main
		 
		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
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
		//Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("98");
		//Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		//Capture lead ID of First Resulting lead
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'98')]/preceding::a[5]"));
		String leadId = element.getText();
		System.out.println(leadId);
		//Click First Resulting lead
		element.click();
		//Click Delete
		driver.findElement(By.linkText("Delete")).click();
		//Click Find leads
		driver.findElement(By.xpath("//a[contains(text(), 'Find')]")).click();
		//Enter captured lead ID
		driver.findElement(By.xpath("//input[@name = 'id']")).sendKeys(leadId);
		//Click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		if(driver.findElement(By.xpath("//div[contains(text(), 'No records')]")).getText().equals("No records to display"))
			System.out.println("Deletion sucess");
		else
			System.out.println("Deletion unsucess");
		//Close the browser (Do not log out)
		driver.close();
	}

}
