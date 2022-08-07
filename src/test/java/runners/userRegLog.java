package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/userRegLog.feature",

        glue = "stepDefinitions.UserRegLog",
        plugin = { "html:target/cucumber-html-reports/UserRegLog.html",
                "json:target/cucumber-json-reports/UserRegLog.json",
        "junit:target/cucumber-junit-reports/UserRegLog.xml",
        "rerun:target/cucumber-text-reports/UserRegLog.txt"
        },
        monochrome = true
)


public class userRegLog {
}
