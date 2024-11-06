package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

driver.get("https://rahulshettyacademy.com/loginpagePractise");


driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
driver.findElement(By.id("password")).sendKeys("learning");

driver.findElement(By.xpath("//input[@value='user']//following-sibling::span")).click();
Thread.sleep(3000);

//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("okayBtn")));
driver.findElement(By.id("okayBtn")).click();

WebElement role=driver.findElement(By.xpath("//Select[@data-style='btn-info']"));

Select sel=new Select(role);
sel.selectByValue("stud");

//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#terms")));

driver.findElement(By.cssSelector("input#terms")).click();
driver.findElement(By.cssSelector("input#signInBtn")).click();

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.card.h-100")));


List<WebElement> phones=driver.findElements(By.cssSelector("div.card.h-100"));

for(WebElement phone:phones)
{
	driver.findElement(By.cssSelector("button.btn.btn-info")).click();
}
driver.findElement(By.cssSelector("a..nav-link.btn.btn-primary")).click();
	}

}
