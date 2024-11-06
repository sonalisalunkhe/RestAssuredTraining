package Tests;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String password=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("Sonali");
		driver.findElement(By.name("inputPassword")).sendKeys("123");
		driver.findElement(By.className("signInBtn")).click();
		String error=driver.findElement(By.cssSelector("p.error")).getText();
		
		System.out.println(error);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("jonh");
		driver.findElement(By.cssSelector("input[placeholder=\"Email\"")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@type=\"text\"][3]")).sendKeys("7798788978");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String error2=driver.findElement(By.cssSelector("form p")).getText();
		
		System.out.println(error2);
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[placeholder=\"Password\"]")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();

		driver.close();
		
	}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String error2=driver.findElement(By.cssSelector("form p")).getText();
		String[] password=error2.split("'");
		
		String[] pass=password[1].split(";");
		
		System.out.println(pass[0]);
		
		return pass[0];
	}

}
