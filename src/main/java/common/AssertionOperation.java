package common;

import org.apache.log4j.Logger;
import org.junit.Assert;


public class AssertionOperation {

    private final Logger log = Logger.getLogger(AssertionOperation.class);
    String logMessage = "";

    public void checkEquals(String expectedValue, String actualValue) {
        if (!expectedValue.equals(actualValue)) {
            logMessage = String.format("'%s' and '%s' are not equal!", expectedValue, actualValue);
            log.error(logMessage);
            Assert.fail(logMessage);
        }
        logMessage = String.format("'%s' and '%s' are checked whether they are equal or not!", expectedValue, actualValue);
        log.info(logMessage);
    }

    public void checkNotEquals(String expectedValue, String actualValue) {
        if (expectedValue.equals(actualValue)) {
            logMessage = String.format("'%s' and '%s' are not equal!", expectedValue, actualValue);
            log.error(logMessage);
            Assert.fail(logMessage);
        }
        logMessage = String.format("'%s' and '%s' are checked whether they are equal or not!", expectedValue, actualValue);
        log.info(logMessage);
    }


    public void checkTrue(Boolean expectedValue) {
        if (Boolean.FALSE.equals(expectedValue)) {
            logMessage = String.format("'%s' is not displayed", false);
            log.error(logMessage);
            Assert.fail(logMessage);
        }
        logMessage = String.format("'%s' is checked whether they are equal or not!", true);
        log.info(logMessage);
    }

}
