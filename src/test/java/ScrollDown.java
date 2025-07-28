import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollDown extends BaseTest {

	Helper h = new Helper();

	@Test
	public void scroll() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement ele = driver.findElement(By.xpath("//div[@class='totalAmount']"));
		
		h.scrollDownByCoordinates(0, 500);
		Thread.sleep(3000);
		
		h.scrollDown(ele);
		Thread.sleep(3000);
		// h.scrollDownByCoordinates(0,500);

	}
}
