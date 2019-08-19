package phptravel.stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverFactory;

public class CommonStepDefs extends PageObjects {

	final static Logger logger = Logger.getLogger(CommonStepDefs.class);

    @Given("^PHP Travel homepage is displayed$")
    public void php_travel_homepage_is_displayed() throws Throwable {
    	logger.info("Opening PHP Travel homepage.");
    	homePage.openHomepage();
    }
    
    @And("^User navigated to \"([^\"]*)\" page$")
    public void user_navigated_to_page(String pagename) throws Throwable {
        switch (pagename) {
			case "Registration":
				logger.info("Opening registration page");
				homePage.goToRegistrationPage();
				registrationPage.verifyRegistrationPageOpens();
				break;
			default:
				break;
		}
    }

    @Then("^System navigates to \"([^\"]*)\" page$")
    public void system_navigates_to_page(String pagename) throws Throwable {
        switch (pagename) {
			case "My Accounts":
				logger.info("Opening My Accounts page");
				accountPage.verifyAccountPageOpens();
				break;
			default:
				break;
		}
    }
}
