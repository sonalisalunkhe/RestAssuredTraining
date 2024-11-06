package Tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandleDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		String h=driver.getWindowHandle();
		System.out.println(h);

		
		Set<String> wh=driver.getWindowHandles();
		
		Iterator<String> it=wh.iterator();
		String parentid=it.next();
		System.out.println(parentid);

		String childd=it.next();
		System.out.println(childd);

		
		driver.switchTo().window(childd);
		
		String text=driver.findElement(By.cssSelector("p.im-para.red")).getText();
		System.out.println(text);
		
		String[] arr=text.split("at");
		String[] arr1=arr[1].split("with");
		String email=arr1[0].trim();
		System.out.println(email);
		
		driver.switchTo().window(parentid);
		
		driver.findElement(By.id("username")).sendKeys(email);


	}

}
