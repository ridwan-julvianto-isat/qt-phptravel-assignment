package pageobjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import utils.PageObjectsHelper;
import utils.PropertyHandler;
import utils.WebDriverFactory;

public class MyAccountPage {

	private WebDriver driver;
	private static Logger logger = Logger.getLogger(MyAccountPage.class);


	@FindBy(xpath = "//h3[@class='RTL']")
    private WebElement myAccountHeaderText;

	public MyAccountPage(WebDriver driver) {
   	 	this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyAccountPageOpens() {
		Wait<WebDriver> wait = PageObjectsHelper.getFluentWait(driver);
        wait.until(ExpectedConditions.visibilityOf(myAccountHeaderText));
        //verify it is Account page
        Assert.assertEquals("https://www.phptravels.net/account/", driver.getCurrentUrl());
	}

	public void verifyGreeting(String firstName, String lastName) {
        String greeting = "Hi, " + firstName + " " + lastName;
        Assert.assertEquals(greeting, myAccountHeaderText.getText());
	}
}
