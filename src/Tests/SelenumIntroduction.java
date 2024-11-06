package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelenumIntroduction {

	public static void main(String[] args) {
		// Invoking browser
		// System.setProperty("webdriver.chrome.driver","/user/sonalisalunkhe/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");

		String title = driver.getTitle();
		System.out.println("Title:" + title);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		driver.close();

		// System.setProperty("webdriver.gecko.driver","/user/sonalisalunkhe/chrome/chromedriver");
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.flipkart.com/");

		String title1 = driver1.getTitle();
		System.out.println("Title:" + title1);

		String url1 = driver1.getCurrentUrl();
		System.out.println("URL:" + url1);
		driver1.close();
		
		// System.setProperty("webdriver.edge.driver", "/user/sonalisalunkhe/chrome/chromedriver");
				WebDriver driver2 = new EdgeDriver();
				driver2.get("https://www.flipkart.com/");
				String titl = driver2.getTitle();
				System.out.println("Title:" + titl);

				String url2 = driver2.getCurrentUrl();
				System.out.println("URL:" + url2);
				driver2.close();
			
	}

}
