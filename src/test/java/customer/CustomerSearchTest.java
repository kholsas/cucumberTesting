package customer;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/customer"},
        glue ={"customer"}
)
public class CustomerSearchTest {

}