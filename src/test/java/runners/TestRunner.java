package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "src/test/resources/features",
        glue= "stepDefinitions",
        tags= "@DBUtils",
        dryRun = false
)

public class TestRunner {

        // JUnit framework is used because @RunWith(Cucumber.class) method that runs the runner class comes with JUnit framework.
}
