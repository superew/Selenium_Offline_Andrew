package WebDriver_API;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.commonFunction;

public class Exercise1 extends commonFunction {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_loginEmpty() {

		// Click on Account link
//		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
		click(driver, "//a[contains(@class,'skip-account')]");

		// Click on My Account to navigate to Login page
//		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		click(driver, "//div[@id='header-account']//a[contains(@title,'My Account')]");

		// Click on button Login
//		driver.findElement(By.xpath("//button[@title='Login']")).click();
		click(driver, "//button[@title='Login']");

		// Get error texts
//		String errorText = driver.findElement(By.xpath("//div[@class='validation-advice']")).getText();
//		assertEquals(errorText, "This is a required field.");
		String errorText = getText(driver, "//div[@class='validation-advice']");
		assertEquals(errorText, "This is a required field.");

	}

	@Test
	public void TC_02_loginInvalidEmail() {

		// Click on Account link
//		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
		click(driver, "//a[contains(@class,'skip-account')]");

		// Click on My Account to navigate to Login page
//		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		click(driver, "//div[@id='header-account']//a[contains(@title,'My Account')]");

		// Input Invalid Email
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
		input(driver, "//input[@id='email']", "123434234@12312.123123");

		// Click on button Login
//		driver.findElement(By.xpath("//button[@title='Login']")).click();
		click(driver, "//button[@title='Login']");

//		String errorText = driver.findElement(By.xpath("//div[contains(@id,'validate-email')]")).getText();
//		assertEquals(errorText, "Please enter a valid email address. For example johndoe@domain.com.");

		String errorText = getText(driver, "//div[contains(@id,'validate-email')]");
		assertEquals(errorText, "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_loginIncorrectPass() {

		// Click on Account link
//		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
		click(driver, "//a[contains(@class,'skip-account')]");

		// Click on My Account to navigate to Login page
//		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		click(driver, "//div[@id='header-account']//a[contains(@title,'My Account')]");

		// Input Email
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		input(driver, "//input[@id='email']", "automation@gmail.com");

		// Input incorrect Pass
//		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		input(driver, "//input[@id='pass']", "123");

		// Click on button Login
//		driver.findElement(By.xpath("//button[@title='Login']")).click();
		click(driver, "//button[@title='Login']");

		// Verify text
//		String errorText = driver.findElement(By.xpath("//div[contains(@id,'validate-password')]")).getText();
//		assertEquals("Please enter 6 or more characters without leading or trailing spaces.", errorText);

		String errorText = getText(driver, "//div[contains(@id,'validate-password')]");
		assertEquals(errorText, "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@BeforeMethod
	public void beforeMethod() {
		openUrl(driver, "http://live.guru99.com/");
	}

	@Test
	public void TC_04_createNewAccount() {
		String email = "random" + randomEmail() + "@gmail.com";

		// Click on Account link
//		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
		click(driver, "//a[contains(@class,'skip-account')]");

		// Click on My Account to navigate to Login page
//		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		click(driver, "//div[@id='header-account']//a[contains(@title,'My Account')]");

		// Click on Create new Account
//		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		click(driver, "//a[@title='Create an Account']");

		// Fill First Name
//		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Andrew");
		input(driver, "//input[@id='firstname']", "Andrew");

		// Fill Last Name
//		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Nguyen");
		input(driver, "//input[@id='lastname']", "Nguyen");

		// Fill Email
//		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
		input(driver, "//input[@id='email_address']", email);

		// Fill Password
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		input(driver, "//input[@id='password']", "123456");

		// Fill Confirm Password
//		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		input(driver, "//input[@id='confirmation']", "123456");

		// Click on Register button
//		driver.findElement(By.xpath("//button[@title='Register']")).click();
		click(driver, "//button[@title='Register']");

		// Verify My Dashboard page
//		String mydashboard = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
//		assertEquals("MY DASHBOARD", mydashboard);
		
		String mydashboard = getText(driver, "//div[@class='page-title']/h1");
		assertEquals(mydashboard, "MY DASHBOARD");

		// Verify text
//		String errorText2 = driver.findElement(By.xpath("//ul[@class='messages']//span")).getText();
//		assertEquals("Thank you for registering with Main Website Store.", errorText2);
		
		String errorText2 = getText(driver, "//ul[@class='messages']//span");
		assertEquals(errorText2, "Thank you for registering with Main Website Store.");

		// Click logout button
			// Click on Account link
//		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
		click(driver, "//a[contains(@class,'skip-account')]");

			// click logout button
//		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'Log Out')]")).click();
		click(driver, "//div[@id='header-account']//a[contains(@title,'Log Out')]");

		// Login with new created account
			// Click on Account link
//		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
		click(driver, "//a[contains(@class,'skip-account')]");

			// Click on My Account to navigate to Login page
//		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
		click(driver, "//div[@id='header-account']//a[contains(@title,'My Account')]");

			// Input Email
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		input(driver, "//input[@id='email']", email);

			// Input Pass
//		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		input(driver, "//input[@id='pass']", "123456");

			// Click on button Login
//		driver.findElement(By.xpath("//button[@title='Login']")).click();
		click(driver, "//button[@title='Login']");

		// Verify current URL
//		String currentURL = driver.getCurrentUrl();
		String currentURL = getCurrentUrl(driver);
		Assert.assertEquals(currentURL, "http://live.guru99.com/index.php/customer/account/index/");
		
		// Click logout button
			// Click on Account link
//		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();
		click(driver, "//a[contains(@class,'skip-account')]");

			// click logout button
//		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'Log Out')]")).click();
		click(driver, "//div[@id='header-account']//a[contains(@title,'Log Out')]");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
