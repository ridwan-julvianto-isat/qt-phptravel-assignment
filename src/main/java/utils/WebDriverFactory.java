package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ThreadGuard;

public class WebDriverFactory {
	private static long timeoutinseconds = Long.valueOf(PropertyHandler.testConfig.getValue("global_timeout"));

	public static WebDriver createWebDriver() {
		String browser = PropertyHandler.testConfig.getValue("browser");
		WebDriver driver;
		
		switch (browser.toLowerCase()) {
			case "chrome":
				driver = initiateChromeDriver();
				break;
			case "firefox":
				driver = initiateFirefoxDriver();
				break;
			case "ie":
				driver = initiateIEDriver();
				break;
			default:
				driver = initiateChromeDriver();
				break;
		}
		
		return driver;
	}

	private static WebDriver initiateChromeDriver() {

		System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.setBinary(
				"C:\\Users\\ridwan julvianto\\Downloads\\Workspace\\bin\\browsers\\chromium-75.0.3770.90-1_windows32\\chrome.exe");
		options.addArguments("start-maximized");
		options.addArguments("--touch-events=disabled");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-default-apps");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(timeoutinseconds, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver initiateFirefoxDriver() {

		System.setProperty("webdriver.gecko.driver", "src//test//resources//driver//geckodriver-v0.24.0-win32.exe");

		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(
				"C:\\Users\\ridwan julvianto\\Downloads\\Workspace\\bin\\browsers\\Mozilla Firefox56.0.2-x86\\firefox.exe");
		options.addArguments("start-maximized");
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		WebDriver driver = ThreadGuard.protect(new FirefoxDriver(options));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(timeoutinseconds, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver initiateIEDriver() {
		System.setProperty("webdriver.ie.driver", "src//test//resources//driver//IEDriverServer_x64_3.14.0.exe");

		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		options.requireWindowFocus();
		options.enablePersistentHovering();
		options.ignoreZoomSettings();

		WebDriver driver = new InternetExplorerDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeoutinseconds, TimeUnit.SECONDS);
		return driver;
	}
}
