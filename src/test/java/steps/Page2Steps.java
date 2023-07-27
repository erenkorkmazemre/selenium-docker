package steps;

import common.AssertionOperation;
import common.ClickOperation;
import common.WaitOperation;
import common.helpers.DataHelper;
import io.cucumber.java.en.And;
import locators.CommonLocators;
import locators.Locators;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static drivers.DriverManager.getDriver;

public class Page2Steps {

    private final AssertionOperation assertionOperation;
    ClickOperation clickOperation = new ClickOperation();
    Random randomNumber = new Random();

    public Page2Steps() {
        this.assertionOperation = new AssertionOperation();
    }

    @And("Choose a random category from the {string} and check if exist")
    public void chooseARandomCategoryFromTheList(String string) {
        int low = 0;
        int high = DataHelper.getData(string).size();
        int randomCategory = randomNumber.nextInt(high - low) + low;
        List keys = new ArrayList(DataHelper.getData(string).keySet());
        String value = (String) DataHelper.getData(string).get(keys.get(randomCategory).toString());
        By locatorCategory = CommonLocators.getPageLocatorsForCommonList(value).get("categoriesList");
        String textOfElement = getDriver().findElement(locatorCategory).getText();
        clickOperation.clickOn(getDriver().findElement(locatorCategory));
        By locatorActual = CommonLocators.getPageLocatorsForCommonList(textOfElement).get("categoriesOnClickList");
        String textActual = getDriver().findElement(locatorActual).getText();
        assertionOperation.checkEquals(textActual, textOfElement);
        WaitOperation.wait(4);
    }

    @And("Select one of the subcategories under a random category {string}")
    public void selectOneOfTheSubcategoriesUnderARandomCategory(String string) {
        int low = 0;
        int high = DataHelper.getData(string).size();
        int randomCategory = randomNumber.nextInt(high - low) + low;
        List keys = new ArrayList(DataHelper.getData(string).keySet());
        String value = (String) DataHelper.getData(string).get(keys.get(randomCategory).toString());
        By locatorCategory = CommonLocators.getPageLocatorsForCommonList(value).get("categoriesSubList");
        String textOfElement = getDriver().findElement(locatorCategory).getText();
        clickOperation.clickOn(getDriver().findElement(locatorCategory));
        By locatorActual = CommonLocators.getPageLocatorsForCommonList(textOfElement).get("categoriesOnClickList");
        String textActual = getDriver().findElement(locatorActual).getText();
        assertionOperation.checkEquals(textActual, textOfElement);
        By locatorCategorysss = Locators.getPageLocators().get("categoriesSubProductSize");
        int count = getDriver().findElements(locatorCategorysss).size();
        int randomSubCategory = randomNumber.nextInt(count - low) + low;
        By locatorCategoriesSubRandomElement = CommonLocators.getPageLocatorsForCommonList(String.valueOf(randomSubCategory)).get("categoriesSubRandomElement");
        clickOperation.clickOn(getDriver().findElement(locatorCategoriesSubRandomElement));
    }


}
