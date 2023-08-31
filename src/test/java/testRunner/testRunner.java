package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},
        glue = "StepDefinition",
        tags = "@runningAll",
        plugin = {"pretty", "json:target/cucumber.json", "junit:target/cucumber-reports/cucumber.xml", "html:target/cucumber-reports/report.html"},
        publish = true)
public class testRunner {
}
