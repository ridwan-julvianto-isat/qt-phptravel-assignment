package phptravel.stepdefs.webpages;

import org.junit.Assert;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import phptravel.stepdefs.PageObjects;
import utils.PropertyHandler;

public class AccountPageStepDefs extends PageObjects {
	
	@And("^My Account page displays welcome message$")
	public void my_account_page_displays_welcome_message() throws Throwable {

        String firstName = PropertyHandler.testData.getValue("firstName");
        String lastName = PropertyHandler.testData.getValue("lastName");
        
		accountPage.verifyGreeting(firstName, lastName);
	}
	
	@And("^My Account page displays welcome message without Last Name$")
	public void my_account_page_displays_welcome_message_without_last_name() throws Throwable {

        String firstName = PropertyHandler.testData.getValue("firstName");
        String lastName = "";
        
		accountPage.verifyGreeting(firstName, lastName);
	}
}
