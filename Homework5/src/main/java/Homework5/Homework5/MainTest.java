package Homework5.Homework5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
		public static void main (String [] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0, 1200)");
	driver.findElement(By.xpath("//*[@id='content']/section/a")).click();
	js.executeScript("window.scrollBy(0, 400)");
	driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
	js.executeScript("window.scrollBy(0, 400)");
	String nameOf = driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/h1")).getText();
	String price = driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/div[1]/div[1]/div/span")).getText();
	driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/div[2]/div[3]/ul/li[2]/a")).click();
	Thread.sleep(3000);
	String allQuant = driver.findElement(By.xpath("//*[@id='product-details']/div[3]/span")).getText();
	System.out.println(allQuant);
	driver.findElement(By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div[1]/div[2]/button")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/a")).click();
	Thread.sleep(5000);

	if(nameOf.equalsIgnoreCase(driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div[1]/div[2]/ul/li/div/div[2]/div[1]/a")).getText())){
		System.out.println(nameOf);
	} else {System.out.println("error");}
	Thread.sleep(5000);
	if(price.equals(driver.findElement(By.xpath("//*[@id='main']/div/div[1]/div[1]/div[2]/ul/li/div/div[2]/div[2]/span")).getText())){
		System.out.println(price);
	} else {driver.quit();}
	Thread.sleep(5000);
	if(driver.findElement(By.xpath("//*[@id='cart-subtotal-products']/span[1]")).getText().equals("1 шт.")){
		System.out.println(driver.findElement(By.xpath("//*[@id='cart-subtotal-products']/span[1]")).getText());
	} else {driver.quit();}
	
	driver.findElement(By.xpath("//*[@id='main']/div/div[2]/div/div[2]/div/a")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("firstname")).sendKeys("Roman");
	driver.findElement(By.name("lastname")).sendKeys("Testuser");
	driver.findElement(By.name("email")).sendKeys("romantestqa29@gmail.com");
	js.executeScript("window.scrollBy(0, 1000)");

	driver.findElement(By.name("continue")).click();
	driver.findElement(By.name("address1")).sendKeys("Main Road 77/75");
	js.executeScript("window.scrollBy(0, 500)");
	driver.findElement(By.name("postcode")).sendKeys("33375");
	driver.findElement(By.name("city")).sendKeys("Melburn");
	js.executeScript("window.scrollBy(0, 500)");
	driver.findElement(By.name("confirm-addresses")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.name("confirmDeliveryOption")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='payment-option-2-container']/label/span")).click();
	js.executeScript("window.scrollBy(0, 300)");
	driver.findElement(By.name("conditions_to_approve[terms-and-conditions]")).click();
	driver.findElement(By.xpath("//*[@id='payment-confirmation']/div[1]/button")).click();
	Thread.sleep(5000);
	
	Thread.sleep(3000);
	String confirm = driver.findElement(By.xpath("//*[@id='content-hook_order_confirmation']/div/div/div/h3")).getText();
	System.out.println(driver.findElement(By.xpath("//*[@id='content-hook_order_confirmation']/div/div/div/h3")).isDisplayed());
	System.out.println(confirm);
	
	String orderName = driver.findElement(By.xpath("//*[@id='order-items']/div/div/div[2]/span")).getText().toLowerCase();
	System.out.println(orderName.contains(nameOf.toLowerCase()));
	System.out.println(nameOf);
	System.out.println(orderName);
	
	String orderPrice = driver.findElement(By.xpath("//*[@id='order-items']/div/div/div[3]/div/div[1]")).getText();
	System.out.println("prices + " + orderPrice.equalsIgnoreCase(price));
	
	String orderedQuant = driver.findElement(By.xpath("//*[@id='order-items']/div/div/div[3]/div/div[2]")).getText();
	System.out.println("kilsist +" + orderedQuant.equals("1"));
	
	driver.findElement(By.xpath("//*[@id='_desktop_logo']/a/img")).click();
    js.executeScript("window.scrollBy(0, 1200)");
	driver.findElement(By.xpath("//*[@id='content']/section/a")).click();
	js.executeScript("window.scrollBy(0, 400)");
	driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();

}
}
