package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ClickOperation {

    private Logger log = Logger.getLogger(ClickOperation.class);
    private String logMessage = "";


    public void clickOn(WebElement element) {
        element.click();
        logMessage = String.format(" Clicked on '%s' ", element);
        log.info(logMessage);
    }


}
