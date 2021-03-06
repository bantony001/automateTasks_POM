package autoAmazon.amazonTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import autoAmazon.helper.Helper;
import autoAmazon.helper.ReadExcel;
import autoAmazon.pages.AddToCartPage;
import autoAmazon.pages.DeliveryAddressPage;
import autoAmazon.pages.HomePage;
import autoAmazon.pages.LoginPage;
import autoAmazon.pages.ProductPage;
import autoAmazon.pages.SearchResultPage;

public class SeleniumTest {	
		
		public static void main(String[] args) throws InterruptedException, IOException {
			
			WebDriver driver;
			HomePage homePage;
			SearchResultPage srPage;
			AddToCartPage atcPage;
			LoginPage loginPage;
			ProductPage pPage=null;
			DeliveryAddressPage deliveryAddPage;	
			ReadExcel readExcel;
			
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\eclipse-workspace\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");		
			driver.manage().window().maximize();
			Thread.sleep(3000);

			readExcel = new ReadExcel();
			String productName = readExcel.readSheet(1,0);
			homePage = new HomePage(driver);
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
			String userName = readExcel.readSheet(1,1);
			String password = readExcel.readSheet(1,2);
	        loginPage.enterUserCredentials(userName, password);
	        
	        //Delivery page is displayed
	        deliveryAddPage = new DeliveryAddressPage(driver);
	        String custName = readExcel.readSheet(1,3);
	        deliveryAddPage.verifyDeliveryPage(custName);	        
	        
			driver.close();
			
			//Close the parent window
	        driver.switchTo().window(parentWinHandle);
	        driver.close();
			System.out.println("Final Verification is successful");
		}		

}
