import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest { 

	public static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// For Webdriver manager - you need both line no. 12 and 13 - Maven dependency
		// required
		WebDriverManager.chromedriver().setup();// need a maven dependency
		driver = new ChromeDriver();

		// For Selenium manager - need only line no. 15 - no maven dependency required
		// WebDriver driver = new ChromeDriver();// Selenium Manager

		driver.manage().window().maximize();
		System.out.println("Browser maximized");

	}

	@AfterMethod
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}

	}
}
