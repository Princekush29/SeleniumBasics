import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MultipleWindowsAndTabs extends BaseTest {

	Helper h = new Helper();

	@Test
	public void multipleWindows() throws InterruptedException, IOException {

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);

		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(2000);
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();

		// h.scrollDown(path);
		System.out.println("Course name is " + courseName);
		driver.switchTo().window(parentId);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//input[@name='name']"));
		element.sendKeys(courseName);

		// Take screenshot of page
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("C:\\Users\\Prince Kushwaha\\Desktop\\docs\\test1.png"));

		// get particular element screenshot
		File src2 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("C:\\Users\\Prince Kushwaha\\Desktop\\docs\\test2.png"));

		// get Full Page screenshot
		File src = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Prince Kushwaha\\Desktop\\docs\\test2.png"));

		Thread.sleep(2000);

	}
}
