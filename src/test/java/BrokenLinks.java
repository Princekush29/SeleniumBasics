import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks extends BaseTest {

	@Test
	public void brokenLinks() throws IOException {

		driver.get("https://demo.guru99.com/test/ajax.html");
		List<WebElement> element = driver.findElements(By.tagName("a"));

		for (WebElement url : element) {
			String href = url.getAttribute("href");
			verifyUrl(href);
		}

	}

	public static void verifyUrl(String url) throws IOException {

		URL link = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
		httpURLConnection.connect();
		if (httpURLConnection.getResponseCode() == 200) {
			System.out.println(url + " Link is working " + httpURLConnection.getResponseMessage());
		} else {
			System.out.println("Link is not working " + link);
		}
	}
}
