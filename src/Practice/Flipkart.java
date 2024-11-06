package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.flipkart.com/");
		
		WebElement search=driver.findElement(By.xpath("//input[@name='q']"));
		
		
		search.sendKeys("m");
		Thread.sleep(3000);
		//System.out.println(driver.findElement(By.xpath("//div[@class='YGcVZO _2VHNef']")).getText());

		List<WebElement> p=driver.findElements(By.xpath("//div[@class='YGcVZO _2VHNef']"));
		
		for(WebElement e:p) {

				String s=e.getText();
				System.out.println("s"+s);
				
				if(s.contains("mobile 5g"))
				{
					e.click();
					break;
				}
		}
		//search.submit();
		
	}

}
