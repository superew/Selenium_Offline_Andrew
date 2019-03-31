 package common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunction {
	private int timeouts = 20;
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
		
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void click(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public String getText(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public void clear(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void input(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	
	public void selectComboboxByVisibleText(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}
	
	public void selectComboboxByValue(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByValue(value);
	}
	
	public String getTextComboboxSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
		
	}
	public String getAtribute(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}
	
	public int getSizeList(WebDriver driver, String locator) {
		List<WebElement> list = driver.findElements(By.xpath(locator));
		return list.size();
	}
	
	public boolean isDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isSelected (WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public boolean isEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void inputAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
		public void switchToWindowByTitle(WebDriver driver, String title) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String childWindows : allWindows) {
				driver.switchTo().window(childWindows);
				String childTitle = driver.getTitle();
				if (childTitle.equals(title)) {
					break;
				}
			}
	}
	
	public String getWindow(WebDriver driver) {
		return driver.getWindowHandle();
	}
	
	public void switchToIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(locator);
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hover(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}
	
	public void rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver).contextClick(element);
		action.build().perform();
	}
	
	public void dragAndDrop(WebDriver driver, String locatorFrom, String locatorTarget) {
		WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();
	}
	
	public void clickAndHold(WebDriver driver, String locator, int itemFrom, int itemTarget) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
		action.release();
	}
	
	public void inputKeys(WebDriver driver, String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(key);

	}
	
	public void uploadBySendKeys(WebDriver driver, String locator, String value) {
		WebElement btnBrowse = driver.findElement(By.xpath(locator));
		btnBrowse.sendKeys(value);
	}
	
	public void uploadByRobot(WebDriver driver, String locator, String value) throws Exception {
		StringSelection select = new StringSelection(value);
		WebElement btnBrowse = driver.findElement(By.xpath(locator));
		btnBrowse.click();
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


	}
	
	public void executeScriptBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript);
	}
	
	public String getTextjQuery(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(javaScript).toString();
	}
	public void clickByJavascript(WebDriver driver, String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		js.executeScript("arguments[0].click();", element);
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	public void highlight(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style='border: 2px solid; border-color: red'", element);
	}
	
	public void removeAttribute(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}
	
	public void waitPresence(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	public void waitVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void waitAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	// Create random email
		public static String randomEmail() {
			Random rand = new Random();
			int number = rand.nextInt(9999999);
			return String.valueOf(number);
		}

}
