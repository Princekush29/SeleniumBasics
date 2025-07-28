import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GetHeightAndWidthOfAnElement extends BaseTest {

	@Test
	public void getHeightAndWidthOfAnElement() {

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		int height = nameEditBox.getRect().getDimension().getHeight();
		int width = nameEditBox.getRect().getDimension().getWidth();
		System.out.println("Height is " + height);
		System.out.println("Width is " + width);
	}
}
