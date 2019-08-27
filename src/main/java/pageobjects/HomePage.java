package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageobjects.commons.CommonObjects.FLIGHT_TRIP;
import utils.WaitUtils;
import utils.PropertyHandler;

public class HomePage {
	private WebDriver driver;

	final static Logger logger = Logger.getLogger(HomePage.class);
	
    By myAccountDropDownLocator = By.xpath("//nav[contains(@class, 'navbar')]//li[@id='li_myaccount']/a"); 
    By signUpButtonLocator = By.xpath("//nav[contains(@class, 'navbar')]//a[contains(@href, 'register')]"); 
    By removeCookiesButtonLocator = By.xpath("//button[@id='cookyGotItBtn']");
	
    By searchSubmitButtonLocator = By.xpath("//div[@id='thflight']//div[contains(@class, 'search-button')]/button"); // //button[@class='btn-primary btn btn-lg btn-block pfb0']");
    By flightSearchTabsLocator = By.xpath("//a[@title='Flights' and @data-toggle='tab']");
    
    //Flight Search
    By oneWayTripRadioButtonLocator = By.xpath("//input[@id='oneway']/ancestor::div[@class='iradio_square-grey']"); //By.xpath("//input[@id='oneway']");
    By roundTripRadioButtonLocator = By.xpath("//input[@id='round']/ancestor::div[@class='iradio_square-grey']");
  
    By originInputLocator = By.xpath("//*[@id='s2id_origin']/a/span[@class='select2-chosen']");
    By destinationInputLocator = By.xpath("//*[@id='s2id_destination']/a/span[@class='select2-chosen']");
    
    By locationDropDownLocator = By.xpath("//*[@id='select2-drop']/ul/li");
    By locationFirstOptionLocator = By.xpath("//*[@id='select2-drop']/ul/li[1]/div");
    By origindestinationTextBoxLocator = By.xpath("//*[@id='select2-drop']/div/input");
    
    By departureDateTextBoxLocator= By.xpath("//input[@id='departure']");
    By returnDateTextBoxLocator= By.xpath("//input[@id='arrival']");
    
    By noOfAdultInputLocator = By.xpath("//select[@id='madult']");
    By noOfChildInputLocator = By.xpath("//select[@id='mchildren']");
    By noOfInfantInputLocator = By.xpath("//select[@id='minfant']");
    By openPassengerButtonLocator = By.xpath("//div[@class='col-md-1 form-group go-right col-xs-12']//input[@placeholder='0']");
    By closePassengerButtonLocator = By.xpath("//button[@id='sumManualPassenger']");
    By passengerFormLocator = By.xpath("//div[@id='manual_flightTravelers']");
        
    public HomePage(WebDriver driver) {
    	 this.driver = driver;
    }
    
	public void openHomepage() {
		String web_url = PropertyHandler.testConfig.getValue("phptravel_url");
		logger.info("Homepage URL: " + web_url);
		driver.get(web_url);
	}
	
	public void goToRegistrationPage() {
		driver.findElement(myAccountDropDownLocator).click();
		driver.findElement(signUpButtonLocator).click();;
	}

	public void selectFlight(FLIGHT_TRIP direction, String embark, String dest, String depDate, String arriveDate,
			String adults, String childs, String infants) {
		logger.info("Inputting search data.");				
		
		//PageObjectsHelper.waitForAccessOf(driver, driver.findElement(originInputLocator));

		logger.info("   : Origin");
		driver.findElement(originInputLocator).click();
		WaitUtils.waitForAccessOf(driver, driver.findElement(origindestinationTextBoxLocator));
		driver.findElement(origindestinationTextBoxLocator).sendKeys(embark);
		WaitUtils.waitForVisibilityOf(driver, driver.findElement(locationDropDownLocator));
		Assert.assertTrue(driver.findElements(locationDropDownLocator).size() > 0);
		driver.findElement(locationFirstOptionLocator).click();
		//driver.findElement(locationFirstOptionLocator).sendKeys(Keys.ENTER);
		
		logger.info("   : Destination");		
		driver.findElement(destinationInputLocator).click();
	    WaitUtils.waitForAccessOf(driver, driver.findElement(origindestinationTextBoxLocator));
		driver.findElement(origindestinationTextBoxLocator).sendKeys(dest);		
		WaitUtils.waitForVisibilityOf(driver, driver.findElement(locationDropDownLocator));
		Assert.assertTrue(driver.findElements(locationDropDownLocator).size() > 0);
		driver.findElement(locationFirstOptionLocator).click();
		//driver.findElement(origindestinationTextBoxLocator).sendKeys(Keys.ENTER);
		
		logger.info("   : Departure Date -- " + driver.findElement(departureDateTextBoxLocator).getAttribute("value"));
		driver.findElement(departureDateTextBoxLocator).click();
		driver.findElement(departureDateTextBoxLocator).clear();
		driver.findElement(departureDateTextBoxLocator).sendKeys(depDate);

		if(direction == FLIGHT_TRIP.ROUND_TRIP) {
			driver.findElement(roundTripRadioButtonLocator).click();
			
    		logger.info("   : Round Trip, Return Date");
			driver.findElement(returnDateTextBoxLocator).click();
			driver.findElement(returnDateTextBoxLocator).clear();
			driver.findElement(returnDateTextBoxLocator).sendKeys(arriveDate);
		}
		else {
    		logger.info("   : One Way Trip");		
			driver.findElement(oneWayTripRadioButtonLocator).click();
		}

		logger.info("   : Passenger");		
		driver.findElement(openPassengerButtonLocator).click();
		driver.findElement(noOfAdultInputLocator).sendKeys(adults);
		driver.findElement(noOfChildInputLocator).sendKeys(childs);
		driver.findElement(noOfInfantInputLocator).sendKeys(infants);
		driver.findElement(closePassengerButtonLocator).click();		
		
		WaitUtils.waitForInvisibilityOf(driver, driver.findElement(passengerFormLocator));
	}

	public void initSearch() {
		logger.info("Submit the search");
		driver.findElement(searchSubmitButtonLocator).click();
	}

	public void openFlightSearchTab() {
		logger.info("Selecting flight tab.");
		WebElement FlightSearchTab = driver.findElement(flightSearchTabsLocator);
		
		WaitUtils.waitForAccessOf(driver, FlightSearchTab);
		FlightSearchTab.click();

		WebElement removeCookiesButton = driver.findElement(removeCookiesButtonLocator);
        WaitUtils.waitForVisibilityOf(driver, removeCookiesButton);
		if(removeCookiesButton.isEnabled()) removeCookiesButton.click();
	}
}
