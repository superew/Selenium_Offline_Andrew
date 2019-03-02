package WebDriver_API;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise1 {
	WebDriver driver;
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void TC_01_loginEmpty() {
		//Open link
		driver.get("http://live.guru99.com/");
		
		//Click on Account link
		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
		
		//Click on My Account to navigate to Login page
		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		
		//Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		//Get error texts
		String errorText = driver.findElement(By.xpath("//div[@class='validation-advice']")).getText();
		assertEquals(errorText, "This is a required field.");
		
	}
	
	@Test
	public void TC_02_loginInvalidEmail() {
		//Open link
		driver.get("http://live.guru99.com/");
				
		//Click on Account link
		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
				
		//Click on My Account to navigate to Login page
		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		
		//Input Invalid Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
		
		//Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		String errorText = driver.findElement(By.xpath("//div[contains(@id,'validate-email')]")).getText();
		assertEquals(errorText, "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test
	public void TC_03_loginIncorrectPass() {
		//Open link
		driver.get("http://live.guru99.com/");
						
		//Click on Account link
		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
						
		//Click on My Account to navigate to Login page
		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		
		//Input Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		
		//Input incorrect Pass
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		
		//Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		//Verify text
		String errorText = driver.findElement(By.xpath("//div[contains(@id,'validate-password')]")).getText();
		assertEquals("Please enter 6 or more characters without leading or trailing spaces.", errorText);
	}
	
	@Test
	//Create random email
	public static String randomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(9999999);
		return String.valueOf(number);
	}
	
	String email = "random" + randomEmail() + "@gmail.com";
	
	public void TC_04_createNewAccount() {
		//Open link
		driver.get("http://live.guru99.com/");
								
		//Click on Account link
		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
								
		//Click on My Account to navigate to Login page
		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		
		//Click on Create new Account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		//Fill First Name
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Andrew");
		
		//Fill Last Name
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Nguyen");
		
		//Fill Email
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
		
		//Fill Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		
		//Fill Confirm Password
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		
		//Click on Register button
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		//Verify My Dashboard page
		String mydashboard = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		assertEquals("My Dashboard", mydashboard);
		
		//Verify text
		String errorText2 = driver.findElement(By.xpath("//ul[@class='messages']//span")).getText();
		assertEquals("Thank you for registering with Main Website Store.", errorText2);
		
		//Click logout button
			//Click on Account link
		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
			
			//click logout button
		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'Log Out')]")).click();
		
		//Login with new created account
			//Click on Account link
		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
								
			//Click on My Account to navigate to Login page
		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
				
			//Input Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
				
			//Input incorrect Pass
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
				
			//Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		//Verify current URL
		String currentURL = driver.getCurrentUrl();
		assertEquals("http://live.guru99.com/index.php/customer/account/index/", currentURL);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
