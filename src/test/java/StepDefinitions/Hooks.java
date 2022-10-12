package StepDefinitions;

import java.util.Properties;

import Util.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverFactory{

	ConfigReader configReader;
	Properties properties;
	String screenshotName;
	String tempScenarioName;

	public Hooks(){
		super();
	}

	/** Reading the config properties when application Starts */
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		properties = configReader.initProperties();
	}

	/** Passing the browser name */
	@Before(order = 1)
	public void launchBrowser(Scenario scenario) {
		tempScenarioName = scenario.getName();
		String browserName = properties.getProperty("browser");
		System.out.println(tempScenarioName + " Scenario is Running");
		init_driver(browserName);
	}

	@After(order = 0)
	public void closingBrowser() {
		if (!tempScenarioName.toLowerCase().contains("api")) {
			System.out.println("Closing the Browser");
			driver.quit();
		}
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (!tempScenarioName.toLowerCase().contains("api")) {
			if (scenario.isFailed())
				screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
