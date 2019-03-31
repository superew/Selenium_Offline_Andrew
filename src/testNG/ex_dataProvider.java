package testNG;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ex_dataProvider {
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

	@DataProvider(name = "Username/Password")
	public static Object[][] userandpass(Method method) {
		Object[][] result = null;
		if (method.getName().equals("TC_01")) {
			result = new Object[][] { { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } };
		} else if (method.getName().equals("TC_02")) {
			result = new Object[][] { { "123434234@12312.123123", "" } };
		} else if (method.getName().equals("TC_03")) {
			result = new Object[][] { { "automation1@gmail.com", "123" }, { "automation2@gmail.com", "123" } };
		}
		return result;
	}

	@Test(dataProvider = "Username/Password")
	public void TC_01(String user, String pass) {
		// Input User
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);

		// Input Pass
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);

		// Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();

	}

	@Test(dataProvider = "Username/Password")
	public void TC_02(String user, String pass) {
		// Input Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);

		// Input Pass
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);

		// Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();

	}

	@Test(dataProvider = "Username/Password")
	public void TC_03(String user, String pass) {
		// Input User
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(user);

		// Input Pass
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);

		// Click on button Login
		driver.findElement(By.xpath("//button[@title='Login']")).click();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
