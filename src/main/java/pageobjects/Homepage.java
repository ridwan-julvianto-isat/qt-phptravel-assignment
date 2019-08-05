package pageobjects;

public class Homepage extends ABasePageObjects {
	
	public Homepage() {
		initObjects(this);
	}
	
	public void openHomepage() {
		driver.get("https://www.phptravels.net/");
	}
}
