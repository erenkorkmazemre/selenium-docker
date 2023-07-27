package steps;

import common.AssertionOperation;
import common.ClickOperation;
import common.helpers.DataHelper;
import enums.Languages;
import io.cucumber.java.en.And;
import locators.CommonLocators;
import locators.Locators;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static drivers.DriverManager.getDriver;

public class Page1Steps {
    private final AssertionOperation assertionOperation;
    ClickOperation clickOperation = new ClickOperation();

    public Page1Steps() {
        this.assertionOperation = new AssertionOperation();
    }

    @And("Check if {string} and items are {string} listed")
    public void checkIfItemsAreListed(String arg0, String arg1) {
        By locatorCategoriesText = Locators.getPageLocators().get(arg0);
        String textOfElement = getDriver().findElement(locatorCategoriesText).getText();
        assertionOperation.checkEquals(arg0, textOfElement);
        List keys = new ArrayList(DataHelper.getData(arg1).keySet());
        for (int i = 0; i < DataHelper.getData(arg1).size(); i++) {
            String values = (String) DataHelper.getData(arg1).get(keys.get(i).toString());
            By locatorCategoriesList = CommonLocators.getPageLocatorsForCommonList(values).get("categoriesList");
            String textOfElementList = getDriver().findElement(locatorCategoriesList).getText();
            assertionOperation.checkEquals(values, textOfElementList);
        }
    }

    @And("Change the website language")
    public void changeTheWebsiteLanguage() {
        By locatorEnglish = Locators.getPageLocators().get("languageEnglish");
        boolean englishIsTrue = getDriver().findElement(locatorEnglish).isDisplayed();
        String value = null;
        if (englishIsTrue) {
            value = getDriver().findElement(locatorEnglish).getText();
        } else {
            assertionOperation.checkTrue(false);
        }

        String[] languageFirstElement = value.split(" ");

        switch (Languages.valueOf(languageFirstElement[0])) {
            case Türkçe:
                By locatorTurkishStart = Locators.getPageLocators().get("languageTurkish");
                clickOperation.clickOn(getDriver().findElement(locatorTurkishStart));
                By locatorEnglishStart = Locators.getPageLocators().get("languageEnglish");
                clickOperation.clickOn(getDriver().findElement(locatorEnglishStart));
                By updateLanguageEnglish = Locators.getPageLocators().get("updateLanguageEnglish");
                clickOperation.clickOn(getDriver().findElement(updateLanguageEnglish));
                break;
            case English:
                clickOperation.clickOn(getDriver().findElement(locatorEnglish));
                By locatorTurkish = Locators.getPageLocators().get("languageTurkish");
                clickOperation.clickOn(getDriver().findElement(locatorTurkish));
                By updateLanguageTurkish = Locators.getPageLocators().get("updateLanguageTurkish");
                clickOperation.clickOn(getDriver().findElement(updateLanguageTurkish));
                break;
        }
    }

    @And("Check if {string} options exist with {string} on page")
    public void checkIfOptionsExistWithOnPage(String arg0, String arg1) {
        By locator = Locators.getPageLocators().get(arg1);
        String textOfElement = getDriver().findElement(locator).getText();
        assertionOperation.checkEquals(arg0, textOfElement);
    }
}
