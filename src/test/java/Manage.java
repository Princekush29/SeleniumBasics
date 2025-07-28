import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Manage {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();// Selenium Manager
		driver.manage().window().maximize();
		driver.get("https:google.com");
		Set<Cookie> cookie = driver.manage().getCookies();
		Iterator<Cookie> itr = cookie.iterator();
		while (itr.hasNext()) {
			System.out.println("Cookie 1 is ");
			System.out.println(itr.next());
		}
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("NID");
	}
}
