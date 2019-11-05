package autoAmazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox' and @class ='nav-input']");
	By submitButton = By.xpath("//input[@class='nav-input' and @type='submit']");
	By loginTest = By.xpath("//h1[contains(text(), 'Login')]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyLoginPage() throws InterruptedException {
		System.out.println("Login Page");
		driver.findElement(loginTest).isDisplayed();
		Thread.sleep(3000);
	}
	
	public void enterUserCredentials(String userName, String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}
}
