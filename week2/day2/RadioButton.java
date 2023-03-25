package week2.day2;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton {

	public static void main(String[] args) {
		// Launch URL "https://www.leafground.com/radio.xhtml"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/radio.xhtml");
		// Maximize the browser window.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Choose Your most favorite browser
		driver.findElement(By.xpath("//label[text() = 'Chrome']")).click();
		// UnSelectable
		driver.findElement(By.xpath("//label[text() = 'Chennai']")).click();
		//Find the default select radio button
		List<WebElement> browserList = driver.findElements(By.xpath("//input[@name ='j_idt87:console2']"));
		for (WebElement browser : browserList) {
			if (browser.isSelected()) {
				System.out.println(browser.getAttribute("value") + " is selected");
			}
		}
		// Select the age group (only if not selected)
		List<WebElement> ageList = driver.findElements(By.xpath("//input[@name ='j_idt87:age']"));
		int count = 0;
		for (WebElement age : ageList) {
			if (age.isSelected())
				count++;
		}
		if (count == 0)
			ageList.get(0).click();
		else
			System.out.println("Age group is already selected");
	}

}
