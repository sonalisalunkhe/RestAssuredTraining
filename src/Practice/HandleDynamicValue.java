package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HandleDynamicValue {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement option=driver.findElement(By.id("checkBoxOption3"));
		
		option.click();
		String value=option.getText();
		
		Select opt=new Select(driver.findElement(By.id("dropdown-class-example")));
		opt.selectByValue(value);
		
		driver.findElement(By.cssSelector("input#name")).sendKeys(value);
		
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alText=driver.switchTo().alert().getText();
		
		boolean result=alText.contains(value);
		
		System.out.println(result);
		
		Assert.assertTrue(result);
		
		driver.switchTo().alert().accept();
		
		driver.close();
		}

}
