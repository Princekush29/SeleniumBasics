import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FindLinksInFooter extends Test1 {

	Helper h = new Helper();

	@Test
	public void webdriverScope() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// all the link present in the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Links count is " + links.size());

		// all the links present in the footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));

		System.out.println("Footer Links count is " + footerLinks.size());

		// all the links present in footer first colum
		WebElement columnDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		List<WebElement> footerFirstColumnLinks = columnDriver.findElements(By.tagName("a"));
		System.out.println("Links present in footer first columt " + footerFirstColumnLinks.size());

		// click on all the links and check if it working
		int i = 0;
		for (WebElement foolinks : footerFirstColumnLinks) {
			if (i != 0) {
				h.scrollDown(foolinks);
				String href = foolinks.getAttribute("href");
				System.out.println(href);
				driver.findElement(By.xpath("//a[@href='" + href + "']"))
						.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

			}
			i++;
			Thread.sleep(3000);
		}
		Set<String> s = driver.getWindowHandles();
		for (String title : s) {
			System.out.println("Title is "+driver.switchTo().window(title).getTitle());
		}

	}

}
