package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/checkOut.feature",

        glue = "stepDefinitions.CheckOut",
        plugin = { "html:target/cucumber-html-reports/CheckOut.html",
                "json:target/cucumber-json-reports/CheckOut.json",
                "junit:target/cucumber-junit-reports/CheckOut.xml",
                "rerun:target/cucumber-text-reports/CheckOut.txt"
        },
        monochrome = true
)
public class checkOut {
}
