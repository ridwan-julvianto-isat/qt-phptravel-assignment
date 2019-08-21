package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	private WebDriver driver;

	private static Logger logger = Logger.getLogger(SearchResultPage.class);

	@FindBy(xpath = "//div[@class='go-text-right panel-heading']")
    private WebElement registrationSection;
	
	private WebElement removeCookiesButton;
	
	public SearchResultPage(WebDriver driver) {
   	 	this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifySearchPageOpens() {
		// TODO Auto-generated method stub
		
	}

	public void verifyListOfAirlines() {
		// TODO Auto-generated method stub
		
	}

	public void verifyListOfFlightSchedule() {
		// TODO Auto-generated method stub
		
	}

	public void verifyBookNowButtons() {
		// TODO Auto-generated method stub
		
	}

	public void verifyListPrices() {
		// TODO Auto-generated method stub
		
	}
	
}
