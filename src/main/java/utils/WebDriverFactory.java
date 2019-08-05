package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
	private static WebDriverFactory instance = new WebDriverFactory();
	private static WebDriver driver = newWebDriver();
	
	public static WebDriverFactory getInstance( ) {
		return instance;
	}
	
	public WebDriver getWebDriver( ) {
		return driver;
	}
	
	public void removeDriver( ) {
		driver.quit();
	}
			
	private static WebDriver newWebDriver() {
		System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
