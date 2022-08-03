package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/shoppingCart.feature",

        glue = "stepDefinitions.ShoppingCart"
)
public class shoppingCart {
}
