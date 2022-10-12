package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import driver.DriverFactory;
import Util.Utilties;
import org.testng.Assert;

import java.util.List;

public class TelevisionsPage extends DriverFactory {

    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    @FindBy(xpath = "//span[text()='Brands']")
    WebElement brandHeading;

    @FindBy(xpath = "//span[text()='RESULTS']")
    WebElement resultsHeading;

    @FindBy(xpath = "//span[text()='Sort by:']/following-sibling::span")
    WebElement sortDropDown;

    @FindBy(xpath = "//a[text()='Price: High to Low']")
    WebElement sortByHighToLow;

    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]")
    WebElement secondHighestTelevision;

    @FindBys(@FindBy(xpath = "//div[@id='feature-bullets']/ul/li"))
    List<WebElement> aboutSection;

    @FindBy(xpath = "//h1[text()=' About this item ']")
    WebElement aboutThisItemLabel;

    public TelevisionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verifyTelevisionPage(String productTypes) {
        Utilties.waitForPageLoad(driver);
        String productType = driver.findElement(By.xpath("//li/span/span[contains(text(),'" + productTypes + "')]")).getText();
    }

    public void scrollToBrandHeading() {
        Utilties.waitForPageLoad(driver);
        if (brandHeading.isDisplayed()) {
            Utilties.scrollToViewWebElement(brandHeading);
        }
    }

    public void selectBrandName(String brandName) {
        driver.findElement(By.xpath("//span[text()='" + brandName + "']")).click();
        Utilties.waitForElementVisibility(resultsHeading);
    }

    public void sortByPrice() {
        String tempText = resultsHeading.getText();
        Assert.assertEquals(tempText, "RESULTS");
        sortDropDown.click();
        System.out.println("Type of Sort Filter is :" + sortByHighToLow.getText());
        sortByHighToLow.click();
    }

    public void selectSecondHighestTelevison() {
        Utilties.waitForElementVisibility(secondHighestTelevision);
        secondHighestTelevision.click();
        Utilties.waitForPageLoad(driver);
    }

    public void displayAboutInConsole() throws InterruptedException {
        Utilties.waitForElementVisibility(aboutThisItemLabel);
        int noOfPoints = aboutSection.size();
        Utilties.scrollToElement(aboutThisItemLabel);
        Assert.assertEquals("About this item", aboutThisItemLabel.getText().trim());
        System.out.println("--About This Item--");
        for (int i = 1; i <= noOfPoints; i++) {
            System.out.println(driver.findElement(By.xpath("//div[@id='feature-bullets']/ul/li[" + i + "]")).getText());
        }
        System.out.println("------End-----");
    }
}
