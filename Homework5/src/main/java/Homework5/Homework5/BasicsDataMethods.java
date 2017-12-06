package Homework5.Homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasicsDataMethods {
	
	protected WebDriver driver;
	
	protected String shopURL = "http://prestashop-automation.qatestlab.com.ua/ru/";
	protected String mainPageTitle = "prestashop-automation";
	protected String allGoodsTitle = "Главная";
	protected String clientFirstName = "Roman";
	protected String clientLastName = "TestUser";
	protected String clientEmail = "romantestqa29@gmail.com";
	protected String clientAddress = "Main Road 77/75";
	protected String clientPostCode = "33375";
	protected String clientCity = "Melburn";
	protected String confirmationMessage = "ВАШ ЗАКАЗ ПОДТВЕРЖДЁН";
	
	
	
	protected By allGoodsLink = By.xpath("//*[@id='content']/section/a");
	protected By productNameLink = By.linkText("Faded Short Sleeve T-shirts");
	protected By productName = By.xpath("//*[@id='main']/div[1]/div[2]/h1");
	protected By productPrice = By.xpath("//*[@id='main']/div[1]/div[2]/div[1]/div[1]/div/span");
	protected By productDescriprion = By.xpath("//*[@id='main']/div[1]/div[2]/div[2]/div[3]/ul/li[2]/a");
	protected By generalQuantity = By.xpath("//*[@id='product-details']/div[3]/span");
	protected By putIntoCart = By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div[1]/div[2]/button");
	protected By navigateOrderDetailsPage = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/a");
	protected By orderedProductName = By.xpath("//*[@id='main']/div/div[1]/div[1]/div[2]/ul/li/div/div[2]/div[1]/a");
	protected By orderedProductPrice = By.xpath("//*[@id='main']/div/div[1]/div[1]/div[2]/ul/li/div/div[2]/div[2]/span");
	protected By orderedProductQuantity = By.xpath("//*[@id='cart-subtotal-products']/span[1]");
	protected By processWithOrderButton = By.xpath("//*[@id='main']/div/div[2]/div/div[2]/div/a");
	protected By firstNameField = By.name("firstname");
	protected By lastNameField = By.name("lastname");
	protected By emailField = By.name("email");
	protected By continueButton = By.name("continue");
	protected By addressField = By.name("address1");
	protected By postCodeField = By.name("postcode");
	protected By cityField = By.name("city");
	protected By deliveryOptionsButton = By.name("confirm-addresses");
	protected By confirmDeliveryButton = By.name("confirmDeliveryOption");
	protected By paymentOption2 = By.xpath("//*[@id='payment-option-2-container']/label/span");
	protected By termsCheckBox = By.name("conditions_to_approve[terms-and-conditions]");
	protected By orderProductButton = By.xpath("//*[@id='payment-confirmation']/div[1]/button");
	protected By orderConfirmed = By.xpath("//*[@id='content-hook_order_confirmation']/div/div/div/h3");
	protected By orderedItemDetails = By.xpath("//*[@id='order-items']/div/div/div[2]/span");
	protected By orderedItemPrice = By.xpath("//*[@id='order-items']/div/div/div[3]/div/div[1]");
	protected By orderedItemCount = By.xpath("//*[@id='order-items']/div/div/div[3]/div/div[2]");
	protected By mainPageItem = By.xpath("//*[@id='_desktop_logo']/a/img");
	

}
