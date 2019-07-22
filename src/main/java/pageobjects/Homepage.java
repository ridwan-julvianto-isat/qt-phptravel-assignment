package pageobjects;

import org.openqa.selenium.support.PageFactory;

public class Homepage extends ABasePageObjects {
	
	public Homepage() {
		initObjects();
		PageFactory.initElements(driver, this);
	}
	
	public void openHomepage() {
		driver.get("https://www.phptravels.net/");
	}
}
