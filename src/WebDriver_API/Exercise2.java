package WebDriver_API;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.commonFunction;

public class Exercise2 extends commonFunction{
	WebDriver driver;
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
//	@Test
	public void TC_01() {
		//Open link
//		driver.get("https://daominhdam.github.io/basic-form/");
		openUrl(driver, "https://daominhdam.github.io/basic-form/");
		
		//Verify password field is disable
		WebElement element = driver.findElement(By.xpath("//input[@id='password']"));
		Assert.assertFalse(element.isEnabled());
		
		String attribute = element.getAttribute("placeholder");
		assertEquals("Textbox is disabled", attribute);

	}
	
//	@Test
	public void TC_02() throws Exception {
		//Step 1: Open link
//		driver.get("http://demo.guru99.com/test/radio.html");
		openUrl(driver, "http://demo.guru99.com/test/radio.html");
		
		//Step 2: Verify Radio Option1
		WebElement element2 = driver.findElement(By.xpath("//input[@value='Option 1']"));
		Assert.assertFalse(element2.isSelected());
		boolean result = element2.isSelected();
		System.out.println(result);
		
		//Select Radio Option1 if not selected
		if (element2.isSelected() != true) {
			driver.findElement(By.xpath("//input[@value='Option 1']")).click();
		}
		
		//Verify Radio is selected
		Assert.assertTrue(element2.isSelected());
				
		//Step 3: Verify Checkbox 3
		WebElement element3 = driver.findElement(By.xpath("//input[@value='checkbox3']"));
		Assert.assertFalse(element3.isSelected());
		boolean result2 = element3.isSelected();
		System.out.println(result2);
		
		//Select Radio Option1 if not selected
		if (element3.isSelected() != true) {
			driver.findElement(By.xpath("//input[@value='checkbox3']")).click();
		}
		
		//Verify Radio is selected
		Assert.assertTrue(element3.isSelected());
	}
	
	@Test
	public void TC_03() throws Exception {
		//Step 1: Open link
//		driver.get("https://www.facebook.com/");
		openUrl(driver, "https://www.facebook.com/");
		
		//Step 2: Select on Combobox
//		Select day = new Select(driver.findElement(By.xpath("//*[@id='day']")));
//		day.selectByVisibleText("14");
		
		selectComboboxByVisibleText(driver, "//*[@id='day']", "14");
		
//		String selectDay = day.getFirstSelectedOption().getText();
		String selectDay = getTextComboboxSelected(driver, "//*[@id='day']");
		
//		Select month = new Select(driver.findElement(By.xpath("//*[@id='month']")));
//		month.selectByValue("2");
		selectComboboxByValue(driver, "//*[@id='month']", "2");
		
//		String selectMonth = month.getFirstSelectedOption().getText();
		String selectMonth = getTextComboboxSelected(driver, "//*[@id='month']");
		
//		Select year = new Select(driver.findElement(By.xpath("//*[@id='year']")));
//		year.selectByVisibleText("2019");
		selectComboboxByValue(driver, "//*[@id='year']", "2019");
//		String selectYear = year.getFirstSelectedOption().getText();
		String selectYear = getTextComboboxSelected(driver, "//*[@id='year']");
		
		//Step 3: Verify Selected option
		Assert.assertEquals("14", selectDay);
		Assert.assertEquals("Th�ng 2", selectMonth);
		Assert.assertEquals("2019", selectYear);
		
		System.out.println("Selected: " + selectDay + " " + selectMonth + " " + selectYear);
		
	}
}
