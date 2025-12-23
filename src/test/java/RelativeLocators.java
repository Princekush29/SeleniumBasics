import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RelativeLocators extends BaseTest {

	@Test
	public void above() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		String text = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(text);

		WebElement emailInput = driver.findElement(By.cssSelector(
				"body app-root form-comp div[class='container'] form[class='ng-untouched ng-pristine ng-invalid'] div:nth-child(2) label:nth-child(1)"));
		driver.findElement(with(By.tagName("input")).below(emailInput)).sendKeys("abccom");

		Thread.sleep(2000);
		WebElement ic = driver.findElement(By.xpath("//label[@class='form-check-label']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(ic)).click();

		Thread.sleep(2000);
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		String s = driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText();
		System.out.println("Student text is " + s);

	}
}
