package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.TelevisionsPage;

public class DriverFactory {

    public static WebDriver driver;
    protected static HomePage amazonHomePage;
    protected static TelevisionsPage televisionsPage;


    /**
     * This method is used to initialize the thradlocal driver on the basis of given
     * browser
     *
     * @param browserName
     * @return this will return tldriver.
     */
    public static void init_driver(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else{
            System.out.println("The Browser requested is: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(ConstantVariable.applicationURL);

        amazonHomePage =new HomePage(driver);
        televisionsPage =new TelevisionsPage(driver);

    }
}