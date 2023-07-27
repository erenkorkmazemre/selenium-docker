package steps;

import common.AssertionOperation;
import common.ClickOperation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Locators;
import org.openqa.selenium.By;
import utilities.ConfigProperties;

import static drivers.DriverManager.getDriver;

public class CommonSteps {
    private final AssertionOperation assertionOperation;
    ClickOperation clickOperation = new ClickOperation();
    ConfigProperties configProperties = new ConfigProperties();

    public CommonSteps() {
        this.assertionOperation = new AssertionOperation();
    }

    @Given("Go to address")
    public void goToAddress() {
        getDriver().get(configProperties.getProperties("LOCAL_URL"));
    }

    @When("Click the plus button")
    public void clickThePlusButton() {
        By locator = Locators.getPageLocators().get("plusButton");
        clickOperation.clickOn(getDriver().findElement(locator));
    }

    @Then("Check {string} service exist on page")
    public void checkServiceExistWithOnPage(String string) {
        By locator = Locators.getPageLocators().get(string);
        Boolean service = getDriver().findElement(locator).isDisplayed();
        assertionOperation.checkTrue(service);
    }


}
