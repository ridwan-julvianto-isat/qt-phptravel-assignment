package pageobjects;

import java.util.Currency;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;
import utils.PageObjectUtils;

public class SearchResultPage {
	private WebDriver driver;

	private static Logger logger = Logger.getLogger(SearchResultPage.class);

	@FindBy(xpath = "//div[@class='flights_list container']")
    private WebElement flightsSearchResultContainer;
	
	By airlinesFilterLocator = By.xpath("//div[@id='collapse4']/div/label");
	
	String flightScheduleDetailsLocator = "//div[@id='all_flights']/div";
	//By airlineInFlightScheduleLocator = By.xpath("/div[@class='airline-detail']");

	String searchPageURL = "https://www.phptravels.net/thflights/search";
	
	public SearchResultPage(WebDriver driver) {
   	 	this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifySearchPageOpens() {
		logger.info("Waiting and verifying Search Page is opened.");
		
		WaitUtils.waitForVisibilityOf(driver, flightsSearchResultContainer);
		
        //verify it is Search page
        Assert.assertTrue(driver.getCurrentUrl().contains(searchPageURL));
	}

	public void verifyListOfAirlines() {
		logger.info("Verifying that list of airlines is shown in the page (for filtering).");
		List<WebElement> airlinesFilter = driver.findElements(airlinesFilterLocator);
		Assert.assertTrue(airlinesFilter.size() > 0);
	}

	public void verifyListOfFlightSchedule() {
		logger.info("Verifying at least one flight schedule is shown in the page.");
		
		List<WebElement> allFlights = driver.findElements(By.xpath(flightScheduleDetailsLocator));
		logger.info("   flight schedules: " + allFlights.size());
		
		Assert.assertTrue(allFlights.size() > 0);
	}

	public void verifyBookNowButtons() {
		logger.info("Verifying that each flight schedule have Book Now button.");
		
		List<WebElement> allFlights = driver.findElements(By.xpath(flightScheduleDetailsLocator));

		for(int i = 1; i < allFlights.size(); i++) {
			try {
				WebElement bookNow = driver.findElement(By.xpath(flightScheduleDetailsLocator + "[" + i + "]/div/div/form/div/button[@class='btn btn-primary btn-block ladda-button spin click']"));
				
				PageObjectUtils.javascriptExecutor(driver, PageObjectUtils.commonJavaScript.scrollToSomeElement, bookNow);
				
			} catch (Exception e) {
				Assert.fail("Book Now element is not found in flight schedule #" + i);
			}
		 }
	}

	public void verifyListPrices() {
		logger.info("Verifying that each flight schedule have Price and it is not zero.");
		
		PageObjectUtils.javascriptExecutor(driver, PageObjectUtils.commonJavaScript.scrollToBottomPage);

		List<WebElement> allFlights = driver.findElements(By.xpath(flightScheduleDetailsLocator));
		
		for(int i = 1; i < allFlights.size(); i++) {
			WebElement priceAmount = driver.findElement(By.xpath(flightScheduleDetailsLocator + "[" + i + "]/div/div[@class='col-md-2 text-center flight-time']/div/h4"));

			PageObjectUtils.javascriptExecutor(driver, PageObjectUtils.commonJavaScript.scrollToSomeElement, priceAmount);
			
			logger.info("    priceAmount:" + priceAmount.getText() + " - " + priceAmount);
			 
			if(priceAmount.getText().strip() != "") {
				double price = Double.valueOf(priceAmount.getText().replace(",", ""));
				Assert.assertTrue(price > 0); //price > 0
			} 
			else {
				Assert.fail("Price is not found in flight schedule #" + i);
			}
		}
	}
	
}
