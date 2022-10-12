package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverFactory;
import Util.Utilties;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends DriverFactory {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    @FindBy(id="nav-hamburger-menu")
    WebElement allcategories;

    @FindBy(id = "glow-ingress-line1")
    WebElement homePageElement;

    @FindBy(xpath = "//div[contains(text(),'shop by category')]")
    WebElement shopByCategory;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public void clickonAllCategories() {
        Utilties.implictWait();
        wait.until(ExpectedConditions.elementToBeClickable(allcategories));
        allcategories.click();
        Utilties.waitForElementVisibility(shopByCategory);
        String gettingtextshopByDepartment= shopByCategory.getText();
        Assert.assertEquals(gettingtextshopByDepartment,"Shop By Category");
    }

    public void clickOnCategory(String categoryName, String subCategoryName) {
        WebElement sideMenuCategory = driver.findElement(By.xpath("//div[contains(text(),'" + categoryName + "')]//following::li/a/div[text()='" + subCategoryName + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(sideMenuCategory));
        Utilties.clickElement(sideMenuCategory);
    }

    public void clickOnSection(String subSubCategoryName, String productType) {
        WebElement finalCategoryWithproductType = driver.findElement(By.xpath("//div[contains(text(),'" + subSubCategoryName + "')]/following::li/a[text()='" + productType + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(finalCategoryWithproductType));
        Utilties.clickElement(finalCategoryWithproductType);
    }

    public void verifyTheAmazonIndia() {
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("https://www.amazon.in/")) {
            System.out.println("Amazon India Home Page");
        } else {
            System.out.println("User Landed on Other Than Amazon India Home Page Region");
        }
    }

    public void verifyHomePage(){
        String getText=homePageElement.getText();
        if (getText.contentEquals("Hello")){
            System.out.println("User At Home Page");
        }
        else {
            System.out.println("User not on Home Page");
        }
    }

}
