package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\features",
        glue = {"stepdefinition"} ,
        format = { "json:target/cucumber.json" , "html:target/cucumber-pretty"} ,
        tags = {"@scenario2"}
        )
public class TestRunner {

}
