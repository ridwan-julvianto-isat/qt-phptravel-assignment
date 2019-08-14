package phptravel.stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.RegistrationPage;
import utils.WebDriverFactory;

public class CommonStepDefs extends PageObjects {
	
	final static Logger logger = Logger.getLogger(CommonStepDefs.class);
	private WebDriver driver = WebDriverFactory.getInstance().getWebDriver();
	
    @And("^PHP Travel homepage is displayed$")
    public void php_travel_homepage_is_displayed() throws Throwable {
    	logger.info("open Homepage");
    	homepage = new HomePage(driver);
    	homepage.openHomepage();
    }

    @Then("^System navigates to \"([^\"]*)\" page$")
    public void system_navigates_to_target_page(String pageName) throws Throwable {
    	//system change page after some action. e.g. going to My Account page after registration
        throw new PendingException();
    }
    
    @And("^System stays in \"([^\"]*)\" page$")
    public void stays_in_page(String strArg1) throws Throwable {
        throw new PendingException();
    }
    

	@And("^User navigated to \"([^\"]*)\" page$")
    public void user_navigated_to_a_page(String pageName) throws Throwable {
		switch (pageName) {
		case "Registration":
			logger.info("Opening Registration page");
	        registration = new RegistrationPage(driver);
			break;
		case "Login":
			logger.info("Opening Login page");
	        //login = new LoginPage(driver);
			break;
		default:
			break;
		}
    }

}
