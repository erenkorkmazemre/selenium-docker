package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}, glue = {
        "steps",
}, plugin = {"pretty", "html:src/test/resources/reports/cucumber-reports.html",
        "json:target/CasesRunner.json"}, tags = "@RunAll")
public class CasesRunner extends AbstractTestNGCucumberTests {

}
