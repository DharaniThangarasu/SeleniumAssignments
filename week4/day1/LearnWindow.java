package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWindow {
	public static void main(String[] args) {
		// Load the url "https://leafground.com/window.xhtml"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text() = 'Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleList = new ArrayList<>(windowHandles);
		System.out.println(driver.switchTo().window(windowHandleList.get(1)).getTitle());
		driver.close();
		driver.switchTo().window(windowHandleList.get(0));
		// Close all windows except Primary
		driver.findElement(By.xpath("//span[text() = 'Close Windows']")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandle = driver.getWindowHandles();
		for (String each : windowHandle) {
			if (!each.equals(parentWindow)) {
				driver.switchTo().window(each);
				driver.close();
			}
		}
		if(driver.getWindowHandles().size() == 1)
			System.out.println("Closed all windows except primary");
		else
			System.out.println("Closed improperly");
		// Find the number of opened tabs
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//span[text() = 'Open Multiple']")).click();
		System.out.println("Number of opened tabs : " + driver.getWindowHandles().size());
		//Wait for 2 new tabs to open
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//span[text() = 'Open with delay']")).click();
		System.out.println("Number of opened tabs : " + driver.getWindowHandles().size());
		driver.quit();
	}

}
