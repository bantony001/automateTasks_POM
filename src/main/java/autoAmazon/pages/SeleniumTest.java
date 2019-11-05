package autoAmazon.pages;

import java.util.Set;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import autoAmazon.helper.Helper;

public class SeleniumTest {	
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver;
			HomePage homePage;
			SearchResultPage srPage;
			AddToCartPage atcPage;
			LoginPage loginPage;
			ProductPage pPage=null;
			DeliveryAddressPage deliveryAddPage;
			
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\eclipse-workspace\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");		
			driver.manage().window().maximize();
			Thread.sleep(3000);

			homePage = new HomePage(driver);
			String productName = "Philips PowerPro FC9352";
			homePage.searchProduct(productName);
			
			//Search Result page is displayed
			srPage = new SearchResultPage(driver);
			srPage.clickResult(productName);			
						
			String parentWinHandle = driver.getWindowHandle();
			
			Helper helper = new Helper(driver);
			helper.switchToChildWindow(parentWinHandle);
	        
    		//Selected Product page is displayed
    		pPage = new ProductPage(driver);
    		pPage.clickAddToCart();	    		
    		Thread.sleep(3000);	

	        //Add to Cart page is displayed
	        atcPage = new AddToCartPage(driver);
	        atcPage.clickProceed();
	        
	        //Login page is displayed
	        loginPage = new LoginPage(driver);
	        loginPage.verifyLoginPage();
	        loginPage.enterUserCredentials("bejoise.antony.in@gmail.com", "Amazon#143");
	        
	        //Delivery page is displayed
	        deliveryAddPage = new DeliveryAddressPage(driver);
	        deliveryAddPage.verifyDeliveryPage("Bejoise");	        
	        
			driver.close();
			
			//Close the parent window
	        driver.switchTo().window(parentWinHandle);
	        driver.close();
			System.out.println("Final Verification is successful");
		}		

}
