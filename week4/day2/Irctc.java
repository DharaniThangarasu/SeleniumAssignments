package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Irctc {

	public static void main(String[] args) throws IOException {
		// Load this url(https://www.irctc.co.in/nget/train-search)
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/nget/train-search");
		// Click Flights
		driver.findElement(By.xpath("//a[contains(text(), 'FLIGHTS')]")).click();
		// Get the title and print in the console
		System.out.println(driver.switchTo().window(driver.getWindowHandle()).getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowHandles);
		System.out.println(driver.switchTo().window(windowList.get(1)).getTitle());
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/irctc.png");
		FileUtils.copyFile(source, dest);
		
	}

}
