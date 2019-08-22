package phptravel.stepdefs.commons;

import org.openqa.selenium.WebDriver;

import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.RegistrationPage;
import pageobjects.SearchResultPage;
import utils.WebDriverFactory;

public abstract class APageObjects {
	
	protected static WebDriver driver;

	protected static HomePage homePage;
	protected static RegistrationPage registrationPage;
	protected static MyAccountPage accountPage;
	protected static SearchResultPage searchPage;
	
	public static void init( ) {
		driver = WebDriverFactory.createWebDriver();
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		accountPage = new MyAccountPage(driver);
		searchPage = new SearchResultPage(driver);
	}

	public static void close() {
		driver.close();
		//driver.quit();
	}
	
}
