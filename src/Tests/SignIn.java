package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SignIn {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
		
	String name="Rahul";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");

		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder=\"Password\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(3000);
		String text=driver.findElement(By.tagName("p")).getText();
		
		System.out.print(text);
		Assert.assertEquals(text, "You are successfully logged in.");
		
		String head=driver.findElement(By.cssSelector("div h2")).getText();
		
		Assert.assertEquals(head, "Hello "+name+",");
		
		driver.findElement(By.xpath("//button[text()=\"Log Out\"]")).click();
		driver.close();
	}
	
	

}
