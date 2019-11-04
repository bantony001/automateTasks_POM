package autoAmazon.automateTasks;

import java.util.Set;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");		
		driver.manage().window().maximize();
		//Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@class, 'nav-logo-link')]")).getAttribute("aria-label").contains("Amazon"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(), 'Chennai')]")).isDisplayed();
		System.out.println("Initial Verification is successful");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox' and @class ='nav-input']")).sendKeys("Philips PowerPro FC9352");
		driver.findElement(By.xpath("//input[@class='nav-input' and @type='submit']")).click();
		Thread.sleep(3000);
		
		//Handling windows
		String parentWinHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[contains(text(), 'Philips PowerPro FC9352/01')]")).click();
		Thread.sleep(3000);
		Set<String> winHandles = driver.getWindowHandles();
        for(String handle: winHandles){
            if(!handle.equals(parentWinHandle)){
	            driver.switchTo().window(handle);
	    		driver.findElement(By.xpath("//input[@id='add-to-cart-button' and @class='a-button-input']")).click();
	    		Thread.sleep(3000);
            }
        }


		driver.findElement(By.xpath("//a[@id = 'hlb-ptc-btn-native']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h1[contains(text(), 'Login')]")).isDisplayed();
		System.out.println("Verification is successful");
		driver.close();
        driver.switchTo().window(parentWinHandle);
        driver.close();
		System.out.println("Final Verification is successful");
	}
}
