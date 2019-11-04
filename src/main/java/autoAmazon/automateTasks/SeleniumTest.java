package autoAmazon.automateTasks;

import java.util.Set;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {	
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver;
			HomePage homePage;
			SearchResultPage srPage;
			AddToCartPage atcPage;
			LoginPage loginPage;
			
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\eclipse-workspace\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");		
			driver.manage().window().maximize();
			//Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@class, 'nav-logo-link')]")).getAttribute("aria-label").contains("Amazon"));
			Thread.sleep(3000);

			homePage = new HomePage(driver);
			String productName = "Philips PowerPro FC9352";
			homePage.searchProduct(productName);
			
			//Search Result page is displayed
			srPage = new SearchResultPage(driver);
			srPage.clickResult(productName);			

			//Handling windows
			String parentWinHandle = driver.getWindowHandle();
			Set<String> winHandles = driver.getWindowHandles();
	        for(String handle: winHandles){
	            if(!handle.equals(parentWinHandle)){
		            driver.switchTo().window(handle);
		            
		    		//Selected Product page is displayed
		    		ProductPage pPage = new ProductPage(driver);
		    		pPage.clickAddToCart();	    		
		    		Thread.sleep(3000);
	            }
	        }

	        //Add to Cart page is displayed
	        atcPage = new AddToCartPage(driver);
	        atcPage.clickProceed();
			
	        //Login page is displayed
	        loginPage = new LoginPage(driver);
	        loginPage.verifyLoginPage();
			driver.close();
			
			//Close the parent window
	        driver.switchTo().window(parentWinHandle);
	        driver.close();
			System.out.println("Final Verification is successful");
		}
		

}
