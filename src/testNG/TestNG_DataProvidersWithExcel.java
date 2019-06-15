package testNG;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvidersWithExcel {
    ExcelUtils excelUtils;
	WebDriver driver;
	String pathDriver = "/driver/";
	String userDir = System.getProperty("user.dir");
	String chromePath = userDir.concat(pathDriver).concat("chromedriver.exe");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().refresh();
	}

	@Test(dataProvider = "data")
	public void integrationTest(Map<Object, String> map) throws Exception {
		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(map.get("Surname"));
		driver.findElement(By.xpath("//input[@name='firstname']")).clear();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(map.get("Firstname"));
		driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(map.get("Email"));
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).clear();
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(map.get("Password"));

		System.out.println("-------------Test case Ended ----------------");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@DataProvider(name = "data")
	public Object[][] dataSupplier() throws Throwable {
		excelUtils = new ExcelUtils();
		return excelUtils.getExcel("TestData.xlsx");
	}
}