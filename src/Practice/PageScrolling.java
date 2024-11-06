package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PageScrolling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> values=driver.findElements(By.xpath("//div[@class='tableFixHead']//table//tbody//tr//td[4]"));
		int sum=0;
		for(WebElement v:values)
		{
			String s=v.getText();
			
			int ss=Integer.parseInt(s);
			
			sum=sum+ss;
			

		}
		System.out.print(sum);
		
		
	String	result=driver.findElement(By.className("totalAmount")).getText();
	
	String result1=result.split(":")[1].trim();
	
	Assert.assertEquals(sum, Integer.parseInt(result1));
	
driver.close();
	}

}
