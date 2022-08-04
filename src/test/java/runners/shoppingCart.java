package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/shoppingCart.feature",

        glue = "stepDefinitions.ShoppingCart",
        plugin = { "html:target/cucumber-html-reports/shoppingCart.html"},
        monochrome = true
)
public class shoppingCart {
}
