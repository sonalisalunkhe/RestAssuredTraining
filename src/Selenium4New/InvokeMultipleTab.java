package Selenium4New;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvokeMultipleTab {
	
	@Test
	public void test_MultipleTab() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEdit=  driver.findElement(By.xpath("//input[@name='name']"));
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		
		Set<String> hd=driver.getWindowHandles();
		
		Iterator<String> it=hd.iterator();
		String p=it.next();
		System.out.println(p);
		String c=it.next();
		System.out.println(c);

		
		driver.switchTo().window(c);
		
		driver.get("https://courses.rahulshettyacademy.com/#/index");
		
		String title=driver.findElements(By.cssSelector("a[href*='/p/']")).get(1).getText();
		
		System.out.println(title);

		driver.switchTo().window(p);
		
		WebElement name=driver.findElement(By.name("name"));
		
		name.sendKeys(title);
		
		File file=name.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("name.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int h =name.getRect().getDimension().getHeight();
		System.out.println(h);
		
		int w =name.getRect().getDimension().getWidth();
		System.out.println(w);
		driver.quit();

	}

}
