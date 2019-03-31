package testNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ex_Annotation {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		// Open link
		driver.get("http://live.guru99.com/");

		// Click on Account link
		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]")).click();

		// Click on My Account to navigate to Login page
		driver.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]")).click();
	}

	@Test
	public void TC_01() {
		// Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		// Get error texts
		String errorText = driver.findElement(By.xpath("//div[@class='validation-advice']")).getText();
		assertEquals(errorText, "This is a required field.");
	}

	@Test
	public void TC_02() {
		// Input Invalid Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");

		// Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();

		String errorText = driver.findElement(By.xpath("//div[contains(@id,'validate-email')]")).getText();
		assertEquals(errorText, "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03() {
		// Input Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");

		// Input incorrect Pass
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");

		// Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();

		// Verify text
		String errorText = driver.findElement(By.xpath("//div[contains(@id,'validate-password')]")).getText();
		assertEquals("Please enter 6 or more characters without leading or trailing spaces.", errorText);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
