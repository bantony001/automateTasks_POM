package autoAmazon.automateTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	WebDriver driver;
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox' and @class ='nav-input']");
	By submitButton = By.xpath("//input[@class='nav-input' and @type='submit']");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddToCart() throws InterruptedException {
		System.out.println("Add to Cart Verification");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button' and @class='a-button-input']")).click();
		Thread.sleep(3000);
	}
}
