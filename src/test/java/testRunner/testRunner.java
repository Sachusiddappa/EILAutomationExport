package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/featureFiles"},glue = {"stepdefinitions"},
plugin={"pretty","html:target/report/cucumber.html" ,"json:target/report/cucumber.json"},tags = "@equipments")
public class testRunner {
	
}
