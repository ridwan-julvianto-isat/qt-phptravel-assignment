package phptravel.stepdefs;

import org.openqa.selenium.WebDriver;

import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.RegistrationPage;
import utils.WebDriverFactory;

public class PageObjects {

	protected static HomePage homePage;
	protected static RegistrationPage registrationPage;
	protected static MyAccountPage accountPage;
	protected static WebDriver driver;
	
	public static void init( ) {
		driver = WebDriverFactory.createWebDriver();
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		accountPage = new MyAccountPage(driver);
	}

	public static void close() {
		driver.close();
		//driver.quit();
	}
	
}
