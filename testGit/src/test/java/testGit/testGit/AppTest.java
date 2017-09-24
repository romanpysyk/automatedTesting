package testGit.testGit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {
	
	protected WebDriver chrome;
	
	@Test
	public void githubTest() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/SeleniumDrivers/chromedriver.exe");
		
		chrome = new ChromeDriver();
		
		String eTitle = "Meet Guru99";
		String aTitle = "";
		chrome.get("http://www.guru99.com/");
		chrome.manage().window().maximize();
		
		aTitle = chrome.getTitle();
		if(aTitle.contentEquals(eTitle)){
			System.out.println("Succsess. Test passed!");
		} else
		{
			System.out.println("Loh! Test Failed");
		}
		chrome.close();
	}
}
