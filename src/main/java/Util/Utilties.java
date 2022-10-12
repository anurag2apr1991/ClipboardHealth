package Util;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class Utilties extends DriverFactory {
	
	static WebDriverWait wait;

	public Utilties(WebDriver driver) {
		Utilties.driver = driver;
	}

	public static void waitForElementVisibility(WebElement findOfElement) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(findOfElement));
	}

	public static void waitForPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(pageLoadCondition);
	}
	public static void clickElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public static void scrollToElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}
	public static void scrollToViewWebElement(WebElement webElement) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}
	public static void swtichToTab(int swtichToTab, boolean swtichToMainTab) {
		//Get the current window handle
		String windowHandle = driver.getWindowHandle();
		//Get the list of window handles
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println("No of tabs Open is: "+tabs.size());
		//Use the list of window handles to switch between windows
		driver.switchTo().window(tabs.get(swtichToTab));
		if (swtichToMainTab) {
			//Switch back to original window
			driver.switchTo().window(tabs.get(0));	
		}
	}
	public static void implictWait(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

}
