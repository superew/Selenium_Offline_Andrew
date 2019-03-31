package WebDriver_API;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class WaitElement {
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
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//*[@id='start']/button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading'")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4")));

		String textHello = driver.findElement(By.xpath("//*[@id='finish']/h4")).getText();
		assertEquals(textHello, "Hello World!");
	}

//	@Test
	public void TC_03() {
		// Open link
		driver.get("https://www.w3schools.com/howto/howto_js_countdown.asp");

		WebElement coutDown = driver.findElement(By.xpath("//*[@id='countdown1']"));

		new FluentWait<WebElement>(coutDown).withTimeout(60, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						boolean flag = element.getText().endsWith("25s");
						return flag;
					}
				});

	}
	
	@Test
	public void TC_05() {
		// Open link
		driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
		
		driver.findElement(By.xpath("//*[@id='cricle-btn']")).click();


		waitForProgressBar("//*[@class='percenttext' and contains(text(),'100%')]");
		String percent = driver.findElement(By.xpath("//*[@class='percenttext']")).getText();
		assertEquals(percent, "100%");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
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
