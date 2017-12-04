package Homework4.Homework4;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider; 

public class BaseElementsAndMethods {
	
	@DataProvider(name = "authorization")
	protected static Object [] [] credentials() {
		return new Object[][] {{"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}};
	}
	
	
	
	protected String adminURL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
	protected String shopURL = "http://prestashop-automation.qatestlab.com.ua/";
	protected String goodsExpectedTitle = "товары • prestashop-automation";
	protected String exppopupMsg = "Настройки обновлены.";
	protected String[] goodNames = {"iPhoneRP", "iWatchRP", "iPadRP", "iTVRP", "CompRP", 
			"MP3PlayerRP", "HeadphonesRP", "MouseRP", "RouterRP", "Microwave Oven RP",
			"BateryRP", "CarRp", "GuitarRp", "VideocardRP", "SkiShoesRP",
			"Smart CaseRP", "BookRP", "MixerRp", "DVD PlayerRP", "KitchenStuff RP",
			"PrinterRP", "ToyRP", "GameRP", "BrelokRP", "ClockRP",
			"GoPro RP", "SelfieStick RP", "MacBook Pro RP", "SunglassesRP", "JacketRP",
			"PenRP", "CalculatorRP", "Instrument Box RP", "Bicycle RP", "SnowboardPR",
			"PresentRP", "CosmeticsR", "Hairdryer RP", "GlovesRP", "AlbumRP",
			"PantsRP", "HatRP", "ScisorsRP", "CarpetRP", "FridgeRP",
			"ConditionerRP", "LegoRP", "LighterRP", "MirrorRP", "MonitorRP"};
	
	protected By emailFied = By.id("email");
	protected By passwordField = By.id("passwd");
	protected By signinButton = By.name("submitLogin");
	protected By logo = By.id("header_logo");
	protected By catalog = By.xpath("//*[@data-submenu='9']");
	protected By goods = By.xpath("//*[@data-submenu='10']");
	protected By newGoodButton = By.xpath("//*[@id='page-header-desc-configuration-add']");
	protected By goodNameField = By.id("form_step1_name_1");
	protected By quantityField = By.id("form_step1_qty_0_shortcut");
	protected By priceField = By.id("form_step1_price_shortcut");
	protected By switcher = By.className("switch-input");
	protected By popUpWindow = By.xpath("//*[@id='growls']/div/div[3]");
	protected By closePopup = By.xpath("//*[@id='growls']/div/div[1]");
	protected By saveButton = By.xpath("//*[@id='form']/div[4]/div[2]/div/button[1]/span");
	protected By allGoodsItem = By.xpath("//*[@id='content']/section/a");
	protected By createdGoodName = By.xpath("//*[@id='main']/div[1]/div[2]/h1");
	protected By createdGoodPrice = By.xpath("//*[@id='main']/div[1]/div[2]/div[1]/div[1]/div/span");
	protected By createdGoodQuantity = By.xpath("//*[@id='product-details']/div[1]/span");
	
	Random random = new Random();
	
	protected String randomValue() {
	int q = random.nextInt(100);
	String value = String.valueOf(q);
	return value;
	}
	
	protected String randomGood() {
		int r = random.nextInt(49);
		String good = goodNames[r];
		return good;
	}
}
