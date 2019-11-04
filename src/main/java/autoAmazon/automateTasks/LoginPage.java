package autoAmazon.automateTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox' and @class ='nav-input']");
	By submitButton = By.xpath("//input[@class='nav-input' and @type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyLoginPage() throws InterruptedException {
		System.out.println("Login Page");
		driver.findElement(By.xpath("//h1[contains(text(), 'Login')]")).isDisplayed();
		Thread.sleep(3000);

	}
}
