package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input.inputs.ui-autocomplete-input")).sendKeys("ind");
		
		List<WebElement> eles=driver.findElements(By.xpath("//ul[@id='ui-id-1']//li//div"));
		
		for(WebElement e:eles) {
			String s=e.getText();
			if(s.equalsIgnoreCase("India")) {
				e.click();
				break;
			}
		}
		Thread.sleep(3000);
		String text=driver.findElement(By.cssSelector("input.inputs.ui-autocomplete-input")).getAttribute("value");
		
		System.out.print("text::"+text);
		
		driver.close();
	}

}
