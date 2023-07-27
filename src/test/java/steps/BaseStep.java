package steps;

import enums.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigProperties;

import static drivers.DriverManager.createDriver;
import static drivers.DriverManager.quitDriver;


public class BaseStep {

    private static final String BROWSER = new ConfigProperties().getProperties("BROWSER");
    private static final String REMOTE_BROWSER = new ConfigProperties().getProperties("REMOTE_BROWSER");

    @Before
    public void setupTest(Scenario scenario) {
        if (!(scenario.getSourceTagNames().contains("@RunAllRemote"))) {
            createDriver(Browsers.valueOf(BROWSER));
        } else {
            createDriver(Browsers.valueOf(REMOTE_BROWSER));
        }
    }


    @After
    public void tearDown() {
        quitDriver();
    }


}
