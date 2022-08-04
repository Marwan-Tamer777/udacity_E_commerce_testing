package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/checkOut.feature",

        glue = "stepDefinitions.CheckOut",
        plugin = { "html:target/cucumber-html-reports/checkOut.html"},
        monochrome = true
)
public class checkOut {
}
