package Homework5.Homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasicsDataMethods {
	
	protected String shopURL = "http://prestashop-automation.qatestlab.com.ua/ru/";
	protected String mainPageTitle = "prestashop-automation";
	protected String allGoodsTitle = "Главная";
	
	
	
	protected By allGoodsLink = By.xpath("//*[@id='content']/section/a");

}
