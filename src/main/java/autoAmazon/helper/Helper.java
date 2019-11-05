package autoAmazon.helper;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import autoAmazon.pages.ProductPage;

public class Helper {
	WebDriver driver;
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox' and @class ='nav-input']");
	By submitButton = By.xpath("//input[@class='nav-input' and @type='submit']");
	
	public Helper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToChildWindow(String parentWinHandle) throws InterruptedException {
		Set<String> winHandles = driver.getWindowHandles();
        for(String handle: winHandles){
            if(!handle.equals(parentWinHandle)){
	            driver.switchTo().window(handle);           
            }
        }
	}
	
}
