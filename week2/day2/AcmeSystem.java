package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AcmeSystem {

	public static void main(String[] args) {
		/*1. Load url "https://acme-test.uipath.com/login"
		2. Enter email as "kumar.testleaf@gmail.com"
		3. Enter Password as "leaf@12"
		4. Click login button
		5. Get the title of the page and print
		6. Click on Log Out
		7. Close the browser (use -driver.close())
		*/
		//Load url "https://acme-test.uipath.com/login"
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://acme-test.uipath.com/login");
		//Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		//Enter Password as "leaf@12"
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		//Click login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		//Get the title of the page and print
		System.out.println(driver.getTitle());
		//Click on Log Out
		driver.findElement(By.partialLinkText("Log")).click();
		//Close the browser (use -driver.close())
		driver.close();

	}

}
