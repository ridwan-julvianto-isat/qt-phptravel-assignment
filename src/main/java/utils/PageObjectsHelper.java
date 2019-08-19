package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PageObjectsHelper {

	public static Wait<WebDriver> getFluentWait(WebDriver driver) {
		Duration fluentTimeout = Duration.ofSeconds(Long.valueOf(PropertyHandler.testConfig.getValue("fluent_wait_timeout")));
		Duration fluentPolling = Duration.ofSeconds(Long.valueOf(PropertyHandler.testConfig.getValue("fluent_wait_retry")));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(fluentTimeout)
			    .pollingEvery(fluentPolling)
			    .ignoring(NoSuchElementException.class);
		
		return wait;
	}
}
