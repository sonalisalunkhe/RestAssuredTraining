package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleCalenndarUI {

	public static void main(String[] args) throws InterruptedException {
		
		
		String year="2023";
		String month="5";

		String day="9";

		String[] expectedList = {month,day,year};


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//driver.findElement(By.linkText("Top Deals")).click();
	//	Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).click();
		
		
		
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();

		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		
		driver.findElements(By.xpath("//div[@class='react-calendar__year-view__months']//button")).get(Integer.parseInt(month)-1).click();
		
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();


		List<WebElement> date=driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));
		int i=0;
		for(WebElement d:date) {
			System.out.println(d.getAttribute("value"));
			Assert.assertEquals(d.getAttribute("value"), expectedList[i]);
			i++;

		}
		
		driver.close();
	}

}
