package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/VIOS/TestAPI/Colorlovers.feature",
        glue = {"stepDefinitions"},
        monochrome = true,
        strict = true
)

public class TestRunner {

}
