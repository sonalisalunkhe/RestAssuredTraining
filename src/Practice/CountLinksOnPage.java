package Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinksOnPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int links=driver.findElements(By.tagName("a")).size();
		System.out.println(links);
		
		int flink=driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size();
		System.out.println(flink);
		
		int f1link=driver.findElements(By.xpath("//div[@id='gf-BIG']//table//tbody//tr//td[1]//ul//a")).size();
		System.out.println(f1link);
		
		//click on each link
		for(int i=1;i<f1link;i++) {
			
			String clickOnLinkTab=Keys.chord(Keys.COMMAND,Keys.ENTER);
			driver.findElements(By.xpath("//div[@id='gf-BIG']//table//tbody//tr//td[1]//ul//a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000);
		}
			Set<String> hd=driver.getWindowHandles();
			Iterator<String> it=hd.iterator();
			
			String p=it.next();
			
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				String title=driver.getTitle(); 
				System.out.println(title);
			}
			
		

		driver.close();
	}

}
