package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiblingParentpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			String LoginText=driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
			System.out.println(LoginText);
			
			driver.close();
	}

}
