package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertyHandler;

public class HomePage {
	private WebDriver driver;

	final static Logger logger = Logger.getLogger(HomePage.class);
	
    By myAccountDropDown = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]");
    By signUpButton = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]");
    By removeCookiesButton = By.xpath("//button[@id='cookyGotItBtn']");
	
    By searchSubmitButton = By.xpath("//button[@class='btn-primary btn btn-lg btn-block pfb0']");
    By flightSearchTabs = By.xpath("//a[@title='Flights' and @data-toggle='tab']");
    
    By embarkationTextBox = By.xpath("//div[@id='select2-drop']//input[@class='select2-input']");
    By destinationTextBox = By.xpath("//div[@id='select2-drop']//input[@class='select2-input']");
    By departureDateCalendarInput = By.xpath("//div[@id='select2-drop']//input[@class='select2-input']");
    By arriveDateCalendarInput = By.xpath("//div[@id='select2-drop']//input[@class='select2-input']");
    By noOfAdultInput = By.xpath("//div[@id='select2-drop']//input[@class='select2-input']");
    By noOfChildInput = By.xpath("//div[@id='select2-drop']//input[@class='select2-input']");
    By noOfInfantInput = By.xpath("//div[@id='select2-drop']//input[@class='select2-input']");
    
    public HomePage(WebDriver driver) {
    	 this.driver = driver;
    }
    
	public void openHomepage() {
		String web_url = PropertyHandler.testConfig.getValue("phptravel_url");
		logger.info("Homepage URL: " + web_url);
		driver.get(web_url);
	}
	
	public void goToRegistrationPage() {
		driver.findElement(myAccountDropDown).click();
		driver.findElement(signUpButton).click();
	}

	public void selectFlight(String direction, String embark, String dest, String depDate, String arriveDate,
			String adults, String childs, String infants) {
		// TODO Auto-generated method stub
		
	}

	public void initSearch() {
		driver.findElement(searchSubmitButton).click();
	}

	public void openFlightSearchTab() {
		driver.findElement(flightSearchTabs).click();
	}
}
