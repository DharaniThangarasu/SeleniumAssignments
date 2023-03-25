package week2.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectInput {

	public static void main(String[] args) throws Exception {
		// Launch URL "https://www.leafground.com/select.xhtml"
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/select.xhtml");
		// Maximize the browser window.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Choose your favorite UI Automation tool?
		WebElement element = driver.findElement(By.xpath("//select[@class = 'ui-selectonemenu']"));
		Select sel = new Select(element);
		sel.selectByVisibleText("Selenium");
		// Choose your preferred country
		driver.findElement(By.xpath("//label[contains(text(),'Country')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'India')]")).click();
		Thread.sleep(3000);
		//Confirm Cities belongs to Country is loaded
		driver.findElement(By.xpath("//label[contains(text(),'City')]")).click();	
		List<WebElement> cityElement = driver.findElements(By.xpath("(//li[@class= 'ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all'])"));
		List<String> citylist = new ArrayList<>();
		String text;
		for(WebElement city:cityElement )
		{
			 text = city.getText();
			 citylist.add(text);			
		}
		if(citylist.contains("Chennai"))
			System.out.println("City belongs to Country is loaded");
		else
			System.out.println("City not belongs to Country is loaded");
		//Choose the Course
		driver.findElement(By.xpath("//span[@class ='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
		driver.findElement(By.xpath("//li[text() ='Selenium WebDriver']")).click();
		//Choose language randomly
		driver.findElement(By.xpath("//label[contains(text(),'Language')]")).click();
		driver.findElement(By.xpath("//li[text() ='English']")).click();
		//Select 'Two' irrespective of the language chosen
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Values')]")).click();
		List<WebElement> numberList = driver.findElements(By.xpath("//li[contains(text(),'Values')]/following-sibling::li"));
		for(WebElement num : numberList)
		{
			if(num.getText().equals("Two"))
				num.click();
		}
	}

}
