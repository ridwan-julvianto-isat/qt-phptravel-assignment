package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//plugin = {"pretty", "html:target/cucumber"},
		features = { "src/test/resources/features" }, glue = { "phptravel.stepdefs" }
		// , monochrome = true
		, tags = { "@ready-to-test", "@valid-scenario" }
		//, tags = { "@under-construction" }
		// , tags = {"@end-to-end, @regression"} //run scenario tagged with @end-to-end OR @regression
		// , tags = {"@end-to-end", "@regression"} //run scenario tagged with @end-to-end AND @regression
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
