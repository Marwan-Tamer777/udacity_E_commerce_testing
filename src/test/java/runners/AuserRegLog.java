package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/userRegLog.feature",

        glue = "stepDefinitions.UserRegLog",
        plugin = { "html:target/cucumber-html-reports/UserRegLog.html"},
        monochrome = true
)


public class AuserRegLog {
}
