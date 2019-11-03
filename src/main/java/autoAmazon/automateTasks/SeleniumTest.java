package autoAmazon.automateTasks;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");		
		//Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@class, 'nav-logo-link')]")).getAttribute("aria-label").contains("Amazon"));
		System.out.println("Verification is successful");
		driver.close();
	}

}
