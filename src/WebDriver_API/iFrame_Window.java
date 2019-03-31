package WebDriver_API;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.commonFunction;

public class iFrame_Window extends commonFunction {
	WebDriver driver;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		action = new Actions(driver);
	}

	@Test
	public void TC_01() {
		// Open link
		driver.get("http://the-internet.herokuapp.com/iframe");
		openUrl(driver, "http://the-internet.herokuapp.com/iframe");

		WebElement iFrame = driver.findElement(By.xpath("//div[@id='mceu_27']/iframe"));

		driver.switchTo().frame(iFrame);

//		driver.findElement(By.xpath("//body[@id='tinymce']/p")).clear();
		clear(driver, "//body[@id='tinymce']/p");

//		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Andrew");
		input(driver, "//body[@id='tinymce']", "Andrew");

		driver.switchTo().defaultContent();

//		String textH3 = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		String textH3 = getText(driver, "//div[@class='example']/h3");

		System.out.println(textH3);
	}

	@Test
	public void TC_02() {
		// Open link
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");

		WebElement iFrame2 = driver.findElement(By.xpath("//div[@id='iframe']//iframe"));

		driver.switchTo().frame(iFrame2);

		WebElement result = driver.findElement(By.xpath("//input[@name='lname']"));

		assertFalse(result.isEnabled());

//		if (abc == true) {
//			System.out.println("The Last name textbox is enable");
//		} else {
//			System.out.println("The Last name textbox is disable");
//		}

		String text = "Nguyen";
//		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(text);
		input(driver, "//input[@name='fname']", text);

//		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		click(driver, "//input[@value='Submit']");

		driver.switchTo().defaultContent();

		WebElement iFrame3 = driver.findElement(By.xpath("//div[@id='iframe']//iframe"));

		driver.switchTo().frame(iFrame3);

//		String text2 = driver.findElement(By.xpath("//body/div[contains(@class,'w3-container')]")).getText().trim();
		String text2 = getText(driver, "//body/div[contains(@class,'w3-container')]").trim();

		assertEquals(text2, "fname=" + text);
	}

//	public void switchToWindowByTitle(String title) {
//		Set<String> allWindows = driver.getWindowHandles();
//		for (String childWindows : allWindows) {
//			driver.switchTo().window(childWindows);
//			String childTitle = driver.getTitle();
//			if (childTitle.equals(title)) {
//				break;
//			}
//		}
//	}

//	public static String randomEmail() {
//		Random rand = new Random();
//		int number = rand.nextInt(9999999);
//		return String.valueOf(number);
//	}

	@Test
	public void TC_03() {
		// Open link
//		driver.get("http://demo.guru99.com/popup.php");
		openUrl(driver, "http://demo.guru99.com/popup.php");

//		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		click(driver, "//a[contains(text(),'Click Here')]");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String email = "random" + randomEmail() + "@gmail.com";

//		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		input(driver, "//input[@name='emailid']", email);

//		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		click(driver, "//input[@value='Submit']");

		driver.switchTo().window(tabs.get(0));

	}

	@Test
	public void TC_04() {
		// Open link
//		driver.get("http://www.hdfcbank.com/");
		openUrl(driver, "http://www.hdfcbank.com/");

//		driver.findElement(By.xpath("//div[@class='topnav_wrapper']//a[contains(text(),'Agri')]")).click();
		click(driver, "//div[@class='topnav_wrapper']//a[contains(text(),'Agri')]");

		switchToWindowByTitle(driver, "HDFC Bank Kisan Dhan Vikas e-Kendra");

//		driver.findElement(By.xpath("//p[contains(text(),'Account Details')]/ancestor::a")).click();
		click(driver, "//p[contains(text(),'Account Details')]/ancestor::a");

		switchToWindowByTitle(driver, "Welcome to HDFC Bank NetBanking");

		WebElement iframe5 = driver.findElement(By.xpath("//frame[@name='footer']"));

		driver.switchTo().frame(iframe5);

//		driver.findElement(By.xpath("//form[@name='frmFooter']//a[contains(text(),'Privacy Policy')]")).click();
		click(driver, "//form[@name='frmFooter']//a[contains(text(),'Privacy Policy')]");

		switchToWindowByTitle(driver,
				"HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");

		driver.manage().window().maximize();

//		driver.findElement(By.xpath("//a[@title='Corporate Social Responsibility']")).click();
		click(driver, "//a[@title='Corporate Social Responsibility']");

		switchToWindowByTitle(driver, "HDFC Bank: Personal Banking Services");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
