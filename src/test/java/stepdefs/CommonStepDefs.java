package stepdefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverFactory;

public class CommonStepDefs {
	WebDriver driver;
	Homepage hp;
	
	@Given("^Chrome web browser started$")
    public void chrome_web_browser_started() throws Throwable {
		driver = WebDriverFactory.getInstance().getWebDriver();
    }
	
	@And("^PHP Travel homepage is displayed$")
    public void chrome_web_browser_started() throws Throwable {
		hp = new Homepage(driver);
    }

}
