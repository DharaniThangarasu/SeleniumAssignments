package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Input {

	public static void main(String[] args) throws Exception {
		// Launch the browser "https://www.leafground.com/input.xhtml"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		driver.findElement(By.name("j_idt88:j_idt99")).sendKeys("abc@gmail.com", Keys.TAB);
		// Type about yourself
		driver.findElement(By.name("j_idt88:j_idt101")).sendKeys("Selenium Automation tool");
		// Text Editor
		driver.findElement(By.xpath("//button[@class = 'ql-direction']")).click();
		driver.findElement(By.xpath("//p[contains(@class , 'ql-direction-rtl')]")).sendKeys("Sample");
		// Just Press Enter and confirm error message*
		driver.findElement(By.name("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		if (driver.findElement(By.className("ui-message-error-detail")).getText().equals("Age is mandatory"))
			System.out.println("Error message is correct");
		else
			System.out.println("Test case failed");
		// Type your name and choose the third option
		driver.findElement(By.name("j_idt106:auto-complete_input")).sendKeys("Sample");
		driver.findElement(By.xpath("(//li[contains(@class,'ui-corner-all')]/span)[3]")).click();
		//Type your DOB (mm/dd/yyyy) and confirm date chosen
		driver.findElement(By.name("j_idt106:j_idt116_input")).sendKeys("02/02/2002");
		driver.findElement(By.xpath("//button[contains(@class, 'ui-datepicker-trigger')]")).click();
		List<WebElement> dateList = driver.findElements(By.className("ui-datepicker-title"));
		String date ="";
		for(WebElement element: dateList)
		{
			Thread.sleep(3000);
			date = date + element.getText();
		}
		String day = driver.findElement(By.xpath("//a[contains(@class, 'ui-state-active')]")).getText();
		if(date.equals( "February 2002")&&day.equals("2"))
			System.out.println("Date is choosen correctly");
		else
			System.out.println("Date is choosen incorrectly");
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
		driver.findElements(By.xpath("//div[contains(@class, 'ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content')]"));		
		String width = driver.findElement(By.xpath("//div[contains(@class, 'ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content')]/div"))
				.getCssValue("width");
		String left = driver
				.findElement(By.xpath("//div[contains(@class, 'ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content')]/span"))
				.getCssValue("left");
		System.out.println(width + "  "+ left);
		if (width.equals("70%") && left.equals("70%"))
			System.out.println("slider working fine");
		else
			System.out.println("Slider not working fine");
		//Click and Confirm Keyboard appears
		driver.findElement(By.name("j_idt106:j_idt122")).click();
		String display = driver.findElement(By.xpath("//div[contains(@class,'keypad-popup ui-input-overlay')]")).getCssValue("display");
		if(display.equals("block"))
			System.out.println("Keyboard appears");
		else
			System.out.println("Keyboard not appears");
		//Custom Toolbar
		driver.findElement(By.xpath("//h5[contains(text() , 'Custom')]/following::button[@class = 'ql-bold']")).click();
		driver.findElement(By.xpath("//h5[contains(text() , 'Custom')]/following::button[@class = 'ql-italic']")).click();
		driver.findElement(By.xpath("//h5[contains(text() , 'Custom')]/following::button[@class = 'ql-underline']")).click();
		driver.findElement(By.xpath("//h5[contains(text() , 'Custom')]/following::button[@class = 'ql-strike']")).click();
		driver.findElement(By.xpath("//h5[contains(text() , 'Custom')]/following::div[contains(@class ,'ql-editor')]")).sendKeys("Sample");
	}

}
