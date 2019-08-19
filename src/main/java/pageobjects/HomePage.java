package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.PropertyHandler;
import utils.WebDriverFactory;

public class HomePage {
	private WebDriver driver;

	final static Logger logger = Logger.getLogger(HomePage.class);
	
    By myAccountDropDown = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]");
    By signUpButton = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]");
    By removeCookiesButton = By.xpath("//button[@id='cookyGotItBtn']");
	
    public HomePage(WebDriver driver) {
    	 this.driver = driver;
    }
    
	public void openHomepage() {
		String web_url = PropertyHandler.testConfig.getValue("phptravel_url");
		logger.info("Homepage URL: " + web_url);
		driver.get(web_url);
		driver.findElement(removeCookiesButton).click();
	}
	
	public void goToRegistrationPage() {
		driver.findElement(myAccountDropDown).click();
		driver.findElement(signUpButton).click();
	}
}
