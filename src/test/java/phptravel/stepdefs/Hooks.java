package phptravel.stepdefs;

import org.apache.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverFactory;

public class Hooks extends PageObjects {

	final static Logger logger = Logger.getLogger(Hooks.class);

	@Before
	public void beforeScenario() {
		PageObjects.init();
	}

	@After
	public void afterScenario() {
		PageObjects.close();
	}
}
