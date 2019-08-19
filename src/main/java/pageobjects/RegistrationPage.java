package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import org.junit.Assert;

import utils.PageObjectsHelper;
import utils.WebDriverFactory;

public class RegistrationPage {
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='go-text-right panel-heading']")
    private WebElement registrationSection;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameInputBox;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameInputBox;
	
	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
    private WebElement mobileNumberInputBox;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailInputBox;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInputBox;
	
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
    private WebElement confirmPasswordInputBox;
	
	@FindBy(xpath = "//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")
    private WebElement submitButton;
	
	
	public RegistrationPage(WebDriver driver) {
   	 	this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyRegistrationPageOpens() {
		Wait<WebDriver> wait = PageObjectsHelper.getFluentWait(driver);
        wait.until(ExpectedConditions.visibilityOf(registrationSection));
        //verify it is registration page
        Assert.assertEquals("https://www.phptravels.net/register", driver.getCurrentUrl());
        Assert.assertEquals("SIGN UP", registrationSection.getText());
	}
	
	public void inputNewRegistrationData(String firstName, String lastName, String mobileNumber, String email, String password, String confirmPassword) {
		firstNameInputBox.sendKeys(firstName);
		if(lastName != "") lastNameInputBox.sendKeys(lastName);
		mobileNumberInputBox.sendKeys(mobileNumber);
		emailInputBox.sendKeys(email);
		passwordInputBox.sendKeys(password);	
		confirmPasswordInputBox.sendKeys(confirmPassword);
	}

	public void submitInput() {
		submitButton.click();
	}
	

	 
}


