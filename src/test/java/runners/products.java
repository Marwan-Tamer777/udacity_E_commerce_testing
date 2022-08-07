package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/products.feature",

        glue = "stepDefinitions.Products",
        plugin = { "html:target/cucumber-html-reports/Products.html",
                "json:target/cucumber-json-reports/Products.json",
                "junit:target/cucumber-junit-reports/Products.xml",
                "rerun:target/cucumber-text-reports/Products.txt"
        },
        monochrome = true
)

public class products {
}
