package phptravel.stepdefs.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.RegistrationPage;
import phptravel.stepdefs.PageObjects;
import utils.WebDriverFactory;

public class RegistrationPageStepDefs extends PageObjects {

	final static Logger logger = Logger.getLogger(RegistrationPageStepDefs.class);
	private WebDriver driver = WebDriverFactory.getInstance().getWebDriver();
	
	
	 @When("^User input correct Registration data with Last Name$")
	    public void user_input_correct_registration_data_with_last_name() throws Throwable {
	        throw new PendingException();
	    }

	    @When("^User input correct Registration data without Last Name$")
	    public void user_input_correct_registration_data_without_last_name() throws Throwable {
	        throw new PendingException();
	    }
	    
	    @And("^User submit the Registration form$")
	    public void user_submit_the_registration_form() throws Throwable {
	        throw new PendingException();
	    }

	    @When("^User input value in violation of (.+) in (.+) in Registration form$")
	    public void user_input_value_in_violation_of_in(String validationrule, String fieldname) throws Throwable {
	        throw new PendingException();
	    }
	    
	    @Then("^Registration page displays (.+) on top of Registration form$")
	    public void registration_page_displays_on_top_of_registration_form(String errormessage) throws Throwable {
	        throw new PendingException();
	    }

}