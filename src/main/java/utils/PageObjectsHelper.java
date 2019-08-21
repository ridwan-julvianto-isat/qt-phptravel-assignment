package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class PageObjectsHelper {

	private static Wait<WebDriver> getFluentWait(WebDriver driver) {
		Duration fluentTimeout = Duration.ofSeconds(Long.valueOf(PropertyHandler.testConfig.getValue("fluent_wait_timeout")));
		Duration fluentPolling = Duration.ofSeconds(Long.valueOf(PropertyHandler.testConfig.getValue("fluent_wait_retry")));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(fluentTimeout)
			    .pollingEvery(fluentPolling)
			    .ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		
		return wait;
	}
	
	public static void waitForVisibilityOf(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> wait = PageObjectsHelper.getFluentWait(driver);
	        wait.until(ExpectedConditions.visibilityOf(element));	
		} catch (Exception e) {
			Assert.fail("Invalid Test scenario. Element " + element.getTagName() + " is not found.");
		}		
	}
}
