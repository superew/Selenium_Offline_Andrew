package WebDriver_API;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.commonFunction;

public class Alert_JavaScript extends commonFunction{
	WebDriver driver;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		action = new Actions(driver);

	}

//	@Test
	public void TC_01() {
		// Open link
//		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		openUrl(driver, "http://the-internet.herokuapp.com/javascript_alerts");

//		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		click(driver, "//button[contains(text(),'Click for JS Alert')]");

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();

		assertEquals(alertText, "I am a JS Alert");

		alert.accept();

//		String resultText = driver.findElement(By.xpath("//h4[contains(text(),'Result:')]/following-sibling::p"))
//				.getText();
		String resultText = getText(driver, "//h4[contains(text(),'Result:')]/following-sibling::p");

		assertEquals(resultText, "You successfuly clicked an alert");

	}

//	@Test
	public void TC_02() {
		// Open link
//		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		openUrl(driver, "http://the-internet.herokuapp.com/javascript_alerts");

//		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		click(driver, "//button[contains(text(),'Click for JS Confirm')]");

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();

		assertEquals(alertText, "I am a JS Confirm");

		alert.accept();

		String resultText = driver.findElement(By.xpath("//h4[contains(text(),'Result:')]/following-sibling::p"))
				.getText();

		assertEquals(resultText, "You clicked: Ok");
	}

//	@Test
	public void TC_03() {
		// Open link
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();

		assertEquals(alertText, "I am a JS prompt");

		String textEntered = "AndrewNguyen";

		alert.sendKeys(textEntered);

		alert.accept();

		String resultText = driver.findElement(By.xpath("//h4[contains(text(),'Result:')]/following-sibling::p"))
				.getText();

		assertEquals(resultText, "You entered: " + textEntered);
	}

	@AfterClass
	public void afterClass() {

	}

	public void waitForProgressBar(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});
	}
}
