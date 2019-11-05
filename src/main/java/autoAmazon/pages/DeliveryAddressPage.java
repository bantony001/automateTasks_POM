package autoAmazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryAddressPage {
	WebDriver driver;
	String nameElement = "//div[@class='a-container']//form[1]//b[contains(text(), '";
	
	
	public DeliveryAddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyDeliveryPage(String name) throws InterruptedException {
		driver.findElement(By.xpath(nameElement + name + "')]")).isDisplayed();
		Thread.sleep(3000);
	}
}
