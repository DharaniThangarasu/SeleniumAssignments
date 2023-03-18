package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Input {

	public static void main(String[] args) {
		// Launch the browser "https://www.leafground.com/input.xhtml"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.leafground.com/input.xhtml");
		// Type your name
		driver.findElement(By.name("j_idt88:name")).sendKeys("Sample");
		// Append Country to this City.
		driver.findElement(By.name("j_idt88:j_idt91")).sendKeys(",India");
		// Verify if text box is disabled
		boolean isEnabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
		if (isEnabled)
			System.out.println("Button is enabled");
		else
			System.out.println("Button is disabled");
		// Clear the typed text.
		driver.findElement(By.name("j_idt88:j_idt95")).clear();
		// Retrieve the typed text.
		System.out.println("Typed text is: " + driver.findElement(By.name("j_idt88:j_idt97")).getAttribute("value"));
		// Type email and Tab. Confirm control moved to next element.
		driver.findElement(By.name("j_idt88:j_idt99")).sendKeys("abc@gmail.com" + '\t');
		// Type about yourself
		driver.findElement(By.name("j_idt88:j_idt101")).sendKeys("Selenium Automation tool");
		// Text Editor
		driver.findElement(By.xpath("//button[@class = 'ql-direction']")).click();
		driver.findElement(By.xpath("//p[contains(@class , 'ql-direction-rtl')]")).sendKeys("Sample");
		// Type your name and choose the third option
		driver.findElement(By.name("j_idt106:auto-complete_input")).sendKeys("Sample");
		driver.findElement(By.xpath("(//li[contains(@class,'ui-corner-all')]/span)[3]")).click();
		// Type number and spin to confirm value changed
		driver.findElement(By.name("j_idt106:j_idt118_input")).sendKeys("5");
		driver.findElement(By.xpath("//span[contains(@class, 'ui-icon-triangle-1-n')]")).click();
		String value = driver.findElement(By.name("j_idt106:j_idt118_input")).getAttribute("aria-valuenow");
		if (value.equals("6"))
			System.out.println("pass");
		else
			System.out.println("Fail");
		// Type random number (1-100) and confirm slider moves correctly
		driver.findElement(By.name("j_idt106:slider")).sendKeys("70");
		String width = driver.findElement(By.xpath("//div[contains(@class,'ui-slider-range-min')]"))
				.getCssValue("width");
		String left = driver
				.findElement(By.xpath("//div[contains(@class,'ui-slider-range-min')]/following-sibling::span"))
				.getCssValue("left");
		if (width.equals("70%") && left.equals("70%"))
			System.out.println("slider working fine");
		else
			System.out.println("Slider not working fine");
	}

}
