package WebDriver_API;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.commonFunction;

public class UploadFile extends commonFunction{
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
	public void TC_01_UseSendKey() throws Exception {
		// Open link
//		driver.get("http://demo.guru99.com/test/upload/");
		openUrl(driver, "http://demo.guru99.com/test/upload/");

		WebElement btnUpload = driver.findElement(By.xpath("//input[@name='uploadfile_0']"));

		btnUpload.sendKeys("C:\\incorrect date.png");

//		driver.findElement(By.xpath("//*[@id='terms']")).click();
		click(driver, "//*[@id='terms']");

//		driver.findElement(By.xpath("//*[@id='submitbutton']")).click();
		click(driver, "//*[@id='submitbutton']");

		Thread.sleep(2000);

//		String message = driver.findElement(By.xpath("//h3[@id='res']/center")).getText();
		String message = getText(driver, "//h3[@id='res']/center");

		assertTrue(message.contains("successfully uploaded"));
	}

//	@Test
	public void TC_01_UseRobot() throws Exception {
		// Open link
		driver.get("http://demo.guru99.com/test/upload/");

		StringSelection select = new StringSelection("C:\\incorrect date.png");

		WebElement btnBrowse = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		btnBrowse.click();
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//*[@id='terms']")).click();

		driver.findElement(By.xpath("//*[@id='submitbutton']")).click();

		Thread.sleep(2000);

		String message2 = driver.findElement(By.xpath("//h3[@id='res']/center")).getText();

		assertTrue(message2.contains("successfully uploaded"));

	}

	@Test
	public void TC_02_UseSendKey() throws Exception {
		// Open link
		driver.get("http://the-internet.herokuapp.com/upload");

		WebElement btnUpload = driver.findElement(By.xpath("//*[@id='file-upload']"));

		btnUpload.sendKeys("C:\\incorrect date.png");

		driver.findElement(By.xpath("//*[@id='file-submit']")).click();

		Thread.sleep(2000);

		String message3 = driver.findElement(By.xpath("//*[@class='example']/h3")).getText();

		assertTrue(message3.contains("File Uploaded"));
	}

//	@Test
	public void TC_02_UseRobot() throws Exception {
		// Open link
		driver.get("http://the-internet.herokuapp.com/upload");

		StringSelection select = new StringSelection("C:\\incorrect date.png");

		WebElement btnBrowse = driver.findElement(By.xpath("//input[@id='file-upload']"));
		btnBrowse.click();
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//*[@id='file-submit']")).click();
		
		Thread.sleep(2000);

		String message4 = driver.findElement(By.xpath("//*[@class='example']/h3")).getText();

		assertTrue(message4.contains("File Uploaded"));

	}

//	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
