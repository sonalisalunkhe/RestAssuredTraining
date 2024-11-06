package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//String url=driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
		
		
	List<WebElement>	links=driver.findElements(By.xpath("//li[@class='gf-li']//a"));
	
	SoftAssert a=new SoftAssert();
	
	for(WebElement  link:links) {
		
		String url=link.getAttribute("href");

		HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int status=conn.getResponseCode();
		
		System.out.println(status);
		
		if(status>400) {
			
			a.assertTrue(false);
		}
		
	}
	
	a.assertAll();
		
	}

}
