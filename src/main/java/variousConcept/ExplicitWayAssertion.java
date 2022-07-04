package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExplicitWayAssertion {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {
		
		//DataType Name = Value;
		//ELEMENT LIST
		//Storing Data with WebElement
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement signinButtonElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		
		//Storing Data with By class
		By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		
		//webelement
	/*	USER_NAME_ELEMENT.clear();
		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		signinButtonElement.click();*/
		
		//by class
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc1234");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		
		Boolean pageTitleDisplay;
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div/h2"));
			pageTitleDisplay = true;
		}catch(Exception e) {
			pageTitleDisplay = false;
			e.printStackTrace();
		}
		
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));*/
		
		
		Assert.assertTrue("Wrong page!!", pageTitleDisplay);
		
	
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
