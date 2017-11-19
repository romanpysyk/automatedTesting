package Lecture2.Lecture2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2TestsPart2 {
	public static void main (String [] args) throws InterruptedException {
		WebDriver chrome = driverInitialization();
		chrome.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
		WebElement emailField = chrome.findElement(By.id("email"));
		emailField.sendKeys("webinar.test@gmail.com");
		WebElement password = chrome.findElement(By.id("passwd"));
		password.sendKeys("Xcg7299bnSmMuRLp9ITw");
		password.submit();
		Thread.sleep(5000);
		
		chrome.findElement(By.xpath("//span[contains(text(), 'Dashboard')]")).click();
		String dashTitle = chrome.getTitle();
		System.out.println(dashTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(dashTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("error");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='3']")).click();
		String ordersTitle = chrome.getTitle();
		System.out.println(ordersTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(ordersTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='9']")).click();
		String katalogTitle = chrome.getTitle();
		System.out.println(katalogTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(katalogTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='23']")).click();
		String clientsPage = chrome.getTitle();
		System.out.println(clientsPage);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(clientsPage)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='27']")).click();
		String supportTitle = chrome.getTitle();
		System.out.println(supportTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(supportTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='31']")).click();
		String statisticsTitle = chrome.getTitle();
		System.out.println(statisticsTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(statisticsTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='42']")).click();
		String modulesTitle = chrome.getTitle();
		System.out.println(modulesTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(modulesTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='46']")).click();
		String designTitle = chrome.getTitle();
		System.out.println(designTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(designTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='52']")).click();
		String deliveryTitle = chrome.getTitle();
		System.out.println(deliveryTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(deliveryTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='55']")).click();
		String payTitle = chrome.getTitle();
		System.out.println(payTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(payTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='58']")).click();
		String internationalTitle = chrome.getTitle();
		System.out.println(internationalTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(internationalTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='73']")).click();
		String parametersTitle = chrome.getTitle();
		System.out.println(parametersTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(parametersTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		chrome.findElement(By.xpath("//*[@data-submenu='95']")).click();
		String configTitle = chrome.getTitle();
		System.out.println(configTitle);
		chrome.navigate().refresh();
		if(chrome.getTitle().contentEquals(configTitle)){
			Thread.sleep(5000);
		} else {
			System.out.println("Titles mismatch");
		}
		
		chrome.quit();

}
	
	public static WebDriver driverInitialization() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		return new ChromeDriver();
}
}
