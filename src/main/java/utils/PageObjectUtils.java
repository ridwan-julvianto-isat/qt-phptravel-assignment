package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectUtils {
	public static String getXPath(WebElement element) {
        String eleToStr = element.toString();
        String getXPathString;

        String d = eleToStr.substring(eleToStr.lastIndexOf("->") + 3);
        String e = d.substring(d.indexOf(":") + 2);
        getXPathString = e.substring(0, e.length() - 1);
        
        return  getXPathString;
	}
	
	public static void javascriptExecutor(WebDriver driver, String script, WebElement element) {
		JavascriptExecutor exec = (JavascriptExecutor) driver;
		exec.executeScript(script, element);
	}
	
	public static void javascriptExecutor(WebDriver driver, String script) {
		javascriptExecutor(driver, script, null);
	}
	
	public static class commonJavaScript {
		public static final String scrollToBottomPage = "window.scrollTo(0, document.body.scrollHeight)";
		public static final String scrollToSomeElement = "arguments[0].scrollIntoView();";
	}
}
	
