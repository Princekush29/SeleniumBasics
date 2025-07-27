import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalenderTest extends Test1 {

	Helper h = new Helper();

	@Test
	public void calender() throws InterruptedException {

		String month = "6";
		String monthName = "June";
		String date = "15";
		String year = "2027";
		String expectedValue[] = { month, date, year };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']"))
				.click();
		driver.findElement(By.xpath(
				"//span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']"))
				.click();
		driver.findElement(By.xpath(
				"//span[@class='react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from']"))
				.click();
		// select year
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

		// select month

		driver.findElement(By.xpath("//abbr[text()='" + monthName + "']")).click();

		// select date
		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		Thread.sleep(3000);

		// get the date text
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i = 0; i < actualList.size(); i++) {
			String actuallValue = actualList.get(i).getAttribute("value");
			System.out.println("Actual value is "+ actuallValue);
			System.out.println("Expected value is "+ expectedValue[i]);
			Assert.assertEquals(actuallValue, expectedValue[i]);
		}

	}
}
