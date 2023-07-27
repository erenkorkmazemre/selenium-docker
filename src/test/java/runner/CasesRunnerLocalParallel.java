package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}, glue = {
        "steps",
}, plugin = {"pretty", "html:src/test/resources/reports/cucumber-reports-parallel.html",
        "json:target/CasesRunnerParallel.json"}, tags = "@RunAll")
public class CasesRunnerLocalParallel extends AbstractTestNGCucumberTests {

}
