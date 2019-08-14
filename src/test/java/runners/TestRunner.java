package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//plugin = {"pretty", "html:target/cucumber"},
		features = {"src/test/resources/features"}
		, glue={"phptravel.stepdefs"}
		//, monochrome = true
		, tags = { "ready-to-test" }
		//, tags = {"@end-to-end, @regression"} //run tagged as @end-to-end OR @regression
		//, tags = {"@end-to-end", "@regression"} //run tagged as @end-to-end AND @regression -- meaning must have both tags
	 )
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
