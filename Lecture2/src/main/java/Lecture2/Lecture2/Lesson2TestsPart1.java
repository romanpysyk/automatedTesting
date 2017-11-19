package Lecture2.Lecture2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2TestsPart1 {
	public static void main (String [] args) throws InterruptedException {
		WebDriver chrome = driverInitialization();
		chrome.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
		WebElement emailField = chrome.findElement(By.id("email"));
		emailField.sendKeys("webinar.test@gmail.com");
		WebElement password = chrome.findElement(By.id("passwd"));
		password.sendKeys("Xcg7299bnSmMuRLp9ITw");
		password.submit();
		Thread.sleep(5000);
		chrome.findElement(By.xpath("//img[@class='imgm img-thumbnail']")).click();
		chrome.findElement(By.id("header_logout")).click();
		 
	}
	
	public static WebDriver driverInitialization() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		return new ChromeDriver();
	}

}
