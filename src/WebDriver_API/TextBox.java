package WebDriver_API;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBox {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
	}
	
	@Test
	public void testCase01() throws Exception {
		WebElement userName = driver.findElement(By.xpath("//input[@name='uid']"));
		userName.sendKeys("abcdefg");
		WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		passWord.sendKeys("123456");
		
		Thread.sleep(2000);
		userName.clear();
		passWord.clear();
		
		WebElement userName_Txt = driver.findElement(By.xpath("//label[@id='message23']"));
		String a = userName_Txt.getText();
		System.out.println(a);
		
		WebElement passWord_Txt = driver.findElement(By.xpath("//label[@id='message18']"));
		String b = passWord_Txt.getText();
		System.out.println(b);
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
		
	}
}
