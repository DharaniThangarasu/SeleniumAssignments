package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ScrollDown {

	public static void main(String[] args) throws IOException {
		//Load (https://www.ajio.com/)
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.ajio.com/");
		// Maximize the browser window.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement scrollElement = driver.findElement(By.xpath("//div[text() ='Payment Methods' ]"));
		Actions builder = new Actions(driver);
		builder.scrollToElement(scrollElement).perform();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/scroll.png");
		FileUtils.copyFile(source, dest);
		
	}

}
