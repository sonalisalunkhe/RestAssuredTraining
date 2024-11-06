package StreamsPractice;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortTableWIithStream {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//table[@class='table table-bordered']//thead//tr//th[1]")).click();
		
		
		List<WebElement> vegs=driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		
		List<String> list=vegs.stream().map(s->s.getText()).collect(Collectors.toList());
		
		
		List<String> sorted=list.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(list.equals(sorted));
		List<String> price;
		do {
		
		price=	vegs.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
		
		price.forEach(s->System.out.println(s));
		
		if(price.size()>1) {
			
			driver.findElement(By.xpath("//a[@aria-label='First']")).click();
			
		}
		
		
		}while(price.size()>1);
		
		driver.close();
	}

	private static String getPrice(WebElement s) {
	String price=	s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
