package autoAmazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickResult(String productName) throws InterruptedException {
		System.out.println("Search Result Verification is successful");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(), '" + productName + "') and @class='a-size-medium a-color-base a-text-normal']")).click();
		Thread.sleep(3000);
	}	
}
