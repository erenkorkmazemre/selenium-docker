package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class SendKeyOperation {

    private Logger log = Logger.getLogger(ClickOperation.class);
    private String logMessage = "";

    public void sendKey(String text, WebElement element) {
        element.click();
        element.clear();
        element.sendKeys(text);
        logMessage = String.format(" Sent '%s' to '%s' ", text, element);
        log.info(logMessage);
    }
}
