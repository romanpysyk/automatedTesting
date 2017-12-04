package Homework4.Homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {

	
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterChangeValueOf(WebElement e, WebDriver driver, CharSequence[] value) {
		System.out.println("The value of " + e + " was changed to " + value.toString());
	}

	public void afterClickOn(WebElement e, WebDriver driver) {
		System.out.println("Button " + e + " was clicked");		
	}

	public void afterFindBy(By by, WebElement e, WebDriver driver) {
		System.out.println("Element " + e + " was found by " + by);
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String s, WebDriver driver) {
		System.out.println("The following page was opened " + s);
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement e, WebDriver driver, CharSequence[] arg2) {
		System.out.println("The value of " + e + " is going to be changed");
	}

	public void beforeClickOn(WebElement e, WebDriver driver) {
		System.out.println("The element " + e + " will be clicked now");
	}

	public void beforeFindBy(By by, WebElement e, WebDriver driver) {
		System.out.println("Looking for element " + e + " by " + by);
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String s, WebDriver driver) {
		System.out.println("Going to open following page " + s);
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
