package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", //folder path
        glue = {"stepdefs"}) //package name
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
