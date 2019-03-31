package WebDriver_API;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.commonFunction;

public class Javascript_Advance extends commonFunction {
	WebDriver driver;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		action = new Actions(driver);

	}

	// Create random email
//	public static String randomEmail() {
//		Random rand = new Random();
//		int number = rand.nextInt(9999999);
//		return String.valueOf(number);
//	}

	@Test
	public void TC_04_createNewAccount() {
		String email = "random" + randomEmail() + "@gmail.com";
		// Open link
//		driver.get("http://live.guru99.com/");
		openUrl(driver, "http://live.guru99.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Click on Account link
		WebElement element = driver.findElement(By.xpath("//a[contains(@class,'skip-account')]"));
		js.executeScript("arguments[0].click();", element);

		// Click on My Account to navigate to Login page
		WebElement element2 = driver
				.findElement(By.xpath("//div[@id='header-account']//a[contains(@title,'My Account')]"));
		js.executeScript("arguments[0].click();", element2);

		// Click on Create new Account
		WebElement element3 = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		js.executeScript("arguments[0].click();", element3);

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
		String mydashboard = getText(driver, "//div[@class='page-title']/h1");
		assertEquals(mydashboard, "MY DASHBOARD");

		// Verify text
//		String errorText2 = driver.findElement(By.xpath("//ul[@class='messages']//span")).getText();
		String errorText2 = getText(driver, "//ul[@class='messages']//span");
		assertEquals(errorText2, "Thank you for registering with Main Website Store.");

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

		// Input incorrect Pass
//		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
		input(driver, "//input[@id='pass']", "123456");

		// Click on button Login
//		driver.findElement(By.xpath("//button[@title='Login']")).click();
		click(driver, "//button[@title='Login']");

		// Verify current URL
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "http://live.guru99.com/index.php/customer/account/index/");
	}

//	@Test

//	Step 1: Vao trang: https://www.tjvantoll.com/demos/2012-08-05/initial
//	Step 2: Bo trong Name, Comments
//	Step 3: Click button Submit
//	Step 4: Verify message: Please fill out this field o textbox Name
//	Step 5: Input gia tri "abc" vao textbox: Name
//	Step 6: Click button Submit
//	Step 7: Verify message: Please fill out this field o textbox Comments

	public void TC_Bonus() {
		// Step1: Open link
//		driver.get("https://www.tjvantoll.com/demos/2012-08-05/initial");
		openUrl(driver, "https://www.tjvantoll.com/demos/2012-08-05/initial");

		// Step2: Bo trong Name, Comments

		// Step3: Click button Submit
//		driver.findElement(By.xpath("//*[@class='buttons']/button")).click();
		click(driver, "//*[@class='buttons']/button");

		// Step4: Verify message: Please fill out this field o textbox Name
		WebElement elementName = driver.findElement(By.xpath("//*[@id='name']"));

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		String textMessage = jsExecutor.executeScript("return arguments[0].validationMessage;", elementName).toString();

		assertEquals(textMessage, "Please fill out this field.");

		// Step5: Input gia tri "abc" vao textbox: Name
//		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("abc");
		input(driver, "//*[@id='name']", "abc");

		// Step 6: Click button Submit
//		driver.findElement(By.xpath("//*[@class='buttons']/button")).click();
		click(driver, "//*[@class='buttons']/button");

		// Step 7: Verify message: Please fill out this field o textbox Comments
		WebElement elementMessage = driver.findElement(By.xpath("//*[@id='comments']"));

		JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;

		String textMessage2 = jsExecutor2.executeScript("return arguments[0].validationMessage;", elementMessage)
				.toString();

		assertEquals(textMessage2, "Please fill out this field.");
	}

//	@Test
//	public void TC_ZingPay_exercise() {
//		//Open link
//		driver.get("https://pay.zing.vn/wplogin/mobile/jxm");
//		
//		//Login
//		driver.findElement(By.xpath("//input[@id='u']")).sendKeys("giinboo2");
//		driver.findElement(By.xpath("//input[@id='p']")).sendKeys("Aa123456!");
//		driver.findElement(By.xpath("//*[@id='login_submit_btn']")).click();
//		
//		driver.findElement(By.xpath("//label[contains(text(),'Cụm máy chủ')]/following-sibling::div/button")).click();
//		
//	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
