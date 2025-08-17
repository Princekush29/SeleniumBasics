import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTable extends BaseTest {

	@Test
	public void verifySortTable() {

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
		List<WebElement> elememt = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> originalList = elememt.stream().map(s -> s.getText()).collect(Collectors.toList());
		// elememt.stream().map(s -> s.getText()).forEach(s -> System.out.println(s));
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		// originalList.stream().sorted().forEach(s -> System.out.println(s));
		Assert.assertTrue(originalList.equals(sortedList));
	}

	@Test
	public void getPriceOfItem() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
		List<WebElement> elememt = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> vegName = elememt.stream().map(s -> s.getText()).collect(Collectors.toList());
		elememt.stream().map(s -> s.getText()).forEach(s -> System.out.println(s));

		List<WebElement> elememt1 = driver.findElements(By.xpath("/tr/td[2]"));
		List<String> priceList = elememt1.stream().map(s -> s.getText()).collect(Collectors.toList());
		elememt1.stream().map(s -> s.getText()).forEach(s -> System.out.println(s));

		List<String> price;
		// scan the veg name find rice and get the price of rice
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceveggie(s))

					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));

			// for pagination
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	public static String getPriceveggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

	@Test
	public void filter() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies = driver.findElements(By.xpath("//td//td[1]"));
		List<WebElement> filterList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(veggies.size(), filterList.size());

	}
}
