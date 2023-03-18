package CodeMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookmyShow {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 01) Launch Edge / Chrome add implicitlyWait driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		 * 02) Load https://in.bookmyshow.com/ 
		 * 03) Type the city as"Hyderabad"in Select City 
		 * 04) Confirm the URL has got loaded with Hyderabad 
		 * 05) Search for your favorite movie 
		 * 06) Click on movie 
		 * 07) Print the name of the theater displayed first
		 * 08) Click on the info of the theater 
		 * 09) Confirm if there is a parking facility in the theater 
		 * 10) Close the theater popup 
		 * 11) Click on the first green (available) timing 
		 * 12) Click Accept 
		 * 13) Choose 1 Seat and Click Select Seats 
		 * 14) Choose any available ticket and Click Pay 
		 * 15) Print the sub total
		 */
		//Load https://in.bookmyshow.com/ 
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://in.bookmyshow.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Type the city as"Hyderabad"in Select City 
		driver.findElement(By.xpath("//input[contains(@class,'sc-hCaUpS')]")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//strong[text() = 'Hyderabad']")).click();
		//Confirm the URL has got loaded with Hyderabad
		System.out.println(driver.getCurrentUrl());
		//Search for your favorite movie
		driver.findElement(By.xpath("//span[contains(text(),'Search ')]")).click();
		driver.findElement(By.xpath("//input[contains(@class,'cLnzvB')]")).sendKeys("Sir");
		//Click on movie
		driver.findElement(By.xpath("//strong[text() = 'Sir']")).click();	
		driver.findElement(By.xpath("//span[contains(text(),'Book')]")).click();
		//Print the name of the theater displayed first
		System.out.println(driver.findElement(By.xpath("//a[@class ='__venue-name']")).getText());
		//Click on the info of the theater
		driver.findElement(By.xpath("//div[@class = 'venue-info-text']")).click();
		//Confirm if there is a parking facility in the theater 
		System.out.println(driver.findElement(By.xpath("(//div[@class = 'venue-facility-item'])[2]")).getText());
		//Close the theater popup
		driver.findElement(By.className("cross-container")).click();
		//Click on the first green (available) timing 
		driver.findElement(By.xpath("//div[@class = 'showtime-pill-container _available']")).click();
		//Choose 1 Seat and Click Select Seats 
		driver.findElement(By.xpath("//li[text() = '1']")).click();
		driver.findElement(By.xpath("//div[@class = 'btn-bar']/div[contains(text(),'Seats')]")).click();
		//Choose any available ticket and Click Pay
		driver.findElement(By.xpath("//a[@class = '_available']")).click();
		driver.findElement(By.xpath("//a[@id ='btmcntbook']")).click();
		//Print the sub total		
		String text = driver.findElement(By.xpath("//span[@class= '__sub-total']")).getText();
		System.out.println(text);

	
	}

}
