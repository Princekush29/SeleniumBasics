import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BadSSLCertificate {

	public static void main(String[] args) {
		
		// try to run two time, one by commenting line no 11 and 12 and without
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://badssl.com/");
		
		driver.findElement(By.xpath("//a[@href='https://self-signed.badssl.com/']")).click();
		
	}
}
