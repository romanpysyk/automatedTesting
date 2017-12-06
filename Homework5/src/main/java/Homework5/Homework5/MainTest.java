package Homework5.Homework5;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MainTest extends BasicsDataMethods {
	
    Pattern pattern = Pattern.compile("\\d+");
	
	String goodName;
	String goodPrice;
	int goodQuantity;
	
	@BeforeTest
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {
    	if(browser.equalsIgnoreCase("firefox")){
    		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
    	}
    	if(browser.equalsIgnoreCase("chrome")){
    		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
    	}
    	if(browser.equalsIgnoreCase("internetexplorer")){
    		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
    		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
    	}
    }
	
	@Test
	public void openShop() {
	driver.get(shopURL);
	Assert.assertEquals(driver.getTitle(), mainPageTitle);
	}
	
	@Test(dependsOnMethods = "openShop")
	public void openAllGoodsPage() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 1200)");
	driver.findElement(allGoodsLink).click();
	Assert.assertEquals(driver.getTitle(), allGoodsTitle);
	}
	
	@Test(dependsOnMethods = "openAllGoodsPage")
	public void getProductName() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)");
	driver.findElement(productNameLink).click();
	js.executeScript("window.scrollBy(0, 400)");
	goodName = driver.findElement(productName).getText();
	}
	
	@Test(dependsOnMethods = "getProductName")
	public void getProductPrice() {
	goodPrice = driver.findElement(productPrice).getText();
	}
	
	@Test(dependsOnMethods = "getProductPrice")
	public void getAllQuantity() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(productDescriprion));
	driver.findElement(productDescriprion).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(generalQuantity));
	String allQuant = driver.findElement(generalQuantity).getText();
	Matcher matcher = pattern.matcher(allQuant);
    int start = 0;
    while (matcher.find(start)) {
       String value = allQuant.substring(matcher.start(), matcher.end());
       goodQuantity = Integer.parseInt(value);
       start = matcher.end();
		}
	}
    
    @Test(dependsOnMethods = "getAllQuantity")
    public void putProductInCart() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(putIntoCart));
	driver.findElement(putIntoCart).click();
    }
    
    
    @Test(dependsOnMethods = "putProductInCart")
    public void verifyOrderedProduct() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(navigateOrderDetailsPage));
	driver.findElement(navigateOrderDetailsPage).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(orderedProductName));
	Assert.assertTrue(goodName.equalsIgnoreCase(driver.findElement(orderedProductName).getText()));
	wait.until(ExpectedConditions.presenceOfElementLocated(orderedProductPrice));
	Assert.assertTrue(goodPrice.equals(driver.findElement(orderedProductPrice).getText()));
	wait.until(ExpectedConditions.presenceOfElementLocated(orderedProductQuantity));
	Assert.assertTrue(driver.findElement(orderedProductQuantity).getText().equals("1 шт."));
	}
    
    @Test(dependsOnMethods = "verifyOrderedProduct")
    public void fillOrderDetails(){
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(processWithOrderButton));
	driver.findElement(processWithOrderButton).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(firstNameField));
	driver.findElement(firstNameField).sendKeys(clientFirstName);
	driver.findElement(lastNameField).sendKeys(clientLastName);
	driver.findElement(emailField).sendKeys(clientEmail);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 1000)");
	driver.findElement(continueButton).click();
	driver.findElement(addressField).sendKeys(clientAddress);
	js.executeScript("window.scrollBy(0, 500)");
	driver.findElement(postCodeField).sendKeys(clientPostCode);
	driver.findElement(cityField).sendKeys(clientCity);
	js.executeScript("window.scrollBy(0, 500)");
	driver.findElement(deliveryOptionsButton).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(confirmDeliveryButton));
	driver.findElement(confirmDeliveryButton).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(paymentOption2));
	driver.findElement(paymentOption2).click();
	js.executeScript("window.scrollBy(0, 300)");
	driver.findElement(termsCheckBox).click();
	driver.findElement(orderProductButton).click();
    }
    
    @Test(dependsOnMethods = "fillOrderDetails")
    public void verifyOrderDetails() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(orderConfirmed));
    Assert.assertTrue(driver.findElement(orderConfirmed).getText().contains(confirmationMessage));
	String orderedGoodName = driver.findElement(orderedItemDetails).getText().toLowerCase();
	Assert.assertTrue(orderedGoodName.contains(goodName.toLowerCase()));
	Assert.assertTrue(driver.findElement(orderedItemPrice).getText().equalsIgnoreCase(goodPrice));
	Assert.assertTrue(driver.findElement(orderedItemCount).getText().equals("1"));
    }
	
	@Test(dependsOnMethods = "verifyOrderDetails")
	public void verifyProductCountReduce() {
	driver.findElement(mainPageItem).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0, 1200)");
	driver.findElement(allGoodsLink).click();
	js.executeScript("window.scrollBy(0, 400)");
	driver.findElement(productNameLink).click();
	js.executeScript("window.scrollBy(0, 400)");
    WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(productDescriprion));
	driver.findElement(productDescriprion).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(generalQuantity));
	String currentCount = driver.findElement(generalQuantity).getText();
	Matcher matcher = pattern.matcher(currentCount);
    int start = 0;
    int countAfterTest = 0;
    while (matcher.find(start)) {
       String value = currentCount.substring(matcher.start(), matcher.end());
       countAfterTest = Integer.parseInt(value);
       start = matcher.end();
		}
    Assert.assertTrue((goodQuantity - 1) == countAfterTest);
	}
	
	@AfterTest
	public void shutDown() {
		driver.quit();
	}
}
