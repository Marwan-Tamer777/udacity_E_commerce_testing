package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/shoppingCart.feature",

        glue = "stepDefinitions.ShoppingCart",
        plugin = { "html:target/cucumber-html-reports/ShoppingCart.html",
                "json:target/cucumber-json-reports/ShoppingCart.json",
                "junit:target/cucumber-junit-reports/ShoppingCart.xml",
                "rerun:target/cucumber-text-reports/ShoppingCart.txt"
        },
        monochrome = true
)
public class shoppingCart {
}
