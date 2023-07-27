package common;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static drivers.DriverManager.getDriver;

public class WaitOperation {

    private static Logger log = Logger.getLogger(ClickOperation.class);
    private String logMessage = "";
    private static int staticWait = 0;
    private WebDriver webDriver;

    public WaitOperation() {

        webDriver = getDriver();
    }

    public static void wait(int second) {

        try {
            Thread.sleep(second * (long) 1000);
            staticWait += second;
            String logMessage = String.format("'%s' second(s) waited statically!", second);
            log.warn(logMessage);
        } catch (Exception ex) {
            log.error("There is an error about static wait : " + ex.getMessage());
        }
    }

}
