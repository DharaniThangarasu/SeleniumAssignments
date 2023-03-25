package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkbox {

	public static void main(String[] args) throws Exception {
		// Launch URL "https://www.leafground.com/checkbox.xhtml"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/checkbox.xhtml");
		// Maximize the browser window.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Basic Checkbox
		driver.findElement(By.xpath("//span[text()= 'Basic']")).click();
		// Notification
		driver.findElement(By.xpath("//span[text()= 'Ajax']")).click();
		if (driver.findElement(By.className("ui-growl-title")).getText().equals("Checked"))
			System.out.println("Notification poped");
		else
			System.out.println("Nitification not poped");
		// Choose your favorite language(s)
		driver.findElement(By.xpath("//label[text()= 'Java']")).click();
		driver.findElement(By.xpath("//label[text()= 'C-Sharp']")).click();

		// Toggle Switch
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		// Verify if check box is disabled
		boolean isEnabled = driver.findElement(By.name("j_idt87:j_idt102_input")).isEnabled();
		if (isEnabled)
			System.out.println("Button is enabled");
		else
			System.out.println("Button is disabled");
		// Select Multiple
		driver.findElement(By.xpath("//h5[text() = 'Select Multiple']/following::div")).click();
		driver.findElement(By.xpath("(//label[text()= 'Miami'])[2]")).click();// span[contains(@class ,
																				// 'ui-icon-circle-close')]
		driver.findElement(By.xpath("(//label[text()= 'London'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(@class , 'ui-icon-circle-close')]")).click();
		// Tristate switch
		int count = 0;
		while (count < 3) {
			Thread.sleep(8000);
			driver.findElement(By.xpath("//div[contains(@id, 'ajaxTriState')]")).click();
			String stateText = driver.findElement(By.className("ui-growl-message")).getText();
			System.out.println(stateText);
			count++;
		}
		// driver.close();
	}

}
