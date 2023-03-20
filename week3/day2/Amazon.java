package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) {
		// Load https://www.amazon.in/
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Type "Mobile" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile", Keys.ENTER);
		//Get the list of price of mobile
		List<WebElement> mobilePriceList = driver.findElements(By.className("a-price-whole"));
		List<Integer> priceList = new ArrayList<Integer>();
		for (WebElement element : mobilePriceList) {
			String text = element.getText().replaceAll(",", "");
			priceList.add(Integer.parseInt(text));
		}
		Collections.sort(priceList);
		//System.out.println(priceList);
		//print the minimum value
		System.out.println("Minimum price of a mobile : " + priceList.get(0) );
		
	}

}
