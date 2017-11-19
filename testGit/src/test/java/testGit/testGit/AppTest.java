package testGit.testGit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
	
	protected WebDriver chrome;
	
	@Test
	public void githubTest() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/SeleniumDrivers/chromedriver.exe");
		
		chrome = new ChromeDriver();
		
		String eTitle = "Meet Guru99 - Free Training Tutorials & Videos for IT Courses";
		String aTitle = "";
		chrome.get("http://www.guru99.com/");
		chrome.manage().window().maximize();
		
		aTitle = chrome.getTitle();
		Assert.assertTrue(aTitle.contentEquals(eTitle));
		
		chrome.close();
	}
	
	
}
