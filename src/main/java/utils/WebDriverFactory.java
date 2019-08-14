package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverFactory {
	private static WebDriverFactory instance = new WebDriverFactory();
	private WebDriver driver;
	
	public static WebDriverFactory getInstance( ) {
		return instance;
	}
	
    public void createWebDriver() {
    	String browser = "chrome"; //TODO: should take this value from property file
    	switch (browser) {
		case "chrome":
			driver = initiateChromeDriver();
			break;
		default:
			driver = initiateChromeDriver();
			break;
		}
    }
    
    public WebDriver getWebDriver() {
    	return driver;
    }
    
    public void removeWebDriver() {
    	driver.quit();
    }
    
	private static WebDriver initiateChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver.exe");
		
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\ridwan julvianto\\Downloads\\Workspace\\bin\\browsers\\chromium-75.0.3770.90-1_windows32\\chrome.exe");
        options.addArguments("start-maximized");
        options.addArguments("--touch-events=disabled");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-default-apps");
        options.setExperimentalOption("useAutomationExtension", false);
        
		
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 
        
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
