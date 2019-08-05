package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverFactory;

public abstract class ABasePageObjects {
	protected WebDriver driver;
    
    protected WebDriver getDriver() {
        return WebDriverFactory.getInstance().getWebDriver();
    }
	
    protected void initObjects(Object childObject) {
    	this.driver = getDriver();
		PageFactory.initElements(driver, childObject);
	}
}
