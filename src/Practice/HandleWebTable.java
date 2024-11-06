package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		
		int  row=driver.findElements(By.xpath("//div[@class='left-align']//table//tbody//tr")).size();
		
		System.out.println(row);
		
		int col=driver.findElements(By.xpath("//div[@class='left-align']//table//tbody//tr//th")).size();
		System.out.println(col);

		List<WebElement> details=driver.findElements(By.xpath("//div[@class='left-align']//table//tbody//tr[3]//td"));
		
		
		for(WebElement e:details) {
			System.out.print(e.getText());
		}
		driver.close();
	}

}
