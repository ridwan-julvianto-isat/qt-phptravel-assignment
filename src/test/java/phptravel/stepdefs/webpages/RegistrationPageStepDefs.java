package phptravel.stepdefs.webpages;

import org.apache.log4j.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import phptravel.stepdefs.APageObjects;
import utils.PropertyHandler;

public class RegistrationPageStepDefs extends APageObjects {

	private static Logger logger = Logger.getLogger(RegistrationPageStepDefs.class);

    @When("^User input correct Registration data with Last Name$")
    public void user_input_correct_registration_data_with_last_name() throws Throwable {
        logger.info("Inputting new registration data");
        
        String firstName = PropertyHandler.testData.getValue("firstName");
        String lastName = PropertyHandler.testData.getValue("lastName");
        String mobileNumber = PropertyHandler.testData.getValue("mobileNumber");
        String email = PropertyHandler.testData.getValue("email");
        String password = PropertyHandler.testData.getValue("password");
        String confirmPassword = PropertyHandler.testData.getValue("confirmPassword");

        registrationPage.inputNewRegistrationData(firstName, lastName, mobileNumber, email, password, confirmPassword);
    }
    
    @When("^User input correct Registration data without Last Name$")
    public void user_input_correct_registration_data_without_last_name() throws Throwable {
        logger.info("Inputting new registration data");
        
        String firstName = PropertyHandler.testData.getValue("firstName");
        String lastName = "";
        String mobileNumber = PropertyHandler.testData.getValue("mobileNumber");
        String email = PropertyHandler.testData.getValue("email");
        String password = PropertyHandler.testData.getValue("password");
        String confirmPassword = PropertyHandler.testData.getValue("confirmPassword");

        registrationPage.inputNewRegistrationData(firstName, lastName, mobileNumber, email, password, confirmPassword);
    }
    
    @And("^User submit the Registration form$")
    public void user_submit_the_registration_form() throws Throwable {
        registrationPage.submitInput();
    }
}