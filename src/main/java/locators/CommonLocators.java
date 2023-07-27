package locators;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CommonLocators {
    private static HashMap<String, By> pageLocators = new HashMap<String, By>();

    public static HashMap<String, By> getPageLocatorsForCommonList(String text) {
        listingPageLocators(text);
        return pageLocators;
    }


    private static void addXpath(String key, By value) {
        pageLocators.put(key, value);
    }

    private static void listingPageLocators(String text) {
        addXpath("categoriesList", By.xpath("(//span[contains(text(), '" + text + "')])[1]"));
        addXpath("categoriesSubList", By.xpath("(//span[contains(text(), '" + text + "')])[1]"));
        addXpath("categoriesOnClickList", By.xpath("(//div[contains(text(), '" + text + "')])[last()]"));
        addXpath("categoriesSubRandomElement", By.xpath("//div[@data-testid='panel-body']//a[" + text + "]"));
        addXpath("cuisinesTitle", By.xpath("(//img[@alt='" + text + "'])"));
        addXpath("buttonTitle", By.xpath("(//button[contains(text(), '" + text + "')])[last()]"));
        addXpath("randomButtonTitle", By.xpath("(//button[contains(text(), '" + text + "')])[1]"));

    }
}
