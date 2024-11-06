package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		Actions a=new Actions(driver);
		WebElement move=driver.findElement(By.cssSelector("a#nav-link-accountList"));
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		
		a.moveToElement(move).contextClick().build().perform();

	}

}
