package phptravel.stepdefs;

import org.apache.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends APageObjects {

	final static Logger logger = Logger.getLogger(Hooks.class);

	@Before
	public void beforeScenario() {
		logger.info("Initializing WebDriver and PageObjects");
		APageObjects.init();
	}

	@After
	public void afterScenario() {
		logger.info("Closing WebDriver");
		APageObjects.close();
	}
}
