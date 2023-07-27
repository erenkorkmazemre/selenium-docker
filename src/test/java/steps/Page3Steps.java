package steps;

import common.*;
import io.cucumber.java.en.And;
import locators.CommonLocators;
import locators.Locators;
import org.openqa.selenium.By;

import java.util.Random;

import static drivers.DriverManager.getDriver;

public class Page3Steps {

    private final AssertionOperation assertionOperation;
    ClickOperation clickOperation = new ClickOperation();
    DragIconOnTheMap dragIconOnTheMap = new DragIconOnTheMap();
    SendKeyOperation sendKeyOperation = new SendKeyOperation();
    Random randomNumber = new Random();

    public Page3Steps() {
        this.assertionOperation = new AssertionOperation();
    }

    @And("Change the service to {string}")
    public void changeTheService(String arg0) {
        By locator = Locators.getPageLocators().get(arg0);
        clickOperation.clickOn(getDriver().findElement(locator));
    }

    @And("Choose one of the {string} from {string}")
    public void choseOneOfTheCuisines(String arg0, String arg1) {
        By locator = CommonLocators.getPageLocatorsForCommonList(arg0).get(arg1);
        clickOperation.clickOn(getDriver().findElement(locator));
    }

    @And("Drag the house icon pinned on the map somewhere {string} on the map")
    public void dragTheHouseIconPinnedOnTheMapSomewhere(String arg0) {
        By locator = Locators.getPageLocators().get(arg0);
        dragIconOnTheMap.dragIconAndPinned(getDriver().findElement(locator));
        WaitOperation.wait(3);
    }

    @And("Check if {string} options not exist with {string} on page")
    public void checkIfOptionsNotExistWithOnPage(String arg0, String arg1) {
        By locator = Locators.getPageLocators().get(arg1);
        String textOfElement = getDriver().findElement(locator).getText();
        assertionOperation.checkNotEquals(arg0, textOfElement);
    }


    @And("Click the {string} button")
    public void clickTheButton(String arg1) {
        By locator = CommonLocators.getPageLocatorsForCommonList(arg1).get("buttonTitle");
        clickOperation.clickOn(getDriver().findElement(locator));
        WaitOperation.wait(3);
    }

    @And("Send keys into {string} {string} {string} {string} for delivery")
    public void sendKeysForDelivery(String arg0, String arg1, String arg2, String arg3) {
        By locatorBuilding = Locators.getPageLocators().get("deliveryBuilding");
        By locatorFloor = Locators.getPageLocators().get("deliveryFloor");
        By locatorNo = Locators.getPageLocators().get("deliveryNo");
        By locatorDescription = Locators.getPageLocators().get("deliveryDescription");
        sendKeyOperation.sendKey(arg0, getDriver().findElement(locatorBuilding));
        sendKeyOperation.sendKey(arg1, getDriver().findElement(locatorFloor));
        sendKeyOperation.sendKey(arg2, getDriver().findElement(locatorNo));
        sendKeyOperation.sendKey(arg3, getDriver().findElement(locatorDescription));
    }

    @And("Click the first restaurant")
    public void clickTheFirstRestaurant() {
        By locator = Locators.getPageLocators().get("firstRestaurant");
        WaitOperation.wait(3);
        clickOperation.clickOn(getDriver().findElement(locator));
    }

    @And("Click the random {string} button")
    public void clickTheRandomButton(String arg1) {
        int low = 0;
        By locator = CommonLocators.getPageLocatorsForCommonList(arg1).get("randomButtonTitle");
        int high = getDriver().findElements(locator).size();
        int randomAddNumber = randomNumber.nextInt(high - low) + low;
        clickOperation.clickOn(getDriver().findElements(locator).get(randomAddNumber));
    }
}
