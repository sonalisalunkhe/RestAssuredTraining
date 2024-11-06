package Tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowhandlePractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//div[@class='example']//a")).click();
		
		
		
		Set<String> hd=driver.getWindowHandles();
		
		Iterator<String> h=hd.iterator();
		String p=h.next();
		String c=h.next();
		
		driver.switchTo().window(c);
		String newWin=driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
		System.out.println(newWin);
		
		driver.switchTo().window(p);
		
		String pWin=driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
		System.out.println(pWin);

		
		driver.close();
	}

}
