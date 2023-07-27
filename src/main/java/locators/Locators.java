package locators;

import org.openqa.selenium.By;

import java.util.HashMap;

public class Locators {

    private static HashMap<String, By> pageLocators;

    public static HashMap<String, By> getPageLocators() {
        if (pageLocators == null)
            pageLocators = new HashMap<String, By>();
        if (pageLocators.size() <= 0)
            initPageLocators();
        return pageLocators;
    }


    private static void addXpath(String key, By value) {
        pageLocators.put(key, value);
    }

    private static void initPageLocators() {
        addXpath("loginTitle", By.xpath("(//button[contains(text(), 'Login')])"));
        addXpath("Service", By.xpath("(//img[@alt=''])"));
        addXpath("foodService", By.xpath("(//img[@alt='Food'])"));
        addXpath("moreService", By.xpath("(//img[@alt='More'])"));
        addXpath("waterService", By.xpath("(//img[@alt='Water'])"));
        addXpath("Categories", By.xpath("(//h6[contains(text(), 'Categories')])[1]"));
        addXpath("languageEnglish", By.xpath("(//span[contains(text(), 'English')])[1]"));
        addXpath("languageTurkish", By.xpath("(//span[contains(text(), 'Türkçe')])[1]"));
        addXpath("updateLanguageTurkish", By.xpath("(//button[contains(text(), 'Update')])[last()]"));
        addXpath("updateLanguageEnglish", By.xpath("(//button[contains(text(), 'Güncelle')])[last()]"));
        addXpath("languageTitle", By.xpath("(//span[contains(text(), 'Türkçe')])[1]"));
        addXpath("categoriesSubTitle", By.xpath("(//h5[contains(text(), 'Categories')])"));
        addXpath("categoriesSubProductSize", By.xpath("//div[@data-testid='panel-body']//a"));
        addXpath("food", By.xpath("(//img[@alt='Food'])"));
        addXpath("foodHomePage", By.xpath("(//h5[contains(text(), 'Cuisines')])"));
        addXpath("addDeliveryAddressTitle", By.xpath("(//div[contains(text(), 'Add Delivery Address')])"));
        addXpath("mapTitle", By.xpath("(//ymaps[@class='ymaps-2-1-79-map ymaps-2-1-79-i-ua_js_yes ymaps-2-1-79-map-bg ymaps-2-1-79-islets_map-lang-en'])"));
        addXpath("addressTitle", By.xpath("(//address[@class='sc-ddb70c61-4 dfTHmR'])[last()]"));
        addXpath("deliveryBuilding", By.xpath("(//input[@placeholder='Building'])[last()]"));
        addXpath("deliveryFloor", By.xpath("(//input[@placeholder='Floor'])[last()]"));
        addXpath("deliveryNo", By.xpath("(//input[@placeholder='Apt. No'])[last()]"));
        addXpath("deliveryDescription", By.xpath("(//input[@placeholder='Address Directions'])[last()]"));
        addXpath("firstRestaurant", By.xpath("(//div[@data-testid='paragraph'])[2]"));
        addXpath("rightCard", By.xpath("(//span[contains(text(), 'Your basket is empty')])"));
        addXpath("plusButton", By.xpath("(//button[@aria-label='counter'])[last()-1]"));

    }
}
