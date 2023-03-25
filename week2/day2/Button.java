package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Button {

	public static void main(String[] args) {
		//Launch https://www.leafground.com/button.xhtml
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.leafground.com/button.xhtml");
		//Click the button and Confirm title.
		driver.findElement(By.xpath("//span[text() = 'Click']")).click();
		if(driver.getTitle().equals("Dashboard"))
			System.out.println("Button is working fine");
		else
			System.out.println("Button is not working");
		driver.navigate().back();
		//Confirm if the button is disabled.
		boolean isEnabled = driver.findElement(By.name("j_idt88:j_idt92")).isEnabled();
		if(isEnabled)
			System.out.println("Button is enabled");
		else
			System.out.println("Button is disabled");
		//Find the position of the Submit button
		Point location = driver.findElement(By.xpath("//span[text()= 'Submit']")).getLocation();
		System.out.println("position of the Submit button: " + location);
		//Find the Save button color
		String color = driver.findElement(By.xpath("//span[text() = 'Save']")).getCssValue("color");
		System.out.println("Color of the save button:" + color );
		//Find the height and width of this button
		WebElement size = driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-right')]"));
		System.out.println("Size of the button: " + size.getSize());
		System.out.println("Width of the button: " + size.getSize().getWidth());
		System.out.println("Height of the button: "+ size.getSize().getHeight());
		// print How many rounded buttons are there
		List<WebElement> roundedButon = driver.findElements(By.xpath("//button[contains(@class,'rounded-button')] "));
		System.out.println("There are " + roundedButon.size()+ " buttons");
	}

	
}
