package StreamsPractice;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Filter {
	
	@Test
	public void test_Filter() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> ele=driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		
		List<WebElement> filteretedEle= ele.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		
		
		Assert.assertEquals(ele.size(), filteretedEle.size());
		
		driver.close();
	}

}
