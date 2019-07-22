package pageobjects;

import org.openqa.selenium.WebDriver;

import utils.WebDriverFactory;

public abstract class ABasePageObjects {
	protected WebDriver driver;
    
    protected WebDriver getDriver() {
        return WebDriverFactory.getInstance().getWebDriver();
    }
	
    protected void initObjects() {
    	this.driver = getDriver();
	}
}
