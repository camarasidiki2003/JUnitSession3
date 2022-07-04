package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DybanmicWebElement {
WebDriver driver;
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.cnn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void learnDifferentLocators() {
		
		driver.findElement(By.xpath("//section[@id='homepage1-zone-1']/descendant::h2")).click();
		
	
		
		
	}

}
