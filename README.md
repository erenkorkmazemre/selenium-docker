#  Selenium && Docker Boiler plate

It is an automation project created for Selenium && Docker Boiler plate


## Installation

Use git command
```bash
```

Compile the project
```bash
mvn package -Dmaven.test.skip
```
Push the Docker Hub
```bash
docker-compose -f docker-compose.yml up
```
## Usage
### For Local Test
Check CaseRunner.java file; inside *src/test/java/runner/CasesRunner.java* and run the file
```
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}, glue = {
        "steps",
}, plugin = {"pretty", "html:src/test/resources/reports/cucumber-reports.html",
        "json:target/3CasesRunner.json"}, tags = "@RunAll")
public class CasesRunner extends AbstractTestNGCucumberTests {

}
```
### For Local Parallel Test
Check parallel.xml file; inside *src/test/java/suits/parallel.xml* and run the file

```
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Multi browser test" verbose="1" parallel="tests" thread-count="99">

    <test name="Chrome execution First">
        <parameter name="BROWSER" value="CHROME"/>
        <classes>
            <class name="runner.CasesRunnerLocalParallel"/>
        </classes>
    </test>

    <test name="Chrome Execution Second">
        <parameter name="BROWSER" value="CHROME"/>
        <classes>
            <class name="runner.CasesRunnerLocalParallel" />
        </classes>
    </test>

</suite>
```

### For Remote Docker Parallel Test 
Check parallel-seleniumgrid-remote.xml file; inside *src/test/java/suits/parallel-seleniumgrid-remote* and run the file

```
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Multi browser test" verbose="1" parallel="tests" thread-count="99">

    <test name="Chrome execution First">
        <parameter name="BROWSER" value="REMOTE_CHROME"/>
        <classes>
            <class name="runner.CasesRunnerRemoteParallel"/>
        </classes>
    </test>

    <test name="Chrome Execution Second">
        <parameter name="BROWSER" value="REMOTE_EDGE"/>
        <classes>
            <class name="runner.CasesRunnerRemoteParallel" />
        </classes>
    </test>

</suite>
```



## Technology

* Java
* Selenium
* Cucumber
* Maven
* TestNG
* JUnit
* Docker
* Selenium Grid

## License
[MIT](https://choosealicense.com/licenses/mit/)

