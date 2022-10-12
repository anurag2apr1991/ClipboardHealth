package StepDefinitions;

import Util.Utilties;
import driver.ConstantVariable;
import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SamsungPageSteps extends DriverFactory {

    @Given("User Enter the amazon webpage URL")
    public void user_enter_the_amazon_webpage_url() {
        driver.get(ConstantVariable.applicationURL);
    }
    @Then("User landed on the amazon website according to region of user")
    public void user_landed_on_the_amazon_website_according_to_region_of_user() {
        amazonHomePage.verifyTheAmazonIndia();
    }
    @Then("user verify the user present on home page")
    public void user_verify_the_user_present_on_home_page() {
        amazonHomePage.verifyHomePage();
    }
    @When("user click on hamburger icon")
    public void user_click_on_hanburger_icon() {
        amazonHomePage.clickonAllCategories();
    }
    @Then("verify the {string} with {string} name is visible")
    public void verify_the_shop_by_department_with_tv_appliances_electronics_name_is_visible(String categoryName,String subCategoryName) {
        amazonHomePage.clickOnCategory(categoryName,subCategoryName);
    }
    @When("user click on {string} with {string} name")
    public void user_click_on_tv_audio_cameras_with_television_name(String subSubCategoryName,String productType) {
        amazonHomePage.clickOnSection(subSubCategoryName, productType);
    }
    @Then("verify user landed on the correct {string} name")
    public void verify_user_landed_on_the_correct_television_name(String productType) {
        televisionsPage.verifyTelevisionPage(productType);
    }
    @Then("Scroll to the Brand Names Heading")
    public void scroll_to_the_brand_names_heading() {
        televisionsPage.scrollToBrandHeading();
    }
    @When("User Click on the {string}")
    public void user_click_on_the(String brandName) {
        televisionsPage.selectBrandName(brandName);
    }

    @Then("User Click on the Sort the according to price by High To Low")
    public void user_click_on_the_sort_the_according_to_price_by() {
        televisionsPage.sortByPrice();
    }
    @When("User Click on the Second Highest TV")
    public void user_click_on_the_second_highest_tv() {
        televisionsPage.selectSecondHighestTelevison();
    }
    @Then("The Page of the Second Highest Page is open")
    public void the_page_of_the_second_highest_page_is_open() {
        Utilties.waitForPageLoad(driver);
        Utilties.swtichToTab(1,false);

    }
    @Then("Display the About this item into the scroll")
    public void display_the_about_this_item_into_the_scroll() throws InterruptedException {
        televisionsPage.displayAboutInConsole();
    }
}
