package Homework4.Homework4;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.log4j.Logger;


public class MainTest extends BaseElementsAndMethods {

    WebDriver driver;
    String nameSend = randomGood();
    String quantitySend = randomValue();
    String priceSend = randomValue();
    Logger log = Logger.getLogger("devpinoyLogger");
   
    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
    	if(browser.equalsIgnoreCase("firefox")){
    		System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
    		driver = new FirefoxDriver();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
    	if(browser.equalsIgnoreCase("chrome")){
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
    	if(browser.equalsIgnoreCase("internetexplorer")){
    		System.setProperty("webdriver.ie.driver", "src/resources/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
    	}
    	log.debug("configuring paralel execution on three browsers");
    }

    @Test(dataProvider = "authorization")
    public void logIn(String email, String password) {
            driver.get(adminURL);
            driver.findElement(emailFied).sendKeys(email);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(signinButton).click();
            Assert.assertTrue(driver.findElement(logo).isDisplayed());
            log.debug("logging into application using data provider");
    }

    @Test(dependsOnMethods = "logIn")
    public void openGoodsPage() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement catalogItem = driver.findElement(By.xpath("//*[@data-submenu='9']"));
	WebElement goodItem = driver.findElement(By.xpath("//*[@data-submenu='10']"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(catalog));
    Actions action = new Actions(driver);
    action.moveToElement(catalogItem).perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(goods));
    action.click(goodItem).perform();
    Assert.assertEquals(driver.getTitle(), goodsExpectedTitle);
    log.debug("opening all goods page");
    }
    
    @Test(dependsOnMethods = "openGoodsPage")
    public void activateNewGood() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(newGoodButton));
    driver.findElement(newGoodButton).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(goodNameField));
    driver.findElement(goodNameField).sendKeys(nameSend);
    driver.findElement(quantityField).clear();
    driver.findElement(quantityField).sendKeys(quantitySend);
    driver.findElement(priceField).clear();
    driver.findElement(priceField).sendKeys(priceSend);
    driver.findElement(switcher).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(popUpWindow));
    String actualPopupMsg = driver.findElement(popUpWindow).getText();
    driver.findElement(closePopup).click();
    Assert.assertEquals(actualPopupMsg, exppopupMsg);
    log.debug("entereng data for new good and enabling it");
    }
    
    @Test(dependsOnMethods = "activateNewGood")
    public void saveGood() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.findElement(saveButton).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(popUpWindow));
    String actualPopupMsg = driver.findElement(popUpWindow).getText();
    wait.until(ExpectedConditions.visibilityOfElementLocated(closePopup));
    driver.findElement(closePopup).click();
    Assert.assertEquals(actualPopupMsg, exppopupMsg);
    log.debug("saving new good");
    }
    
    @Test(dependsOnMethods = "saveGood")
    public void openShop() {
    	driver.get(shopURL);
    	JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 800)");
    	driver.findElement(allGoodsItem).click();
    	Assert.assertTrue(driver.findElement(By.linkText(nameSend)).isDisplayed());
    	log.debug("opening shop page and looking for created good");
    }
    
    @Test(dependsOnMethods = "openShop")
    public void checkGood() {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 400)");
    	driver.findElement(By.linkText(nameSend)).click();
    	Assert.assertEquals(driver.findElement(createdGoodName).getText(), nameSend.toUpperCase());
    	Assert.assertEquals(driver.findElement(createdGoodPrice).getText(), (priceSend+",00" + " ₴"));
    	js.executeScript("window.scrollBy(0, 200)");
    	Assert.assertEquals(driver.findElement(createdGoodQuantity).getText(), (quantitySend+" Товары"));
    	driver.quit();
    	log.debug("checking good found against parameters of good created");
    }
}
