package Selenium4New;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import  static org.openqa.selenium.support.locators.RelativeLocator.with;;

public class RelativeLocators {
	
	
	@Test
	public void testLocators() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEdit=  driver.findElement(By.xpath("//input[@name='name']"));
		
		String name=driver.findElement(with(By.tagName("label")).above(nameEdit)).getText();
		
		System.out.println("name"+name);
		
		
		WebElement dob=driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		
		WebElement iceCreamText=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamText)).click();
		
		
		WebElement radioB=driver.findElement(By.id("inlineRadio1"));
		
		
		String text=driver.findElement(with(By.tagName("label")).toRightOf(radioB)).getText();
		System.out.println(text);
		
		
		driver.close();
	}

}
