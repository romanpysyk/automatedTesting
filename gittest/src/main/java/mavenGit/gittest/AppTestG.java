package mavenGit.gittest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTestG 
{
    protected WebDriver chrome;
    
    @Test
    public void gitPush() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "C:/Users/SeleniumDrivers/chromedriver.exe");
    	
    	chrome = new ChromeDriver();
    	String eTitle = "Meet Guru99 - Free Training Tutorials & Video for IT Courses";
    	String aTitle = "";
    	chrome.get("http://www.guru99.com/");
    	chrome.manage().window().maximize();
    	aTitle = chrome.getTitle();
    	
    	if(aTitle.contentEquals(eTitle)){
    		System.out.println("TEST PASSED ! ! !");
    	} else {
    		System.out.println("TEST FAILED :( ");
    	}
    	chrome.close();
    }
}
