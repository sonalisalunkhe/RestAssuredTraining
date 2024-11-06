package Tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));


		driver.get("https://rahulshettyacademy.com/seleniumPractise");

		String[] names = { "Cucumber", "Brocolli", "Beetroot" };

		addItems(driver, names);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//explicit wait

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		driver.findElement(By.className("promoInfo")).getText();
	}

	public static void addItems(WebDriver driver, String[] names) {
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < products.size(); i++) {

			String name = products.get(i).getText();
			String[] arr = name.split("-");
			String formatted = arr[0].trim();
			// check name is present in array names
			// convert array to arraylist

			ArrayList<String> namelist = new ArrayList<>(Arrays.asList(names));

			int c = 0;
			if (namelist.contains(formatted)) {
				c++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (c == names.length)
					break;
			}

		}
	}

}
