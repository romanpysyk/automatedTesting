package Lecture2.Lecture2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2TestsPart2 {
	public static void main (String [] args) throws InterruptedException {
		String [] menuXpathes = new String [13];
		menuXpathes[0] = "//span[contains(text(), 'Dashboard')]";
		menuXpathes[1] = "//*[@data-submenu='3']";
		menuXpathes[2] = "//*[@data-submenu='9']";
		menuXpathes[3] = "//*[@data-submenu='23']";
		menuXpathes[4] = "//*[@data-submenu='27']";
		menuXpathes[5] = "//*[@data-submenu='31']";
		menuXpathes[6] = "//*[@data-submenu='42']";
		menuXpathes[7] = "//*[@data-submenu='46']";
		menuXpathes[8] = "//*[@data-submenu='52']";
		menuXpathes[9] = "//*[@data-submenu='55']";
		menuXpathes[10] = "//*[@data-submenu='58']";
		menuXpathes[11] = "//*[@data-submenu='73']";
		menuXpathes[12] = "//*[@data-submenu='95']";
		
		WebDriver chrome = driverInitialization();
		chrome.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
		WebElement emailField = chrome.findElement(By.id("email"));
		emailField.sendKeys("webinar.test@gmail.com");
		WebElement password = chrome.findElement(By.id("passwd"));
		password.sendKeys("Xcg7299bnSmMuRLp9ITw");
		password.submit();
		Thread.sleep(3000);
		
		for(int i = 0; i<menuXpathes.length; i++){
			chrome.findElement(By.xpath(menuXpathes[i])).click();
			String dashTitle = chrome.getTitle();
			System.out.println(dashTitle);
			chrome.navigate().refresh();
			if(chrome.getTitle().contentEquals(dashTitle)){
				Thread.sleep(3000);
			} else {
				System.out.println("error");
		}
	}
		chrome.quit();
}
	public static WebDriver driverInitialization() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		return new ChromeDriver();
		
}
}
