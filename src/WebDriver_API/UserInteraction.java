package WebDriver_API;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserInteraction {
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
//	public void TC_01() {
//		//Step 1: Open link
//		driver.get("https://www.w3schools.com/Bootstrap/bootstrap_tooltip.asp");
//		
//		//Step 2: Hover to label
//		WebElement hoverElement = driver.findElement(By.xpath("//a[@class=\'bslink\']"));
//		Actions action = new Actions(driver);
//		action.moveToElement(hoverElement).perform();
//		
//		//Step 3: Verify text after hover
//		String hoverText = driver.findElement(By.xpath(""));
//		
//	}
	
//	@Test
//	public void TC_02() {
//		//Step 1: Open link
//		driver.get("https://www.24h.com.vn/");
//		
//		//Step 2: Hover menu: Danh mục -> Tiếp tục hover menu bóng đá -> Tiếp tục hover -> Lịch thi đấu bóng đá
//		Actions action2 = new Actions(driver);
//		WebElement hoverElement2 = driver.findElement(By.xpath("//a[text()='Danh mục']"));
//		action2.moveToElement(hoverElement2).perform();
//		
//		WebElement hoverElement3 = driver.findElement(By.xpath("//*[@id='zone_menu_trai_header']//a[@title='Bóng đá']"));
//		action2.moveToElement(hoverElement3).perform();
//		
//		WebElement hoverElement4 = driver.findElement(By.xpath("//ul[@class='fly']//a[@title='Lịch thi đấu bóng đá']"));
//		action2.moveToElement(hoverElement4).perform();
//		
//		driver.findElement(By.xpath("//ul[@class='fly']//a[@title='Lịch thi đấu bóng đá']")).click();
//		
//		String title = driver.getTitle();
//		Assert.assertEquals(title, "Lịch thi đấu Bóng Đá Anh, Ý TBN C1, Kết quả Tỉ lệ cược 24h");
//	}
	
//	@Test
//	public void TC_03() throws Exception {
//		//Step 1: Open link
//		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
//		
//		Actions action = new Actions(driver);
//		
//		//Click and Hold
//		List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
//		int sizeElement = listItems.size();
//		System.out.println(sizeElement);
//
//		action.clickAndHold(listItems.get(0)).clickAndHold(listItems.get(10)).click().perform();
//		
//		action.release();
//		
//		List<WebElement> listItems2 = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
//		
//		int sizeElement2 = listItems2.size();
//		
//		System.out.println(sizeElement2);
//	}
//	
//	@Test
//	public void TC_04() {
//		//Open link
//		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
//		
//		//Right Click on button
//		WebElement rightClick = driver.findElement(By.xpath("//span[contains(@class,'context-menu-one')]"));
//		
//		action.contextClick(rightClick);
//		
//		action.build().perform();
//		
//		//Verify label = "Quit"
//		WebElement hoverBtn = driver.findElement(By.xpath("//ul[contains(@class,'context-menu-list')]//span[contains(text(),'Quit')]"));
//		action.clickAndHold(hoverBtn).perform();
//		
//		String abc = hoverBtn.getText();
//		
//		Assert.assertEquals(abc, "Quit");
//	}
//	
//	@Test
//	public void TC_05() {
//		//Open link
//		driver.get("http://www.seleniumlearn.com/double-click");
//		
//		//Double Click to button
//		WebElement btnDoubleClick = driver.findElement(By.xpath("//div[@class='node-content']//button"));
//		
//		action.doubleClick(btnDoubleClick).perform();
//	}
//	
//	@Test
//	public void TC_06()  {
//		//Open link
//		driver.get("http://the-internet.herokuapp.com/drag_and_drop");
//		
//		//Drag and Drop A to B
//		WebElement dragFrom = driver.findElement(By.xpath("//div[@id='column-a']"));
//		WebElement target = driver.findElement(By.xpath("//div[@id='column-b']"));
//		
//		Action dragAndDrop  = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
//		
//		dragAndDrop.perform();
//		
//	}
//	
//	@Test
//	public void TC_07() {
//		//Open link
//		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
//		
//		//Drag and Drop
//		WebElement dragFrom2 = driver.findElement(By.xpath("//div[@id='draggable']"));
//		WebElement target2 = driver.findElement(By.xpath("//div[@id='droppable']"));
//		
//		Action dragAndDrop2  = action.clickAndHold(dragFrom2).moveToElement(target2).release(target2).build();
//		dragAndDrop2.perform();
//		
//		//Verify Text
//		String getText = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
//		assertEquals(getText, "Dropped!");
//	}
//	

	
	@Test
	public void TC_07_Extent() {
		//Open link
		driver.get("http://demo.guru99.com/v4/");
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.chord(Keys.SHIFT,"tab"));
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("Andrew");
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(Keys.chord(Keys.CONTROL,"n"));
		
		driver.get("https://www.google.com/");
		
		String newWindow = driver.getTitle();
		
		Assert.assertEquals(newWindow, "Google");
		
		
		
		
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
