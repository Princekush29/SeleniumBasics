import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class GetCSSValue {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/");

		WebElement element = driver.findElement(By.xpath("//h1[text()='Quick Access']"));
		String s = element.getCssValue("color");
		String c = Color.fromString(s).asHex();
		System.out.println("Colour is " + c);

		System.out.println("font-size = " + element.getCssValue("font-size"));
		System.out.println("font-weight = " + element.getCssValue("font-weight"));
		System.out.println("background = " + element.getCssValue("background"));
		System.out.println("line-height = " + element.getCssValue("line-height"));
		System.out.println("color = " + element.getCssValue("color"));
		System.out.println("font-family = " + element.getCssValue("font-family"));

	}
}
