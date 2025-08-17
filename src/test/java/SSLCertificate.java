import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificate extends BaseTest {

	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();

		// for proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipadress:4444");
		co.setCapability("proxy", proxy);

		// to bypass ssl certificate issue
		co.setAcceptInsecureCerts(true);

		// block pop up windows
		co.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		WebDriver driver = new ChromeDriver(co);// Selenium Manager

		driver.get("https://google.com");
	}
}
