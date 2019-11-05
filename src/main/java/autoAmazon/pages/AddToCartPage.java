package autoAmazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
	WebDriver driver;
	By proceedToBuyButton = By.xpath("//a[@id = 'hlb-ptc-btn-native']");
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProceed() throws InterruptedException {
		System.out.println("Add to Cart Verification");
		driver.findElement(proceedToBuyButton).click();
		Thread.sleep(3000);
	}
}
