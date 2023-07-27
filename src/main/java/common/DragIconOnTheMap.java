package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static drivers.DriverManager.getDriver;

public class DragIconOnTheMap {
    private Logger log = Logger.getLogger(DragIconOnTheMap.class);
    private String logMessage = "";

    public void dragIconAndPinned(WebElement element) {
        new Actions(getDriver()).moveToElement(element, 0, 0).clickAndHold().moveByOffset(300, 30).release().build().perform();
        WaitOperation.wait(3);
        logMessage = String.format(" Clicked on '%s' ", element);
        log.info(logMessage);
    }
}
