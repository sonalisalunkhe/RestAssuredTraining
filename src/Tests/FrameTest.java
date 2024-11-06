package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://jqueryui.com/droppable/");
		
		int f =driver.findElements(By.tagName("iframe")).size();
		System.out.println(f);
		
		WebElement frame=driver.findElement(By.cssSelector("iframe.demo-frame"));
		//driver.switchTo().frame(frame);
		driver.switchTo().frame(0);
		
		WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement droppable=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions action=new Actions(driver);
		action.dragAndDrop(draggable, droppable).build().perform();
		driver.switchTo().defaultContent();
		
		driver.close();

		
}

}
