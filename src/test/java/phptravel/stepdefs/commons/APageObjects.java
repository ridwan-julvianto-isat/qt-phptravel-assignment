package phptravel.stepdefs.commons;

import org.openqa.selenium.WebDriver;

import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.RegistrationPage;
import pageobjects.SearchResultPage;
import utils.WebDriverFactory;

public abstract class APageObjects {
	
	protected static WebDriver driver;

	protected HomePage homePage;
	protected RegistrationPage registrationPage;
	protected MyAccountPage accountPage;
	protected SearchResultPage searchPage;
	
	public static void init( ) {
		driver = WebDriverFactory.createWebDriver();
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		accountPage = new MyAccountPage(driver);
		searchPage = new SearchResultPage(driver);
	}

	public static void close() {
		driver.close();
		driver.quit();
	}
	
}
