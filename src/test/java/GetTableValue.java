import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetTableValue extends BaseTest {

	Helper h = new Helper();

	@Test
	public void tableValue() throws IOException {
		int sum = 0;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		h.screenshot();
		WebElement ele = driver.findElement(By.xpath("//th[text()='Name']"));
		h.scrollDown(ele);
		List<WebElement> list = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for (WebElement value : list) {
			System.out.println(value.getText());
			sum += Integer.parseInt(value.getText());
		}
		String number = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		System.out.println("Number is  " + number);
		Assert.assertEquals(number, "Total Amount Collected: " + sum);
	}
}
